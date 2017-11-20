package com.eliteams.quick4j.web.model.product;

import java.util.Date;

public class Activit {
    private String id;

    private String name;

    private Date activitystarttime;

    private String activityimg;

    private String videourl;

    private Integer isactivity;

    private String proid;

    private Date activityendtime;

    private String coverpic;

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

    public Date getActivitystarttime() {
        return activitystarttime;
    }

    public void setActivitystarttime(Date activitystarttime) {
        this.activitystarttime = activitystarttime;
    }

    public String getActivityimg() {
        return activityimg;
    }

    public void setActivityimg(String activityimg) {
        this.activityimg = activityimg == null ? null : activityimg.trim();
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }

    public Integer getIsactivity() {
        return isactivity;
    }

    public void setIsactivity(Integer isactivity) {
        this.isactivity = isactivity;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    public Date getActivityendtime() {
        return activityendtime;
    }

    public void setActivityendtime(Date activityendtime) {
        this.activityendtime = activityendtime;
    }

    public String getCoverpic() {
        return coverpic;
    }

    public void setCoverpic(String coverpic) {
        this.coverpic = coverpic == null ? null : coverpic.trim();
    }
}