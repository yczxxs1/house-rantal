package com.netflix.houserental.business.model;

public class RentalInfo {
    private String rentalInfoId;

    private Integer bedroomNum;

    private Integer livingRoomNum;

    private Integer bathroomNum;

    private String houseType;

    private Integer houseFloor;

    private Integer floorNum;

    private String parkingSpace;

    private String houseDesc;

    private String houseImgs;

    private String houseContactName;

    private String houseContactIdentity;

    private String houseContactPhone;

    private String rentalInfoUserId;

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
}