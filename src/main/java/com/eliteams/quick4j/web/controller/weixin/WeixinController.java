package com.eliteams.quick4j.web.controller.weixin;

import com.eliteams.quick4j.core.util.PropertiesUtil;
import com.eliteams.quick4j.core.util.weixin.MessageUtil;
import com.eliteams.quick4j.core.util.weixin.SignalUtil;
import com.eliteams.quick4j.core.util.weixin.WeatherUtil;
import com.eliteams.quick4j.core.weixinAes.WXBizMsgCrypt;
import com.eliteams.quick4j.web.model.weixin.message.*;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinSign;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinUser;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinUserExample;
import com.eliteams.quick4j.web.service.weixin.sgin.WeixinSignService;
import com.eliteams.quick4j.web.service.weixin.sgin.WeixinUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hccl on 2017/11/16.
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController {

    private static Logger logger = Logger.getLogger(WeixinController.class);

    @Resource
    private WeixinUserService weixinUserService;

    @Resource
    private WeixinSignService weixinSignService;

    @RequestMapping(value = "/weixin", method = RequestMethod.GET)
    public void doGetMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("【微信认证GET请求方法】");
        String timestamp = request.getParameter("timestamp");
        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter out =  response.getWriter();
        if (SignalUtil.checkSignature(timestamp, nonce, signature)) {
            out.write(echostr);
        }
        out.close();
    }

    @RequestMapping(value = "/weixin", method = RequestMethod.POST)
    public void doPostMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("【POST请求】");
        String timestamp = request.getParameter("timestamp");
        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        try {
            PrintWriter out =  response.getWriter();
            if (SignalUtil.checkSignature(timestamp, nonce, signature)) {
                HashMap<String, String> resMap = new HashMap<>();
                String encryptType = request.getParameter("encrypt_type");
                logger.info("【POST请求】请求方式为【"+encryptType+"】");
                //加密模式
                if ("aes".equals(encryptType)) {
                    //将密文xml转换为明文xml
                    resMap =  MessageUtil.parseXmlCrypt(request);
                    //消息处理
                    String result = coreMessage(resMap);
                    logger.info("【POST密文请求】明文xml" + result);
                    //转为密文
                    WXBizMsgCrypt wxCrypt = MessageUtil.getWXBizMsgCrypt();
                    result = wxCrypt.encryptMsg(result, timestamp, nonce);
                    logger.info("【POST密文请求】密文xml" + result);
                    out.write(result);
                }
                //明文模式
                else {
                    resMap =  MessageUtil.parseXml(request);
                    String result = coreMessage(resMap);
                    logger.info("【POST明文请求】" + result);
                    out.write(result);
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * POST处理方法
     * @param resMap
     * @return
     */
    private String coreMessage(HashMap<String, String> resMap) {
        String respXML = null;
        TextMessage textMessage = new TextMessage();
        try {
            String toUserName = resMap.get("ToUserName");
            String fromUserName = resMap.get("FromUserName");
            String msgType = resMap.get("MsgType");
            logger.info("【ToUserName = "+toUserName+"】【FromUserName = "+fromUserName+"】【MsgType = "+msgType+"】");

            textMessage.setFromUserName(toUserName);
            textMessage.setToUserName(fromUserName);
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYOE_TEXT);
            textMessage.setCreateTime(new Date().getTime());
            //文本信息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYOE_TEXT)) {
                logger.info("【POST请求】您发送的是文本信息");
                String content = resMap.get("Content");
                if (content.equals("？") || content.equals("?")) {
                    StringBuffer sb = new StringBuffer();
                    sb.append("输入：城市+").append("\"天气\"，例如：北京天气\n");
                    sb.append("          ").append("\"天气\"+城市，例如：天气北京\n");
                    sb.append("即可查询城市天气预报！\n\n");
                    sb.append("回复 \"?\" 显示提示信息！");
                    sb.append("\n\n功能正在完善中,敬请期待....");
                    sb.append("\nPS：在休闲娱乐中可以先玩玩游戏！");
                    textMessage.setContent(sb.toString());
                    respXML = MessageUtil.messageToXML(textMessage);
                } else if (content.endsWith("天气") || content.startsWith("天气")) {
                    String crty = content.replace("天气", "").trim();
                    List<Article> articles = WeatherUtil.BaiDuWeather(crty);
                    NewsMessage newsMessage = new NewsMessage();
                    newsMessage.setFromUserName(toUserName);
                    newsMessage.setToUserName(fromUserName);
                    newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYOE_NEWS);
                    newsMessage.setCreateTime(new Date().getTime());
                    newsMessage.setArticleCount(articles.size());
                    newsMessage.setArticles(articles);
                    respXML = MessageUtil.messageToXML(newsMessage);
                } else {
                    textMessage.setContent("请输入的是文本信息，内容是【"+content+"】");
                    respXML = MessageUtil.messageToXML(textMessage);
                }
            }
            //图片信息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYOE_IMAGE)) {
                logger.info("【POST请求】您发送的是图片信息");
                textMessage.setContent("您发送的是图片信息");
                respXML = MessageUtil.messageToXML(textMessage);
            }
            //音频信息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYOE_VOICE)) {
                logger.info("【POST请求】您发送的是音频信息");
                textMessage.setContent("您发送的是音频信息");
                respXML = MessageUtil.messageToXML(textMessage);
            }
            //视频信息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYOE_VIDEO)) {
                logger.info("【POST请求】您发送的是视频信息");
                textMessage.setContent("您发送的是视频信息");
                respXML = MessageUtil.messageToXML(textMessage);
            }
            //地理位置信息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYOE_LOCATION)) {
                logger.info("【POST请求】您发送的是地理位置信息");
                textMessage.setContent("您发送的是地理位置信息");
                respXML = MessageUtil.messageToXML(textMessage);
            }
            //链接信息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYOE_LINK)) {
                logger.info("【POST请求】您发送的是链接信息");
                textMessage.setContent("您发送的是链接信息");
                respXML = MessageUtil.messageToXML(textMessage);
            }
            //时间
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYOE_EVENT)) {
                String event = resMap.get("Event");
                //关注
                if (event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    logger.info("【POST请求】您发送的是关注信息");
                    //查询该用户是否关注过
                    WeixinUser weixinUser = getUserByOpendId(fromUserName);
                    if (weixinUser == null) {
                        weixinUser = new WeixinUser();
                        weixinUser.setId(UUID.randomUUID().toString());
                        weixinUser.setOpenId(fromUserName);
                        weixinUser.setSubscribeTime(new Date());
                        weixinUser.setSubscribeStatus(WeixinUser.GUANZHU);
                        weixinUserService.insertSelective(weixinUser);
                        StringBuffer sb = new StringBuffer();
                        sb.append("感谢您的关注，小石竭诚为您服务！").append("\n\n");
                        sb.append("输入：城市+").append("\"天气\"，例如：北京天气\n");
                        sb.append("          ").append("\"天气\"+城市，例如：天气北京\n");
                        sb.append("即可查询城市天气预报\n\n");
                        sb.append("回复 \"?\" 显示提示信息！");
                        sb.append("\n\n功能正在完善中,敬请期待....");
                        sb.append("\nPS：在休闲娱乐中可以先玩玩游戏！");
                        textMessage.setContent(sb.toString());
                        respXML = MessageUtil.messageToXML(textMessage);
                    } else {
                        weixinUser.setSubscribeStatus(WeixinUser.GUANZHU);
                        weixinUserService.updateByPrimaryKeySelective(weixinUser);
                        StringBuffer sb = new StringBuffer();
                        sb.append("感谢您的再次关注，小石竭诚为您服务！").append("\n\n");
                        sb.append("输入：城市+").append("\"天气\"，例如：北京天气\n");
                        sb.append("          ").append("\"天气\"+城市，例如：天气北京\n");
                        sb.append("即可查询城市天气预报\n\n");
                        sb.append("回复 \"?\" 显示提示信息！");
                        sb.append("\n\n功能正在完善中,敬请期待....");
                        sb.append("\nPS：在休闲娱乐中可以先玩玩游戏！");
                        textMessage.setContent(sb.toString());
                        respXML = MessageUtil.messageToXML(textMessage);
                    }
                }
                //取消关注
                else if (event.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    logger.info("【取消关注】");
                    WeixinUser weixinUser = getUserByOpendId(fromUserName);
                    weixinUser.setSubscribeStatus(WeixinUser.QUXIAOGUANZHU);
                    weixinUserService.updateByPrimaryKeySelective(weixinUser);
                }
                //点击事件
                else if (event.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    String eventKey = resMap.get("EventKey");
                    //签到
                    if ("QIANDAO_KEY".equals(eventKey)) {
                        isSigned(fromUserName, textMessage);
                        respXML = MessageUtil.messageToXML(textMessage);
                    }
                    //听歌
                    else if ("MUSIC_KEY".equals(eventKey)) {
                        MusicMessage musicMessage = formatMusic(resMap);
                        respXML = MessageUtil.messageToXML(musicMessage);
                    }
                    //天气预报
                    else if ("WEATHER_KEY".equals(eventKey)) {
                        String crty = "北京";
                        List<Article> articles = WeatherUtil.BaiDuWeather(crty);
                        NewsMessage newsMessage = new NewsMessage();
                        newsMessage.setFromUserName(toUserName);
                        newsMessage.setToUserName(fromUserName);
                        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYOE_NEWS);
                        newsMessage.setCreateTime(new Date().getTime());
                        newsMessage.setArticleCount(articles.size());
                        newsMessage.setArticles(articles);
                        respXML = MessageUtil.messageToXML(newsMessage);
                    } else {
                        textMessage.setContent("跳转按钮");
                        respXML = MessageUtil.messageToXML(textMessage);
                    }
                }
                //地理位置
                else if (event.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    String Latitude = resMap.get("Latitude");
                    String Longitude = resMap.get("Longitude");
                    String Precision = resMap.get("Precision");
                    textMessage.setContent("【Latitude = "+Latitude+"】【Longitude = "+Longitude+"】【Precision = "+Precision+"】");
                    respXML = MessageUtil.messageToXML(textMessage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXML;
    }
    //签到逻辑方法
    private void isSigned(String fromUserName, TextMessage textMessage) {
        //判断当天是否签到
        WeixinSign weixinSign = new WeixinSign();
        weixinSign.setOpenId(fromUserName);
        int isSign = weixinSignService.isTodaySigned(weixinSign);
        StringBuffer sb = new StringBuffer();
        if (1 != isSign) {//未签到
            //判断本周是否签到7天
            Map<String, String> map = new HashMap<>();
            map.put("openId", fromUserName);
            map.put("mondey", SignalUtil.getMondayOfThisWeek());
            int isMoSign = weixinSignService.isMondeySigned(map);
            int points = 0;
            if (6 == isMoSign) {//连续签到6天，加12分
                points = 12;
                sb.append("签到成功获得2积分！\n 本周连续签到7天，获得额外10积分！");
            } else {//没有到6天，加2分
                points = 2;
                sb.append("签到成功，获得2积分！");
            }
            insertUserAndSign(fromUserName, points);
        } else {//签到
            sb.append("今天您已签到");
        }
        sb.append("\n").append("您共有【"+getUserByOpendId(fromUserName).getPoints()+"】积分！");
        textMessage.setContent(sb.toString());
    }
    //根据用户微信ID获取用户信息
    private WeixinUser getUserByOpendId(String opendId) {
        WeixinUserExample example = new WeixinUserExample();
        example.createCriteria().andOpenIdEqualTo(opendId);
        WeixinUser weixinUser = null;
        weixinUserService.selectByExample(example);
        if (weixinUserService.selectByExample(example).size() > 0)
            weixinUser = weixinUserService.selectByExample(example).get(0);
        return weixinUser;
    }
    //添加积分表和更新用户总积分
    private void insertUserAndSign(String fromUserName, int points) {
        //积分表
        WeixinSign weixinSign1 = new WeixinSign();
        weixinSign1.setId(UUID.randomUUID().toString());
        weixinSign1.setOpenId(fromUserName);
        weixinSign1.setSignPoints(points);
        weixinSign1.setSignTime(new Date());
        weixinSignService.insertSelective(weixinSign1);
        //用户表的总积分
        WeixinUser weixinUser = getUserByOpendId(fromUserName);
        weixinUser.setPoints(weixinUser.getPoints() + points);
        weixinUserService.updateByPrimaryKeySelective(weixinUser);
    }
    //封装回复音乐消息
    private static MusicMessage formatMusic(HashMap<String, String> resMap) {
        //创建Music对象
        Music music = new Music();
        music.setTitle("一生所爱《西游降魔篇》-片尾曲");
        music.setDescription("舒淇");
        music.setMusicUrl(PropertiesUtil.getProperty("object_root_name") + "wx/musics/yishengsuoai.mp3");
        music.setHQMusicUrl(PropertiesUtil.getProperty("object_root_name") + "wx/musics/yishengsuoai.mp3");
        //封装回复音乐消息
        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setFromUserName(resMap.get("ToUserName"));
        musicMessage.setToUserName(resMap.get("FromUserName"));
        musicMessage.setCreateTime(new Date().getTime());
        musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYOE_MUSIC);
        musicMessage.setMusic(music);
        return musicMessage;
    }

}
