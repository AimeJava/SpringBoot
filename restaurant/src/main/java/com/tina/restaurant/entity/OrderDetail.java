package com.tina.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetail {
    private Integer orderId;

    private String menuName;

    private Integer menuCounts;

    private Date orderCreate;

    private Date orderModified;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuCounts() {
        return menuCounts;
    }

    public void setMenuCounts(Integer menuCounts) {
        this.menuCounts = menuCounts;
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
}