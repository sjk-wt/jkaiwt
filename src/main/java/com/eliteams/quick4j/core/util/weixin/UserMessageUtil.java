package com.eliteams.quick4j.core.util.weixin;

import com.eliteams.quick4j.web.controller.timedtasks.TimedTasks;
import com.eliteams.quick4j.web.model.weixin.pojo.Token;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinUser;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by hccl on 2017/11/20.
 */
public class UserMessageUtil {

    private static String USER_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={ACCESS_TOKEN}&openid={OPENID}&lang=zh_CN";

    private static final String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static void getUserMessage(String openid, WeixinUser user) {

        String user_url = USER_MESSAGE_URL.replace("{ACCESS_TOKEN}", TimedTasks.ACCESS_TOKEN).replace("{OPENID}", openid);

        String resultStr = CommonUtil.httpsRequest(user_url, "GET", null);

        JSONObject jsonObject = JSONObject.fromObject(resultStr);

        user.setOpenId(openid);
        user.setSubscribeTime(new Date());
        user.setCity((String) jsonObject.get("city"));
        user.setNickname((String) jsonObject.get("nickname"));
        user.setSex((Integer) jsonObject.get("sex"));
        user.setLanguage((String) jsonObject.get("language"));
        user.setProvince((String) jsonObject.get("province"));
        user.setCountry((String) jsonObject.get("country"));
        user.setHeadimgurl((String) jsonObject.get("headimgurl"));
        user.setRemark((String) jsonObject.get("remark"));
    }

    /**
     * 获取access_token 值
     * @param appid 公众号的唯一凭证
     * @param appsecret 秘钥
     * @return
     */
    public static Token getAccessToken(String appid, String appsecret) {

        Token token = null;

        String tokenUrl = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);

        String jsonString = CommonUtil.httpRequest(tokenUrl, "GET", null);

        ObjectMapper mapper = new ObjectMapper();

        try {
            token = mapper.readValue(jsonString, Token.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return token;
    }

    public static void main(String[] args) {

//        Token token = getAccessToken("wxb6646a6c65188411", "9ff843ad69398780ce68e6dd411b1b5b");
//
        String ACCESS_TOKEN = "";
//
//        String ACCESS_TOKEN = "vKX8KHEasRL_O9nhNpWj0RHKLXBJ6j75AEt4dz84KXLSokctMfB4J1a98j8zs4HuoI9mgxSZb6msu8GfoZwvJTDm0Bo7tpjSNiex_TRMFRO75QqObtUPWTnSIMulozcFXHXaAEAHRH";

        System.out.println(ACCESS_TOKEN);

        String user_url = USER_MESSAGE_URL.replace("{ACCESS_TOKEN}", ACCESS_TOKEN).replace("{OPENID}", "oTHSZ0Z-ZZSnd-x3uMcJFmFdVsJA");

        String resultStr = CommonUtil.httpsRequest(user_url, "GET", null);

        System.out.println(resultStr);

        JSONObject jsonObject = JSONObject.fromObject(resultStr);

        System.out.println((String) jsonObject.get("city"));
        System.out.println((String) jsonObject.get("nickname"));
        System.out.println((Integer) jsonObject.get("sex"));
        System.out.println((String) jsonObject.get("language"));;
        System.out.println((String) jsonObject.get("province"));
        System.out.println((String) jsonObject.get("country"));
        System.out.println((String) jsonObject.get("headimgurl"));
        System.out.println((String) jsonObject.get("remark"));
    }
}
