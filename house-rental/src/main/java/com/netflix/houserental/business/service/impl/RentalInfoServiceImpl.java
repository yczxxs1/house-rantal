package com.netflix.houserental.business.service.impl;

import com.netflix.houserental.business.condition.Condition;
import com.netflix.houserental.business.dao.RentalInfoMapper;
import com.netflix.houserental.business.exception.RentalInfoNotFoundException;
import com.netflix.houserental.business.model.RentalInfo;
import com.netflix.houserental.business.service.RentalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class RentalInfoServiceImpl implements RentalInfoService {

    private final RentalInfoMapper rentalInfoMapper;

    @Autowired
    public RentalInfoServiceImpl(RentalInfoMapper rentalInfoMapper) {
        this.rentalInfoMapper = rentalInfoMapper;
    }

    @Override
    public void postRentalInfo(RentalInfo rentalInfo, List<File> files) throws Exception {

        StringBuilder houseImgs = new StringBuilder();
        for (File file : files) {
            houseImgs.append("/").append(file.getName()).append(";");
        }
        rentalInfo.setHouseImgs(houseImgs.toString());
        rentalInfoMapper.insert(rentalInfo);

    }

    @Override
    public void postRentalInfo(RentalInfo rentalInfo)  {
        rentalInfoMapper.insert(rentalInfo);
    }

    @Override
    public List<RentalInfo> listRentalInfo(Condition condition) {

        return rentalInfoMapper.selectListByCondition(condition);
    }

    @Override
    public RentalInfo getRentalInfo(String rentalInfoId) throws RentalInfoNotFoundException {

        RentalInfo rentalInfo=rentalInfoMapper.selectByPrimaryKey(rentalInfoId);
        if(rentalInfo==null)
            throw new RentalInfoNotFoundException();
        return rentalInfo;
    }

    @Override
    public void removeRentalInfo(String rentalInfoId) {
        rentalInfoMapper.deleteByPrimaryKey(rentalInfoId);

    }

    @Override
    public void updateRentalInfo(RentalInfo rentalInfo) throws RentalInfoNotFoundException {
        //校验是否存在
        getRentalInfo(rentalInfo.getRentalInfoId());
        rentalInfoMapper.updateByPrimaryKeySelective(rentalInfo);
    }
}
