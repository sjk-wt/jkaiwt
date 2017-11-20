package com.eliteams.quick4j.core.util.weixin;

import com.eliteams.quick4j.core.util.PropertiesUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by hccl on 2017/11/16.
 */
public class SignalUtil {

    public static boolean checkSignature(String timestamp, String nonce, String signature) {
        boolean result = false;

        // 对token、timestamp和nonce按字典排序
        String[] array= new String[] { PropertiesUtil.getProperty("wx_token"), timestamp, nonce };
        Arrays.sort(array);

        // 将三个参数字符串拼接成一个字符串
        String str= array[0].concat(array[1]).concat(array[2]);

        // 对拼接后的字符串进行sha1加密
        String sha1Str = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.getBytes());
            sha1Str = byte2str(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //验证签名正确
        if (sha1Str != null && sha1Str.equals(signature)) {
            result = true;
        }
        return result;
    }

    /**
     * 将字节数组转换成字符串
     * @param array 字节数组
     * @return String
     */
    public static String byte2str(byte[] array) {
        StringBuffer hexstr = new StringBuffer();
        String shaHex = "";
        for (int i = 0; i < array.length; i++) {
            shaHex = Integer.toHexString(array[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
        return hexstr.toString();
    }

    //得到本周周一的日期
    public static String getMondayOfThisWeek() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //得到今天是星期几
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        //对星期天的特殊处理
        if (dayOfWeek == 0)
            dayOfWeek = 7;
        //假如今天是星期四，往前推3天就是星期一，即-(4-1)
        c.add(Calendar.DATE, -(dayOfWeek - 1));
        return df.format(c.getTime());
    }

    /**
     * 将emoji表情使用   保存emoji表情mysql时，需要报mysql编码修改为utf8mb4
     * @return
     */
    public static String emoji(int emoji) {
        String bike = String.valueOf(Character.toChars(emoji));
        return bike;
    }

}
