package com.atjianyi.pojo;

import java.util.Date;

/**
 * @author 简一
 * @className Product
 * @Date 2021/2/19 16:14
 **/
public class Product {
    private String id; //唯一UUID
    private String product_num; // 产品编号
    private String product_name; //产品名称
    private String start_city_name; //城市名称
    private Date start_date_time; //出发时间
    private Double product_price; // 价格
    private int product_status; // 状态 1开0关

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", product_num='" + product_num + '\'' +
                ", product_name='" + product_name + '\'' +
                ", start_city_name='" + start_city_name + '\'' +
                ", start_date_time=" + start_date_time +
                ", product_price=" + product_price +
                ", product_status=" + product_status +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getStart_city_name() {
        return start_city_name;
    }

    public void setStart_city_name(String start_city_name) {
        this.start_city_name = start_city_name;
    }

    public Date getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(Date start_date_time) {
        this.start_date_time = start_date_time;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_status() {
        return product_status;
    }

    public void setProduct_status(int product_status) {
        this.product_status = product_status;
    }

    public Product() {
    }

    public Product(String id, String product_num, String product_name, String start_city_name, Date start_date_time, Double product_price, int product_status) {
        this.id = id;
        this.product_num = product_num;
        this.product_name = product_name;
        this.start_city_name = start_city_name;
        this.start_date_time = start_date_time;
        this.product_price = product_price;
        this.product_status = product_status;
    }
}
