package com.eliteams.quick4j.core.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by BanAiQin on 2016/11/15.
 */
public class PropertiesUtil {

    private static Logger logger = Logger.getLogger(PropertiesUtil.class.getName());

    private static Properties properties = null;

    static {
        refresh();
    }

    public static void refresh() {
        logger.info("开始加载application.properties");
        properties = new Properties();
        InputStream in = null;
        in = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            logger.error("加载application.properties配置文件出错");
            e.printStackTrace();
        }
        if (properties.isEmpty()) {
            logger.error("读取application.properties配置文件，内容为空");
            return;
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (StringUtil.isEmpty(value)) {
            logger.info("没有" + key + "对应的项 检查config.properties配置文件");
        }
        return value;
    }
}
