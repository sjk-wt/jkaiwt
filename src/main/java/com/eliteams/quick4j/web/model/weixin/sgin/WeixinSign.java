package com.eliteams.quick4j.web.model.weixin.sgin;

import java.util.Date;

public class WeixinSign {
    private String id;

    private String openId;

    private Date signTime;

    private Integer signPoints;

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

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getSignPoints() {
        return signPoints;
    }

    public void setSignPoints(Integer signPoints) {
        this.signPoints = signPoints;
    }
}