package com.eliteams.quick4j.web.controller.timedtasks;

import com.eliteams.quick4j.core.util.weixin.UserMessageUtil;
import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfig;
import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfigExample;
import com.eliteams.quick4j.web.service.weixin.pojo.WeixinConfigService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by hccl on 2017/11/20.
 */
@Component("getWxAccessToken")
public class WxAccessTokenTask {

    private static Logger logger = Logger.getLogger(WxAccessTokenTask.class);

    @Resource
    private WeixinConfigService weixinConfigService;

    public static String ACCESS_TOKEN = null;

    public static String WX_TOKEN = null;
    public static String WX_APPID = null;
    public static String WX_ENCODINGAESKEY = null;

    /**
     * 获取access_koken秘钥
     */
    //每小时执行一次
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void getWxAccessToken(){
        String logTxt = "定时查询微信认证码方法";
        logger.info("【"+logTxt+"】");
        WeixinConfigExample example = new WeixinConfigExample();
        example.createCriteria().andWxTokenEqualTo(WX_TOKEN);
        WeixinConfig wxConfig = weixinConfigService.selectByExample(example).get(0);
        ACCESS_TOKEN = UserMessageUtil.getAccessToken(wxConfig.getWxAppid(), wxConfig.getWxEncodingaeskey()).getAccess_token();
        logger.info("【"+logTxt+"】获取到的access_token = 【"+ACCESS_TOKEN+"】");
        wxConfig.setWxAccessToken(ACCESS_TOKEN);
        weixinConfigService.updateByPrimaryKeySelective(wxConfig);
    }

}
