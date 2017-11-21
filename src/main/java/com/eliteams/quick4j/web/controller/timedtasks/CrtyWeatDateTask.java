package com.eliteams.quick4j.web.controller.timedtasks;

import com.eliteams.quick4j.web.model.weixin.weather.WxCrty;
import com.eliteams.quick4j.web.model.weixin.weather.WxCrtyExample;
import com.eliteams.quick4j.web.service.weixin.weather.WxCrtyService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hccl on 2017/11/20.
 */
@Component("delCrtyWeatDateTask")
public class CrtyWeatDateTask {

    private static Logger logger = Logger.getLogger(CrtyWeatDateTask.class);

    @Resource
    private WxCrtyService wxCrtyService;

    /**
     * 定时删除城市天气信息
     */
    //每天凌晨0点执行
    @Scheduled(cron = "0 0 0 * * ?")
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

}
