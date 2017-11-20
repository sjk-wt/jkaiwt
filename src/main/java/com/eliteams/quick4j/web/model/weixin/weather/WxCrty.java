package com.eliteams.quick4j.web.model.weixin.weather;

public class WxCrty {
    private String id;

    private String crtyname;

    private String crtytext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCrtyname() {
        return crtyname;
    }

    public void setCrtyname(String crtyname) {
        this.crtyname = crtyname == null ? null : crtyname.trim();
    }

    public String getCrtytext() {
        return crtytext;
    }

    public void setCrtytext(String crtytext) {
        this.crtytext = crtytext == null ? null : crtytext.trim();
    }
}