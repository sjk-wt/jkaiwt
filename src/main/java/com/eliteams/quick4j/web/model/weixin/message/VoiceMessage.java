package com.eliteams.quick4j.web.model.weixin.message;

/**
 * Created by hccl on 2017/11/16.
 */
public class VoiceMessage extends BaseMessage {

    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
