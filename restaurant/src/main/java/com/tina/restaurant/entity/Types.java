package com.tina.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Types {
    private Integer typeId;

    private String typeName;

    private Date typeCreate;

    private Date typeModified;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Date getTypeCreate() {
        return typeCreate;
    }

    public void setTypeCreate(Date typeCreate) {
        this.typeCreate = typeCreate;
    }

    public Date getTypeModified() {
        return typeModified;
    }

    public void setTypeModified(Date typeModified) {
        this.typeModified = typeModified;
    }
}