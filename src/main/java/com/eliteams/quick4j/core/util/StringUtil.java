package com.eliteams.quick4j.core.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具类
 *
 * @author huangyong
 * @since 1.0
 */
public class StringUtil {

    /**
     * 字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char) 29);

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * 若字符串为空，则取默认值
     */
    public static String defaultIfEmpty(String str, String defaultValue) {
        return StringUtils.defaultIfEmpty(str, defaultValue);
    }

    /**
     * 替换固定格式的字符串（支持正则表达式）
     */
    public static String replaceAll(String str, String regex, String replacement) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 是否为数字（整数或小数）
     */
    public static boolean isNumber(String str) {
        return NumberUtils.isNumber(str);
    }

    /**
     * 是否为十进制数（整数）
     */
    public static boolean isDigits(String str) {
        return NumberUtils.isDigits(str);
    }

    /**
     * 将驼峰风格替换为下划线风格
     */
    public static String camelhumpToUnderline(String str) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() + i, matcher.end() + i, "_" + matcher.group().toLowerCase());
        }
        if (builder.charAt(0) == '_') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    /**
     * 将下划线风格替换为驼峰风格
     */
    public static String underlineToCamelhump(String str) {
        Matcher matcher = Pattern.compile("_[a-z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() - i, matcher.end() - i, matcher.group().substring(1).toUpperCase());
        }
        if (Character.isUpperCase(builder.charAt(0))) {
            builder.replace(0, 1, String.valueOf(Character.toLowerCase(builder.charAt(0))));
        }
        return builder.toString();
    }

    /**
     * 分割固定格式的字符串
     */
    public static String[] splitString(String str, String separator) {
        return StringUtils.splitByWholeSeparator(str, separator);
    }

    /**
     * 将字符串首字母大写
     */
    public static String firstToUpper(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 将字符串首字母小写
     */
    public static String firstToLower(String str) {
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 转为帕斯卡命名方式（如：FooBar）
     */
    public static String toPascalStyle(String str, String seperator) {
        return StringUtil.firstToUpper(toCamelhumpStyle(str, seperator));
    }

    /**
     * 转为驼峰命令方式（如：fooBar）
     */
    public static String toCamelhumpStyle(String str, String seperator) {
        return StringUtil.underlineToCamelhump(toUnderlineStyle(str, seperator));
    }

    /**
     * 转为下划线命名方式（如：foo_bar）
     */
    public static String toUnderlineStyle(String str, String seperator) {
        str = str.trim().toLowerCase();
        if (str.contains(seperator)) {
            str = str.replace(seperator, "_");
        }
        return str;
    }

    /**
     * 转为显示命名方式（如：Foo Bar）
     */
    public static String toDisplayStyle(String str, String seperator) {
        String displayName = "";
        str = str.trim().toLowerCase();
        if (str.contains(seperator)) {
            String[] words = StringUtil.splitString(str, seperator);
            for (String word : words) {
                displayName += StringUtil.firstToUpper(word) + " ";
            }
            displayName = displayName.trim();
        } else {
            displayName = StringUtil.firstToUpper(str);
        }
        return displayName;
    }

    /**
     * 参数为null返回"",否则返回本身
     *
     * @param str
     * @return
     */
    public static String null2String(Object str) {
        if (str == null) {
            return "";
        }
        return str.toString();
    }

    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return 是否为空
     */
    public static boolean isNullStr(String s) {
        if (s == null || s.trim().length() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否为数字
     *
     * @param str the str
     * @return boolean
     */
    public static boolean isNumeric(String str) {
        if(str==null || "".equals(str)) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 正确的正则表达式是：-?[0-9]+\\.?[0-9]*，点号.,是匹配任意字符，需要进行转义。
     * @param str
     * @return
     */
    public static boolean isNumerics(String str){
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    /**
     * 匹配是否包含数字
     * @param str 可能为中文，也可能是-19162431.1254，不使用BigDecimal的话，变成-1.91624311254E7
     * @return
     * @author yutao
     * @date 2016年11月14日下午7:41:22
     */
    public static boolean isNumericD(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /***
     * 判断 String 是否是 int
     *
     * @param input
     * @return
     */
    public static boolean isInteger(String input){
        Matcher mer = Pattern.compile("^[+-]?[0-9]+$").matcher(input);
        return mer.find();
    }
}
