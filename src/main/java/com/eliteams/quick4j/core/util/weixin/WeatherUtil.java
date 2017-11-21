package com.eliteams.quick4j.core.util.weixin;

import com.eliteams.quick4j.core.util.HttpUtil;
import com.eliteams.quick4j.core.util.PinyinUtils;
import com.eliteams.quick4j.core.util.PropertiesUtil;
import com.eliteams.quick4j.core.util.StringUtil;
import com.eliteams.quick4j.web.model.weixin.message.Article;
import com.eliteams.quick4j.web.model.weixin.weather.Forecast;
import com.eliteams.quick4j.web.model.weixin.weather.WxCrty;
import com.eliteams.quick4j.web.model.weixin.weather.WxCrtyExample;
import com.eliteams.quick4j.web.service.weixin.weather.WxCrtyService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by hccl on 2017/11/19.
 */
public class WeatherUtil {

    private static String weather_Url = "http://www.sojson.com/open/api/weather/json.shtml?city={CITY}";

    public static List<Article> BaiDuWeather(String crtyName, WxCrtyService wxCrtyService) {

        List<Article> articles = new ArrayList<>();
        String resultStr = null;
        String url = weather_Url.replace("{CITY}", CommonUtil.getURLEncoderString(crtyName));

        WxCrtyExample example = new WxCrtyExample();
        example.createCriteria().andCrtynameEqualTo(crtyName);
        List<WxCrty> crties = wxCrtyService.selectByExampleWithBLOBs(example);
        if (crties.size() > 0) {
            WxCrty crty = crties.get(0);
            if (!StringUtil.isEmpty(crty.getCrtytext())) {//该城市今天查过了
                resultStr = crty.getCrtytext();
                System.out.println(resultStr);
            } else {
                resultStr = CommonUtil.httpRequest(url, "GET", null);
                System.out.println(resultStr);
            }
        } else {//库中没有该城市的记录
            resultStr = CommonUtil.httpRequest(url, "GET", null);
            System.out.println(resultStr);
            JSONObject jsb = JSONObject.fromObject(resultStr);
            String res = (String) jsb.get("message");
            if (!res.equals("Success !")) {
                return articles;
            }
            WxCrty wxCrty = new WxCrty();
            wxCrty.setId(UUID.randomUUID().toString());
            wxCrty.setCrtyname(crtyName);
            wxCrty.setCrtytext(resultStr);
            wxCrtyService.insertSelective(wxCrty);
        }
        //验证请求是否成功
        JSONObject jsb = JSONObject.fromObject(resultStr);
        String res = (String) jsb.get("message");
        if (!res.equals("Success !")) {
            return articles;
        }
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
        JSONArray jsonArray = (JSONArray)jsonObject1.get("forecast");
        String crty = (String) jsonObject.get("city");
        List<Forecast> forecasts = new ArrayList<>();
        for (int i = 0; i<jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            Forecast forecast = new Forecast();
            forecast.setCity(crty);
            forecast.setDate((String) object.get("date"));
            forecast.setSunrise((String) object.get("sunrise"));
            forecast.setHigh((String) object.get("high"));
            forecast.setLow((String) object.get("low"));
            forecast.setSunset((String) object.get("sunset"));
            forecast.setAqi((Double) object.get("aqi"));
            forecast.setFx((String) object.get("fx"));
            forecast.setFl((String) object.get("fl"));
            forecast.setType((String) object.get("type"));
            forecast.setNotice((String) object.get("notice"));
            forecasts.add(forecast);
        }
//        //当天的天气预报
//        Forecast forecast = forecasts.get(0);
//        forecast.setCity((String) jsonObject1.get("city"));
//        forecast.setPm10((Double) jsonObject1.get("pm10"));
//        forecast.setPm25((Double) jsonObject1.get("pm25"));
//        forecast.setQuality((String) jsonObject1.get("quality"));
//        forecast.setGanmao((String) jsonObject1.get("ganmao"));
//        forecast.setPicUrl(PropertiesUtil.getProperty("object_root_name") + "wx/imges/weather/top.jpg");
        int i = 0;
        String num1Message = "";
        for (Forecast f : forecasts) {
            Article article = new Article();
            if (i == 0) {
                f.setPicUrl(PropertiesUtil.getProperty("object_root_name") + "wx/imges/weather/top.jpg");
                num1Message =f.getCity() + " " + f.getDate() + " " + f.getHigh() + "~" + f.getLow() + " " + f.getType() + " " + f.getFx() + " " + f.getFl();

                article.setTitle(num1Message);
                article.setDescription("");
                article.setPicUrl(f.getPicUrl());
                article.setUrl("");
                articles.add(article);

                i++;
                continue;
            }
            String picName = PinyinUtils.getPingYin(f.getType());
            f.setPicUrl(PropertiesUtil.getProperty("object_root_name") + "wx/imges/weather/weather_" + picName + ".png");

            article.setTitle(f.getDate() + " " + f.getHigh() + "~" + f.getLow() + " " + f.getType() + " " + f.getFx() + " " + f.getFl());
            article.setDescription("");
            article.setPicUrl(f.getPicUrl());
            article.setUrl("");
            articles.add(article);
        }
        return articles;
    }

    public static void main(String[] args) {
//        List<Article> articles = BaiDuWeather("北京");
//        System.out.println(articles.size());

        String url = weather_Url.replace("{CITY}", "天水");

        String resultStr = CommonUtil.httpRequest(url, "GET", null);
        if (resultStr.equals("{\"message\":\"Check the parameters.\"}")) {
            System.out.println("ok");
        }
        System.out.println(resultStr);


//        String sta = "%E5%8C%97%E4%BA%AC";
//        String end = "北京";
//
//        String endd = CommonUtil.getURLEncoderString(end);
//
//        System.out.println(endd);
//
//        if (sta.equals(endd)) {
//            System.out.println("haha");
//        }
    }
}
