package com.eliteams.quick4j.web.model.weixin.message;

/**
 * Created by hccl on 2017/11/16.
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
