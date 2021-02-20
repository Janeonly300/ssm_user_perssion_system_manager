package com.atjianyi.pojo;

import java.util.Date;

/**
 * @author 简一
 * @className Product
 * @Date 2021/2/19 16:14
 **/
public class Product {
   private String id;
   private String productNum;
   private String productName;
   private String startCityName;
   private String startDateTime;
   private double productPrice;
   private String productDesc;
   private String productStatus;

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

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
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
