package com.tina.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderInfo {

    private Integer orderId;

    private String orderNumber;

    private String orderState;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    private String orderPayState;

    private String orderRemark;

    private Date orderCreate;

    private Date orderModified;
    //用户
    private UserInfo userInfo;
    //地址
    private Address address;
    //订单详情
    private List<OrderDetail> detailList;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderPayState() {
        return orderPayState;
    }

    public void setOrderPayState(String orderPayState) {
        this.orderPayState = orderPayState == null ? null : orderPayState.trim();
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getOrderCreate() {
        return orderCreate;
    }

    public void setOrderCreate(Date orderCreate) {
        this.orderCreate = orderCreate;
    }

    public Date getOrderModified() {
        return orderModified;
    }

    public void setOrderModified(Date orderModified) {
        this.orderModified = orderModified;
    }

    public List<OrderDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderDetail> detailList) {
        this.detailList = detailList;
    }
}