package com.eliteams.quick4j.core.util.weixin;

import com.eliteams.quick4j.core.util.PinyinUtils;
import com.eliteams.quick4j.core.util.PropertiesUtil;
import com.eliteams.quick4j.web.model.weixin.message.Article;
import com.eliteams.quick4j.web.model.weixin.weather.Forecast;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hccl on 2017/11/19.
 */
public class WeatherUtil {

    private static String weather_Url = "http://www.sojson.com/open/api/weather/json.shtml?city={CITY}";

    public static List<Article> BaiDuWeather(String crtyName){

        String url = weather_Url.replace("{CITY}", crtyName);

        String resultStr = CommonUtil.httpRequest(url, "GET", null);

//        String resultStr = "{\"date\":\"20171120\",\"message\":\"Success !\",\"status\":200,\"city\":\"北京\",\"count\":1,\"data\":{\"shidu\":\"62%\",\"pm25\":100.0,\"pm10\":131.0,\"quality\":\"轻度污染\",\"wendu\":\"-5\",\"ganmao\":\"儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼\",\"yesterday\":{\"date\":\"19日星期日\",\"sunrise\":\"07:02\",\"high\":\"高温 5.0℃\",\"low\":\"低温 -5.0℃\",\"sunset\":\"16:56\",\"aqi\":105.0,\"fx\":\"西南风\",\"fl\":\"<3级\",\"type\":\"多云\",\"notice\":\"悠悠的云里有淡淡的诗\"},\"forecast\":[{\"date\":\"20日星期一\",\"sunrise\":\"07:03\",\"high\":\"高温 9.0℃\",\"low\":\"低温 -3.0℃\",\"sunset\":\"16:55\",\"aqi\":140.0,\"fx\":\"西北风\",\"fl\":\"<3级\",\"type\":\"晴\",\"notice\":\"晴空万里，去沐浴阳光吧\"},{\"date\":\"21日星期二\",\"sunrise\":\"07:04\",\"high\":\"高温 8.0℃\",\"low\":\"低温 -2.0℃\",\"sunset\":\"16:55\",\"aqi\":235.0,\"fx\":\"西南风\",\"fl\":\"<3级\",\"type\":\"多云\",\"notice\":\"今日多云，骑上单车去看看世界吧\"},{\"date\":\"22日星期三\",\"sunrise\":\"07:06\",\"high\":\"高温 8.0℃\",\"low\":\"低温 -3.0℃\",\"sunset\":\"16:54\",\"aqi\":56.0,\"fx\":\"西北风\",\"fl\":\"3-4级\",\"type\":\"晴\",\"notice\":\"晴空万里，去沐浴阳光吧\"},{\"date\":\"23日星期四\",\"sunrise\":\"07:07\",\"high\":\"高温 7.0℃\",\"low\":\"低温 -4.0℃\",\"sunset\":\"16:54\",\"aqi\":83.0,\"fx\":\"西南风\",\"fl\":\"<3级\",\"type\":\"晴\",\"notice\":\"晴空万里，去沐浴阳光吧\"},{\"date\":\"24日星期五\",\"sunrise\":\"07:08\",\"high\":\"高温 8.0℃\",\"low\":\"低温 -2.0℃\",\"sunset\":\"16:53\",\"aqi\":67.0,\"fx\":\"东北风\",\"fl\":\"<3级\",\"type\":\"晴\",\"notice\":\"lovely sunshine，尽情享受阳光的温暖吧\"}]}}";

        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
        JSONArray jsonArray = (JSONArray)jsonObject1.get("forecast");
        List<Forecast> forecasts = new ArrayList<>();
        for (int i = 0; i<jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            Forecast forecast = new Forecast();
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
        for (Forecast f : forecasts) {
            if (i == 0) {
                f.setPicUrl(PropertiesUtil.getProperty("object_root_name") + "wx/imges/weather/top.jpg");
                i++;
                continue;
            }
            String picName = PinyinUtils.getPingYin(f.getType());
            f.setPicUrl(PropertiesUtil.getProperty("object_root_name") + "wx/imges/weather/weather_" + picName + ".png");
            i++;
        }
        List<Article> articles = new ArrayList<>();
        for (Forecast f : forecasts) {
            Article article = new Article();
            article.setTitle(f.getDate() + " " + f.getHigh() + "~" + f.getLow() + " " + f.getType() + " " + f.getFx());
            article.setDescription("");
            article.setPicUrl(f.getPicUrl());
            article.setUrl("");
            articles.add(article);
        }
        return articles;
    }

    public static void main(String[] args) {
        List<Article> articles = BaiDuWeather("北京");
        System.out.println(articles.size());
    }
}
