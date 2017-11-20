package com.eliteams.quick4j.core.util.weixin;

import com.eliteams.quick4j.core.util.PropertiesUtil;

import javax.net.ssl.SSLException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by hccl on 2017/11/18.
 */
public class FacePlusPlusUtil {

    private static final String FACE_DETECT = "https://api-cn.faceplusplus.com/facepp/v3/detect";

    public static void main(String[] args) {
//        detectFace("http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E5%91%A8%E6%B6%A6%E5%8F%91&step_word=&hs=0&pn=1&spn=0&di=61939504660&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1901474822%2C3346883847&os=835252274%2C2328244760&simid=3281295235%2C310882679&adpicid=0&lpn=0&ln=3896&fr=&fmq=1511006564683_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=star&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimages.china.cn%2Fattachement%2Fjpg%2Fsite1000%2F20151112%2Fb8aeedd1282a17ae9b3e33.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fjgp_z%26e3Bvitgw_z%26e3Bv54_z%26e3BvgAzdH3Fda8c-88AzdH3F8dAzdH3Fv5gpjgp_n0a9bd9l_9n_z%26e3Bip4&gsm=0&rpstart=0&rpnum=0");
        detectFace("D:\\googleDowload\\dowloadFile\\AD0IsY73BBAEGAAg1LjnzQUotqvk-wcwgA849gM.png");

    }

    /**
     * 人脸识别（提供外部调用）
     * @param url
     * @return
     */
    public static String detectFace(String url) {
        String result = null;
        File file = new File(url);
        byte[] buff = getBytesFromFile(file);
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        map.put("api_key", PropertiesUtil.getProperty("API_Key"));
        map.put("api_secret", PropertiesUtil.getProperty("API_Secret"));
        byteMap.put("image_file", buff);
        try{
            byte[] bacd = post(FACE_DETECT, map, byteMap);
            String str = new String(bacd);
            System.out.println(str);
            result = str;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    private final static int CONNECT_TIME_OUT = 30000;
    private final static int READ_OUT_TIME = 50000;
    private static String boundaryString = getBoundary();
    protected static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
        HttpURLConnection conne;
        URL url1 = new URL(url);
        conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(CONNECT_TIME_OUT);
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry) iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            obos.writeBytes("--" + boundaryString + "\r\n");
            obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                    + "\"\r\n");
            obos.writeBytes("\r\n");
            obos.writeBytes(value + "\r\n");
        }
        if(fileMap != null && fileMap.size() > 0){
            Iterator fileIter = fileMap.entrySet().iterator();
            while(fileIter.hasNext()){
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                        + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());
                obos.writeBytes("\r\n");
            }
        }
        obos.writeBytes("--" + boundaryString + "--" + "\r\n");
        obos.writeBytes("\r\n");
        obos.flush();
        obos.close();
        InputStream ins = null;
        int code = conne.getResponseCode();
        try{
            if(code == 200){
                ins = conne.getInputStream();
            }else{
                ins = conne.getErrorStream();
            }
        }catch (SSLException e){
            e.printStackTrace();
            return new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while((len = ins.read(buff)) != -1){
            baos.write(buff, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ins.close();
        return bytes;
    }
    private static String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }
    private static String encode(String value) throws Exception{
        return URLEncoder.encode(value, "UTF-8");
    }
    public static byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
        }
        return null;
    }

}
