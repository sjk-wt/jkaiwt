package com.eliteams.quick4j.core.util;

import org.apache.log4j.Logger;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

/**
 * Created by thinkit on 2017/2/21.
 */
public class HttpUtil {

//    static Logger logger = Logger.getLogger(HttpUtil.class);

    /**
     * 获取本机ip
     * @return
     */
    public static String getLocalHostIp(){
        InetAddress ia=null;
        String ip = null;
        try {
            ia=ia.getLocalHost();
            ip = ia.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }



    /**
     * 转换请求为 String
     *
     * @param request
     * @return String
     * @throws IOException
     */
    public static String getStringArray(HttpServletRequest request) throws IOException {
        String acceptJsonArray;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));

        StringBuffer sb = new StringBuffer("");
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            sb.append(temp);
        }
        bufferedReader.close();
        acceptJsonArray = sb.toString();
        return acceptJsonArray;
    }



    /**
     * 发送请求
     * @param url
     * @param postParam
     * @param contentType
     * @param charset
     * @return
     * @throws Exception
     */
    private static String send(String url,String postParam,String contentType,String charset) {
        OutputStream osw = null;
        InputStream ins = null;
        String var7 = null;
        try {
            HttpURLConnection con = (HttpURLConnection)(new URL(url)).openConnection();
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setConnectTimeout(10000);
            con.setReadTimeout(600000);
            con.setRequestProperty("Content-Type", contentType);
            if(null != postParam) {
                con.setDoOutput(true);
                byte[] resCode = postParam.getBytes("UTF-8");
                con.setRequestProperty("Content-Length", Integer.toString(resCode.length));
                osw = con.getOutputStream();
                osw.write(resCode);
                osw.flush();
            }

            int resCode1 = con.getResponseCode();
            if(resCode1 < 400) {
                ins = con.getInputStream();
            } else {
                ins = con.getErrorStream();
            }

            var7 = readContent(ins, charset);
        } catch (Exception e){
//            logger.info("请求发送失败！");
        }finally {
            try {
                if(osw != null) {
                    osw.close();
                }
                if(ins != null) {
                    ins.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return var7;
    }

    private static String readContent(InputStream ins, String charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(ins, charset));

        String line;
        while((line = br.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }


    /**
     * 发送Post请求
     * 数据格式为 json
     * @param
     * @return
     */
    public static String sendJsonHttpPost(String url, String json) throws Exception {
        String charset = "UTF-8";
        String var7 = send(url,json,"application/json",charset);
        return var7;
    }


    /**
     * 添加get方法
     * @param id
     * @return
     * @throws IOException
     */
    public static String get(String id) throws IOException {
        return get(PropertiesUtil.getProperty("esCallBackAddress")+id+"/_source", "UTF-8");
    }

    /**
     * 添加get方法
     * @param id
     * @return
     * @throws IOException
     */
    public static String getOne(String id) throws IOException {
        return get(PropertiesUtil.getProperty("esCallBackAddress")+id+"/?pretty", "UTF-8");
    }

    public static String getOriginal(String id){
        return get(id, "UTF-8");
    }
    /**
     * 添加get方法
     * @param url
     * @param charset
     * @return
     * @throws IOException
     */
    public static String get(String url, String charset){
        System.out.println("request:url:"+url);
        InputStream ins = null;

        String var5 = null;
        try {
            HttpURLConnection con = (HttpURLConnection)(new URL(url)).openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(10000);
            con.setReadTimeout(600000);
            int resCode = con.getResponseCode();
            if(resCode < 400) {
                ins = con.getInputStream();
            } else {
                ins = con.getErrorStream();
            }

            var5 = readContent(ins, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return var5;
    }



}
