package com.atjianyi.pojo;

import com.atjianyi.utils.DateAndStrUtils;

import java.util.Date;
import java.util.List;

/**
 * @author 简一
 * @className Orders
 * @Date 2021/2/22 15:42
 **/
public class Orders {
    private String id;//uuid
    private String ordersNum;//订单编号
    private Date ordersTime;//下单时间
    private String orderTimeStr;//格式化时间格式
    private Integer ordersPeopleCount;//订单包含的人数
    private String ordersDesc; //订单的描述
    private Integer ordersPayType; //支付方式
    private String ordersPayTypeStr;//支付描述
    private Integer ordersStatus; //支付状态
    private String orderStatusStr; //状态描述
    private Product product;//商品
    private Member member; //会员
    private List<Traveller> travellers;//包含的旅客

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdersNum() {
        return ordersNum;
    }

    public void setOrdersNum(String ordersNum) {
        this.ordersNum = ordersNum;
    }

    public Date getOrdersTime() {
        return ordersTime;
    }

    public void setOrdersTime(Date ordersTime) {
        this.ordersTime = ordersTime;
    }

    public String getOrderTimeStr() {
        if(ordersTime!=null){
           orderTimeStr = DateAndStrUtils.dateToStr(ordersTime,"yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrdersPeopleCount() {
        return ordersPeopleCount;
    }

    public void setOrdersPeopleCount(int ordersPeopleCount) {
        this.ordersPeopleCount = ordersPeopleCount;
    }

    public String getOrdersDesc() {
        return ordersDesc;
    }

    public void setOrdersDesc(String ordersDesc) {
        this.ordersDesc = ordersDesc;
    }

    public int getOrdersPayType() {
        return ordersPayType;
    }

    public void setOrdersPayType(int ordersPayType) {
        this.ordersPayType = ordersPayType;
    }

    public int getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(int ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", ordersNum='" + ordersNum + '\'' +
                ", ordersTime=" + ordersTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", ordersPeopleCount=" + ordersPeopleCount +
                ", ordersDesc='" + ordersDesc + '\'' +
                ", ordersPayType=" + ordersPayType +
                ", ordersStatus=" + ordersStatus +
                ", product=" + product +
                ", member=" + member +
                ", travellers=" + travellers +
                '}';
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public String getOrdersPayTypeStr() {
       if(ordersPayType !=null){
           if(ordersPayType == 0){
               ordersPayTypeStr = "支付宝";
           }
           if(ordersPayType == 1){
               ordersPayTypeStr = "微信";
           }
           if(ordersPayType == 2){
               ordersPayTypeStr = "其他";
           }
       }
       return ordersPayTypeStr;
    }

    public void setOrdersPayTypeStr(String ordersPayTypeStr) {
        this.ordersPayTypeStr = ordersPayTypeStr;
    }

    public String getOrderStatusStr() {
       if(ordersStatus != null){
           if(ordersStatus == 0){
               orderStatusStr = "支付成功";
           }
           if(ordersStatus == 1){
               orderStatusStr = "未支付";
           }
       }
       return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }
}
