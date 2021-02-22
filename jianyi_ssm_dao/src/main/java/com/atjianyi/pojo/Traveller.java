package com.atjianyi.pojo;

/**
 * @author 简一
 * @className Traveller
 * @Date 2021/2/22 15:42
 **/
public class Traveller {
    private String id;//uuid
    private String travelerName;//旅客姓名
    private String travellerSex;//旅客性别
    private String travellerPhone;//旅客电话
    private int travellerCredentialsType;//证件类型|0身份证|1护照|2军官证|
    private String travellerCredentialsNum;//证件号码
    private int travellerType;//类型 |0成人|1儿童

    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", travelerName='" + travelerName + '\'' +
                ", travellerSex='" + travellerSex + '\'' +
                ", travellerPhone='" + travellerPhone + '\'' +
                ", travellerCredentialsType=" + travellerCredentialsType +
                ", travellerCredentialsNum='" + travellerCredentialsNum + '\'' +
                ", travellerType=" + travellerType +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTravelerName() {
        return travelerName;
    }

    public void setTravelerName(String travelerName) {
        this.travelerName = travelerName;
    }

    public String getTravellerSex() {
        return travellerSex;
    }

    public void setTravellerSex(String travellerSex) {
        this.travellerSex = travellerSex;
    }

    public String getTravellerPhone() {
        return travellerPhone;
    }

    public void setTravellerPhone(String travellerPhone) {
        this.travellerPhone = travellerPhone;
    }

    public int getTravellerCredentialsType() {
        return travellerCredentialsType;
    }

    public void setTravellerCredentialsType(int travellerCredentialsType) {
        this.travellerCredentialsType = travellerCredentialsType;
    }

    public String getTravellerCredentialsNum() {
        return travellerCredentialsNum;
    }

    public void setTravellerCredentialsNum(String travellerCredentialsNum) {
        this.travellerCredentialsNum = travellerCredentialsNum;
    }

    public int getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(int travellerType) {
        this.travellerType = travellerType;
    }
}
