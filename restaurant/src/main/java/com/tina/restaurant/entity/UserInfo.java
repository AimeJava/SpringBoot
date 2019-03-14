package com.tina.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String userPhotos;

    private Integer addressId;

    private String userTel;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userCreate;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userModified;

    private Integer discountId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserPhotos() {
        return userPhotos;
    }

    public void setUserPhotos(String userPhotos) {
        this.userPhotos = userPhotos == null ? null : userPhotos.trim();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public Date getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Date userCreate) {
        this.userCreate = userCreate;
    }

    public Date getUserModified() {
        return userModified;
    }

    public void setUserModified(Date userModified) {
        this.userModified = userModified;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }
}