package com.eliteams.quick4j.web.controller.timedtasks;

import com.eliteams.quick4j.core.util.weixin.CommonUtil;
import com.eliteams.quick4j.core.util.weixin.UserMessageUtil;
import com.eliteams.quick4j.web.model.weixin.pojo.Token;
import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfig;
import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfigExample;
import com.eliteams.quick4j.web.model.weixin.weather.WxCrty;
import com.eliteams.quick4j.web.model.weixin.weather.WxCrtyExample;
import com.eliteams.quick4j.web.service.weixin.pojo.WeixinConfigService;
import com.eliteams.quick4j.web.service.weixin.weather.WxCrtyService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by hccl on 2017/11/20.
 */
@Component("taskJob")
public class TimedTasks {

    private static Logger logger = Logger.getLogger(TimedTasks.class);

    public static String ACCESS_TOKEN = null;
    public static String WX_TOKEN = null;
    public static String WX_APPID = null;
    public static String WX_ENCODINGAESKEY = null;

    @Resource
    private WeixinConfigService weixinConfigService;

    @Resource
    private WxCrtyService wxCrtyService;

    /**
     * 定时删除城市天气信息
     */
    //每天凌晨0点执行
    @Scheduled(cron = "0 0 0 * * ? *")
    public void delCrtyWeatDateTask(){
        String logTxt = "定时删除城市天气信息方法";
        logger.info("【"+logTxt+"】");
        WxCrtyExample example = new WxCrtyExample();
        example.createCriteria().andIdIsNotNull();
        List<WxCrty> crties = wxCrtyService.selectByExampleWithBLOBs(example);
        for (WxCrty crty : crties) {
            crty.setCrtytext("");
            wxCrtyService.updateByPrimaryKeyWithBLOBs(crty);
        }
    }


    /**
     * 获取access_koken秘钥
     */
    //每小时执行一次
    @Scheduled(cron = "0 0/59 0/1 * * ?")
    public void getWxAccessToken(){
        String logTxt = "定时查询微信认证码方法";
        logger.info("【"+logTxt+"】");
        WeixinConfigExample example = new WeixinConfigExample();
        example.createCriteria().andWxTokenIsNotNull();
        WeixinConfig wxConfig = weixinConfigService.selectByExample(example).get(0);
        ACCESS_TOKEN = UserMessageUtil.getAccessToken(wxConfig.getWxAppid(), wxConfig.getWxEncodingaeskey()).getAccess_token();
        WX_APPID = wxConfig.getWxAppid();
        WX_TOKEN = wxConfig.getWxToken();
        WX_ENCODINGAESKEY = wxConfig.getWxEncodingaeskey();
        logger.info("【"+logTxt+"】获取到的access_token = 【"+ACCESS_TOKEN+"】");
    }

}
