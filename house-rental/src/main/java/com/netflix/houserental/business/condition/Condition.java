package com.netflix.houserental.business.condition;

public class Condition {
    private String userName;

    private String password;

    private Double minRent;

    private Double maxRent;

    private Integer bedroomNum;

    private String houseContactIdentity;

    private String rentalInfoUserId;

    public String getRentalInfoUserId() {
        return rentalInfoUserId;
    }

    public void setRentalInfoUserId(String rentalInfoUserId) {
        this.rentalInfoUserId = rentalInfoUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMinRent() {
        return minRent;
    }

    public void setMinRent(Double minRent) {
        this.minRent = minRent;
    }

    public Double getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(Double maxRent) {
        this.maxRent = maxRent;
    }

    public Integer getBedroomNum() {
        return bedroomNum;
    }

    public void setBedroomNum(Integer bedroomNum) {
        this.bedroomNum = bedroomNum;
    }

    public String getHouseContactIdentity() {
        return houseContactIdentity;
    }

    public void setHouseContactIdentity(String houseContactIdentity) {
        this.houseContactIdentity = houseContactIdentity;
    }
}
