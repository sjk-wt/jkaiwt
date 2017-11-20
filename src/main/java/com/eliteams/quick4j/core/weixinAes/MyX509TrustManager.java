package com.eliteams.quick4j.core.weixinAes;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by hccl on 2017/11/18.
 */
public class MyX509TrustManager implements X509TrustManager {
    //信任客户端证书
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }
    //信任服务端证书
    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }
    //返回信任证书信息数组
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
