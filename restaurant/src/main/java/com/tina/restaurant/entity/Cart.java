package com.tina.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonInclude;


public class Cart {
    private Integer userId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MenuInfo menuInfo;

    private Integer menuNumber;

    private Integer menuSubtotal;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public MenuInfo getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(MenuInfo menuInfo) {
        this.menuInfo = menuInfo;
    }

    public Integer getMenuNumber() {
        return menuNumber;
    }

    public Integer getMenuSubtotal() {
        return menuSubtotal;
    }

    public void setMenuSubtotal(Integer menuSubtotal) {
        this.menuSubtotal = menuSubtotal;
    }

    public void setMenuNumber(Integer menuNumber) {
        this.menuNumber = menuNumber;
    }
}