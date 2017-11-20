package com.eliteams.quick4j.web.model.administrate;

import java.util.Date;

public class Customer {
    private String id;

    private String name;

    private String phone;

    private String wx;

    private String qq;

    private String email;

    private String remak;

    private Date instertime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx == null ? null : wx.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRemak() {
        return remak;
    }

    public void setRemak(String remak) {
        this.remak = remak == null ? null : remak.trim();
    }

    public Date getInstertime() {
        return instertime;
    }

    public void setInstertime(Date instertime) {
        this.instertime = instertime;
    }
}