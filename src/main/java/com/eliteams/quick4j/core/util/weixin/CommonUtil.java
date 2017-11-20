package com.eliteams.quick4j.core.util.weixin;

import com.eliteams.quick4j.core.weixinAes.MyX509TrustManager;
import com.eliteams.quick4j.web.model.weixin.pojo.Token;
import org.codehaus.jackson.map.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hccl on 2017/11/18.
 */
public class CommonUtil {

    private static final String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 处理https GET/POST请求
     * @param requestUrl 请求地址
     * @param requestMethod 请求方法(GET/POST)
     * @param outputStr 参数
     * @return
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = null;
        try {
            //创建SSLContext
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            TrustManager[] tm = {new MyX509TrustManager()};
            //初始化
            sslContext.init(null, tm, new java.security.SecureRandom());
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            //设置当前实例使用的SSLSoketFactory
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            //往服务器写内容
            if (null != outputStr) {
                OutputStream out = conn.getOutputStream();
                out.write(outputStr.getBytes("utf-8"));
                out.close();
            }

            //
            InputStream in = conn.getInputStream();
            InputStreamReader ins = new InputStreamReader(in, "utf-8");
            BufferedReader br = new BufferedReader(ins);

            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            br.close();
            ins.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }


    /**
     * 处理https GET/POST请求
     * @param requestUrl 请求地址
     * @param requestMethod 请求方法(GET/POST)
     * @param outputStr 参数
     * @return
     */
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            //往服务器写内容
            if (null != outputStr) {
                OutputStream out = conn.getOutputStream();
                out.write(outputStr.getBytes("utf-8"));
                out.close();
            }

            InputStream in = conn.getInputStream();
            InputStreamReader ins = new InputStreamReader(in, "utf-8");
            BufferedReader br = new BufferedReader(ins);

            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            br.close();
            ins.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
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

    /**
     * URL 解码
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午04:09:51
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * URL 转码
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午04:10:28
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
