package com.netflix.houserental.business.dao;

import com.netflix.houserental.business.model.RentalInfo;

public interface RentalInfoMapper {
    int deleteByPrimaryKey(String rentalInfoId);

    int insert(RentalInfo record);

    int insertSelective(RentalInfo record);

    RentalInfo selectByPrimaryKey(String rentalInfoId);

    int updateByPrimaryKeySelective(RentalInfo record);

    int updateByPrimaryKey(RentalInfo record);
}