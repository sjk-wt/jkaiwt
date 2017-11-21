package com.eliteams.quick4j.web.model.weixin.pojo;

public class WeixinConfig {
    private String wxToken;

    private String wxAppid;

    private String wxEncodingaeskey;

    private String wxAccessToken;

    private String wxProjectUrl;

    public String getWxToken() {
        return wxToken;
    }

    public void setWxToken(String wxToken) {
        this.wxToken = wxToken == null ? null : wxToken.trim();
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid == null ? null : wxAppid.trim();
    }

    public String getWxEncodingaeskey() {
        return wxEncodingaeskey;
    }

    public void setWxEncodingaeskey(String wxEncodingaeskey) {
        this.wxEncodingaeskey = wxEncodingaeskey == null ? null : wxEncodingaeskey.trim();
    }

    public String getWxAccessToken() {
        return wxAccessToken;
    }

    public void setWxAccessToken(String wxAccessToken) {
        this.wxAccessToken = wxAccessToken == null ? null : wxAccessToken.trim();
    }

    public String getWxProjectUrl() {
        return wxProjectUrl;
    }

    public void setWxProjectUrl(String wxProjectUrl) {
        this.wxProjectUrl = wxProjectUrl == null ? null : wxProjectUrl.trim();
    }
}