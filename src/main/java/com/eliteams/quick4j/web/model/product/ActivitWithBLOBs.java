package com.eliteams.quick4j.web.model.product;

public class ActivitWithBLOBs extends Activit {
    private String activitytxt;

    private String videotxt;

    private String covertxt;

    public String getActivitytxt() {
        return activitytxt;
    }

    public void setActivitytxt(String activitytxt) {
        this.activitytxt = activitytxt == null ? null : activitytxt.trim();
    }

    public String getVideotxt() {
        return videotxt;
    }

    public void setVideotxt(String videotxt) {
        this.videotxt = videotxt == null ? null : videotxt.trim();
    }

    public String getCovertxt() {
        return covertxt;
    }

    public void setCovertxt(String covertxt) {
        this.covertxt = covertxt == null ? null : covertxt.trim();
    }
}