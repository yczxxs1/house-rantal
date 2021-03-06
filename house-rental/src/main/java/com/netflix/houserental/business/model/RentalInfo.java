package com.netflix.houserental.business.model;

import java.util.Date;
import java.util.UUID;

public class RentalInfo {
    private String rentalInfoId;

    private String houseName;

    private String houseLocation;

    private Integer bedroomNum;

    private Integer livingRoomNum;

    private Integer bathroomNum;

    private String houseType;

    private String houseArea;

    private String elevator;

    private Double houseRent;

    private String paymentMethod;

    private Integer houseFloor;

    private Integer floorNum;

    private String parkingSpace;

    private String houseDesc;

    private String houseImgs;

    private String houseContactName;

    private String houseContactIdentity;

    private String houseContactPhone;

    private String rentalInfoUserId;

    private Date createTime;

    private Date updateTime;


    public RentalInfo() {
        this.rentalInfoId=UUID.randomUUID().toString();
        this.createTime=new Date();
        this.updateTime=new Date();
    }


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

    public String getRentalInfoId() {
        return rentalInfoId;
    }

    public void setRentalInfoId(String rentalInfoId) {
        this.rentalInfoId = rentalInfoId == null ? null : rentalInfoId.trim();
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
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator == null ? null : elevator.trim();
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
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
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
        this.parkingSpace = parkingSpace == null ? null : parkingSpace.trim();
    }

    public String getHouseDesc() {
        return houseDesc;
    }

    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc == null ? null : houseDesc.trim();
    }

    public String getHouseImgs() {
        return houseImgs;
    }

    public void setHouseImgs(String houseImgs) {
        this.houseImgs = houseImgs == null ? null : houseImgs.trim();
    }

    public String getHouseContactName() {
        return houseContactName;
    }

    public void setHouseContactName(String houseContactName) {
        this.houseContactName = houseContactName == null ? null : houseContactName.trim();
    }

    public String getHouseContactIdentity() {
        return houseContactIdentity;
    }

    public void setHouseContactIdentity(String houseContactIdentity) {
        this.houseContactIdentity = houseContactIdentity == null ? null : houseContactIdentity.trim();
    }

    public String getHouseContactPhone() {
        return houseContactPhone;
    }

    public void setHouseContactPhone(String houseContactPhone) {
        this.houseContactPhone = houseContactPhone == null ? null : houseContactPhone.trim();
    }

    public String getRentalInfoUserId() {
        return rentalInfoUserId;
    }

    public void setRentalInfoUserId(String rentalInfoUserId) {
        this.rentalInfoUserId = rentalInfoUserId == null ? null : rentalInfoUserId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}