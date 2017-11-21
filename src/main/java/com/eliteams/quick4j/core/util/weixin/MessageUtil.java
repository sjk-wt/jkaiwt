package com.eliteams.quick4j.core.util.weixin;

import com.eliteams.quick4j.core.weixinAes.AesException;
import com.eliteams.quick4j.core.weixinAes.WXBizMsgCrypt;
import com.eliteams.quick4j.web.controller.timedtasks.CrtyWeatDateTask;
import com.eliteams.quick4j.web.controller.timedtasks.WxAccessTokenTask;
import com.eliteams.quick4j.web.model.weixin.message.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hccl on 2017/11/16.
 */
public class MessageUtil {

    private static Logger logger = Logger.getLogger(MessageUtil.class);

    public static final String REQ_MESSAGE_TYOE_TEXT = "text";
    public static final String REQ_MESSAGE_TYOE_IMAGE = "image";
    public static final String REQ_MESSAGE_TYOE_VOICE = "voice";
    public static final String REQ_MESSAGE_TYOE_VIDEO = "video";
    public static final String REQ_MESSAGE_TYOE_LOCATION = "location";
    public static final String REQ_MESSAGE_TYOE_LINK = "link";

    public static final String REQ_MESSAGE_TYOE_EVENT = "event";

    public static final String RESP_MESSAGE_TYOE_TEXT = "text";
    public static final String RESP_MESSAGE_TYOE_IMAGE = "image";
    public static final String RESP_MESSAGE_TYOE_VOICE = "voice";
    public static final String RESP_MESSAGE_TYOE_VIDEO = "video";
    public static final String RESP_MESSAGE_TYOE_MUSIC = "music";
    public static final String RESP_MESSAGE_TYOE_NEWS = "news";

    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public static final String EVENT_TYPE_CLICK = "CLICK";
    public static final String EVENT_TYPE_LOCATION = "LOCATION";

    /**
     * 明文模式：解析请求参数
     * @param request
     * @return
     * @throws Exception
     */
    public static HashMap<String, String> parseXml(HttpServletRequest request) throws Exception {
        HashMap<String, String> map = new HashMap<>();

        SAXReader reader = new SAXReader();

        Document doc = reader.read(request.getInputStream());

        Element root = doc.getRootElement();

        recursiveParseXml(root, map);

        return map;
    }

    /**
     * 密文模式：解析请求参数
     * @param request
     * @return
     * @throws Exception
     */
    public static HashMap<String, String> parseXmlCrypt(HttpServletRequest request) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        //获取密文请求
        InputStream in = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //每次读取的内容
        String link = null;
        //最终读取的内容
        StringBuffer sb = new StringBuffer();
        while ((link = br.readLine()) != null) {
            sb.append(link);
        }
        br.close();
        in.close();
        logger.info("【POST请求】获取到的密文是：" + sb.toString());
        //将密文转换为明文
        String timestamp = request.getParameter("timestamp");
        String msgSignature = request.getParameter("msg_signature");
        String nonce = request.getParameter("nonce");
        WXBizMsgCrypt wxCrypt = getWXBizMsgCrypt();
        String fromXML = wxCrypt.decryptMsg(msgSignature, timestamp, nonce, sb.toString());

        //解析xml
        Document doc = DocumentHelper.parseText(fromXML);
        Element root = doc.getRootElement();
        recursiveParseXml(root, map);
        return map;
    }

    /**
     * 获取微信加解密的实例
     * @return
     */
    public static WXBizMsgCrypt getWXBizMsgCrypt() {
        WXBizMsgCrypt wxCrypt = null;
        try {
            wxCrypt = new WXBizMsgCrypt(WxAccessTokenTask.WX_TOKEN, WxAccessTokenTask.WX_ENCODINGAESKEY, WxAccessTokenTask.WX_APPID);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return wxCrypt;
    }

    private static void recursiveParseXml(Element root, HashMap<String, String> map) {
        List<Element> elements = root.elements();

        if (elements.size() == 0) {
            map.put(root.getName(), root.getTextTrim());
        } else {
            for (Element e : elements) {
                recursiveParseXml(e, map);
            }
        }
    }

    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点都增加CDATA标记
                boolean cdata = true;

                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    public static String messageToXML(TextMessage textMessage) {
        xstream.alias("xml", TextMessage.class);
        return xstream.toXML(textMessage);
    }

    public static String messageToXML(ImageMessage imageMessage) {
        xstream.alias("xml", ImageMessage.class);
        return xstream.toXML(imageMessage);
    }

    public static String messageToXML(VoiceMessage voiceMessage) {
        xstream.alias("xml", VoiceMessage.class);
        return xstream.toXML(voiceMessage);
    }

    public static String messageToXML(MusicMessage musicMessage) {
        xstream.alias("xml", MusicMessage.class);
        return xstream.toXML(musicMessage);
    }

    public static String messageToXML(NewsMessage newsMessage) {
        xstream.alias("xml", NewsMessage.class);
        xstream.alias("item", Article.class);
        return xstream.toXML(newsMessage);
    }

    public static String messageToXML(VideoMessage videoMessage) {
        xstream.alias("xml", VideoMessage.class);
        return xstream.toXML(videoMessage);
    }

}
