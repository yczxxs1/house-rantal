package com.netflix.houserental.business.dao;

import com.netflix.houserental.business.condition.Condition;
import com.netflix.houserental.business.model.RentalInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RentalInfoMapper {
    int deleteByPrimaryKey(String rentalInfoId);

    int insert(RentalInfo record);

    int insertSelective(RentalInfo record);

    RentalInfo selectByPrimaryKey(String rentalInfoId);

    List<RentalInfo> selectListByCondition(Condition condition);

    int updateByPrimaryKeySelective(RentalInfo record);

    int updateByPrimaryKey(RentalInfo record);
}