package com.eliteams.quick4j.web.model.weixin.muen;

/**
 * Created by hccl on 2017/11/18.
 */
public class ClickButton extends BaseButton {
    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
