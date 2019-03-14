package com.tina.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPwd;

    private Date adminCreate;

    private Date adminModified;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    public Date getAdminCreate() {
        return adminCreate;
    }

    public void setAdminCreate(Date adminCreate) {
        this.adminCreate = adminCreate;
    }

    public Date getAdminModified() {
        return adminModified;
    }

    public void setAdminModified(Date adminModified) {
        this.adminModified = adminModified;
    }
}