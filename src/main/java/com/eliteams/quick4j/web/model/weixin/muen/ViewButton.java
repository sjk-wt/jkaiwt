package com.eliteams.quick4j.web.model.weixin.muen;

/**
 * Created by hccl on 2017/11/18.
 */
public class ViewButton extends BaseButton {
    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
