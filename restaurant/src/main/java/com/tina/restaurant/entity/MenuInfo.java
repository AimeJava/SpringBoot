package com.tina.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuInfo {
    private Integer menuId;

    private String menuName;

    private Types type;

    private Long menuPrice;

    private String menuImage;

    private Integer menuBuys;

    private String menuRemark;

    private Integer menuDiscounts;

    private Date menuCreate;

    private Date menuModified;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Long getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Long menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }

    public Integer getMenuBuys() {
        return menuBuys;
    }

    public void setMenuBuys(Integer menuBuys) {
        this.menuBuys = menuBuys;
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark;
    }

    public Integer getMenuDiscounts() {
        return menuDiscounts;
    }

    public void setMenuDiscounts(Integer menuDiscounts) {
        this.menuDiscounts = menuDiscounts;
    }

    public Date getMenuCreate() {
        return menuCreate;
    }

    public void setMenuCreate(Date menuCreate) {
        this.menuCreate = menuCreate;
    }

    public Date getMenuModified() {
        return menuModified;
    }

    public void setMenuModified(Date menuModified) {
        this.menuModified = menuModified;
    }
}