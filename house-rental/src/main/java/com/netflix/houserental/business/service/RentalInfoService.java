package com.netflix.houserental.business.service;

import com.netflix.houserental.business.condition.Condition;
import com.netflix.houserental.business.exception.RentalInfoNotFoundException;
import com.netflix.houserental.business.form.RentalInfoPostForm;
import com.netflix.houserental.business.model.RentalInfo;

import java.io.File;
import java.util.List;

public interface RentalInfoService {
    void postRentalInfo(RentalInfo rentalInfo,List<File> destFiles) throws Exception;

    void postRentalInfo(RentalInfo rentalInfo) throws Exception;

    List<RentalInfo> listRentalInfo(Condition condition);

    RentalInfo getRentalInfo(String rentalInfoId) throws RentalInfoNotFoundException;

    void removeRentalInfo(String rentalInfoId);

    void updateRentalInfo(RentalInfo rentalInfo) throws RentalInfoNotFoundException;


}
