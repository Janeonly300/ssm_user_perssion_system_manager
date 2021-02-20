package com.atjianyi.pojo;

import com.atjianyi.utils.DateAndStrUtils;

import java.util.Date;

/**
 * @author 简一
 * @className Product
 * @Date 2021/2/19 16:14
 **/
public class Product {
    private String id; // uuid
    private String productNum; //编号
    private String productName; // 产品名称
    private String startCityName;//城市名称
    private Date startDateTime;//开始时间
    private double productPrice;//产品价格
    private String productDesc;//描述
    private String productStatus;//状态
    private String startDateStr; // 格式化时间
    private String statusStr; //格式化状态

    public String getStartDateStr() {
        if(startDateTime !=null){
            startDateStr = DateAndStrUtils.dateToStr(startDateTime,"yyyy年MM月dd日-HH时mm分:ss秒");
        }
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getStatusStr() {
        if(productStatus !=null){
            if(productStatus.equals("0")){
                statusStr =  "关闭中...";
            }
            if(productStatus.equals("1")){
                statusStr =  "售票中...";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", startCityName='" + startCityName + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus='" + productStatus + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStartCityName() {
        return startCityName;
    }

    public void setStartCityName(String startCityName) {
        this.startCityName = startCityName;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
