package com.netflix.houserental.business.form;

import com.netflix.houserental.common.exception.ServiceException;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;

public class RentalInfoPostForm {

    @NotEmpty
    private String houseName;

    @NotEmpty
    private String houseLocation;

    @NotEmpty
    private Integer bedroomNum;

    @NotEmpty
    private Integer livingRoomNum;

    @NotEmpty
    private Integer bathroomNum;

    @NotEmpty
    private String houseType;

    @NotEmpty
    private String houseArea;

    @NotEmpty
    private String elevator;

    @NotEmpty
    private Double houseRent;

    @NotEmpty
    private String paymentMethod;

    @NotEmpty
    private Integer houseFloor;

    @NotEmpty
    private Integer floorNum;

    @NotEmpty
    private String parkingSpace;

    @NotEmpty
    private String houseDesc;

    @NotEmpty
    private String houseImgs;

    @NotEmpty
    private String houseContactName;

    @NotEmpty
    private String houseContactIdentity;

    @NotEmpty
    private String houseContactPhone;

    @NotEmpty
    private String rentalInfoUserId;

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public Double getHouseRent() {
        return houseRent;
    }

    public void setHouseRent(Double houseRent) {
        this.houseRent = houseRent;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getBedroomNum() {
        return bedroomNum;
    }

    public void setBedroomNum(Integer bedroomNum) {
        this.bedroomNum = bedroomNum;
    }

    public Integer getLivingRoomNum() {
        return livingRoomNum;
    }

    public void setLivingRoomNum(Integer livingRoomNum) {
        this.livingRoomNum = livingRoomNum;
    }

    public Integer getBathroomNum() {
        return bathroomNum;
    }

    public void setBathroomNum(Integer bathroomNum) {
        this.bathroomNum = bathroomNum;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Integer getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(Integer houseFloor) {
        this.houseFloor = houseFloor;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public String getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(String parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public String getHouseDesc() {
        return houseDesc;
    }

    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc;
    }

    public String getHouseImgs() {
        return houseImgs;
    }

    public void setHouseImgs(String houseImgs) {
        this.houseImgs = houseImgs;
    }

    public String getHouseContactName() {
        return houseContactName;
    }

    public void setHouseContactName(String houseContactName) {
        this.houseContactName = houseContactName;
    }

    public String getHouseContactIdentity() {
        return houseContactIdentity;
    }

    public void setHouseContactIdentity(String houseContactIdentity) {
        this.houseContactIdentity = houseContactIdentity;
    }

    public String getHouseContactPhone() {
        return houseContactPhone;
    }

    public void setHouseContactPhone(String houseContactPhone) {
        this.houseContactPhone = houseContactPhone;
    }

    public String getRentalInfoUserId() {
        return rentalInfoUserId;
    }

    public void setRentalInfoUserId(String rentalInfoUserId) {
        this.rentalInfoUserId = rentalInfoUserId;
    }

    public void validate(){
        if (StringUtils.isEmpty(getBathroomNum())
                || StringUtils.isEmpty(getBedroomNum())
                || StringUtils.isEmpty(getElevator())

                ) {
            throw new ServiceException("the params are not correct!");
        }

    }
}
