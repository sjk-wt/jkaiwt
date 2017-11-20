package com.eliteams.quick4j.web.model.weixin.muen;

/**
 * Created by hccl on 2017/11/18.
 */
public class ComplexButton extends BaseButton {
    private BaseButton[] sub_button;

    public BaseButton[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(BaseButton[] sub_button) {
        this.sub_button = sub_button;
    }
}
