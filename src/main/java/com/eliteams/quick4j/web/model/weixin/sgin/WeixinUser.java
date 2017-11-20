package com.eliteams.quick4j.web.model.weixin.sgin;

import java.util.Date;

public class WeixinUser {

    public static final Integer GUANZHU = 1;

    public static final Integer QUXIAOGUANZHU = 0;

    private String id;

    private String openId;

    private Date subscribeTime;

    private Integer subscribeStatus;

    private Integer points;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Integer getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(Integer subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}