package com.atjianyi.pojo;

import com.atjianyi.utils.DateAndStrUtils;

import java.util.Date;

/**
 * @author 简一
 * @className SystemLog
 * @Date 2021/3/5 14:59
 **/
public class SystemLog {
    private Integer id;//自增长
    private Date systemLogVisitTime;//时间
    private String systemLogVisitTimeStr; //时间格式化
    private String systemLogUserName;//访问的用户名
    private String systemLogIp;// IP地址
    private String systemLogUrl;//访问的URL

    @Override
    public String toString() {
        return "SystemLog{" +
                "id=" + id +
                ", systemLogVisitTime=" + systemLogVisitTime +
                ", systemLogVisitTimeStr='" + systemLogVisitTimeStr + '\'' +
                ", systemLogUserName='" + systemLogUserName + '\'' +
                ", systemLogIp='" + systemLogIp + '\'' +
                ", systemLogUrl='" + systemLogUrl + '\'' +
                ", systemLogMethod='" + systemLogMethod + '\'' +
                ", systemLogExecutionTime='" + systemLogExecutionTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSystemLogVisitTime() {
        return systemLogVisitTime;
    }

    public void setSystemLogVisitTime(Date systemLogVisitTime) {
        this.systemLogVisitTime = systemLogVisitTime;
    }

    public String getSystemLogVisitTimeStr() {
        if(systemLogVisitTime!=null){
          systemLogVisitTimeStr =  DateAndStrUtils.dateToStr(systemLogVisitTime,"yyyy-MM-dd HH:mm:ss");
        }
        return systemLogVisitTimeStr;
    }

    public void setSystemLogVisitTimeStr(String systemLogVisitTimeStr) {
        this.systemLogVisitTimeStr = systemLogVisitTimeStr;
    }

    public String getSystemLogUserName() {
        return systemLogUserName;
    }

    public void setSystemLogUserName(String systemLogUserName) {
        this.systemLogUserName = systemLogUserName;
    }

    public String getSystemLogIp() {
        return systemLogIp;
    }

    public void setSystemLogIp(String systemLogIp) {
        this.systemLogIp = systemLogIp;
    }

    public String getSystemLogUrl() {
        return systemLogUrl;
    }

    public void setSystemLogUrl(String systemLogUrl) {
        this.systemLogUrl = systemLogUrl;
    }

    public String getSystemLogMethod() {
        return systemLogMethod;
    }

    public void setSystemLogMethod(String systemLogMethod) {
        this.systemLogMethod = systemLogMethod;
    }

    public Long getSystemLogExecutionTime() {
        return systemLogExecutionTime;
    }

    public void setSystemLogExecutionTime(Long systemLogExecutionTime) {
        this.systemLogExecutionTime = systemLogExecutionTime;
    }

    private String systemLogMethod;//访问的方法名
    private Long systemLogExecutionTime;//执行的时间
}
