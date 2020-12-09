package com.http.httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author mengqianxiang
 * @date: 2020/12/9 17:03
 */

public class HttpUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 获取httpClient
     * @param timeOut 请求超时时间
     * @return
     */
    private static HttpClient getHttpClient(int timeOut ){
        // 申请连接超时时间，单位毫秒
        int connectionRequestTimeout = 5000;
        // 连接目标主机超时时间，单位毫秒
        int connectTimeout = 5000;
        // 读取数据超时时间，单位毫秒
        int socketTimeout = 60000;

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(Optional.of(timeOut).orElse(connectTimeout))
                .setSocketTimeout(Optional.of(timeOut).orElse(socketTimeout))
                .setConnectionRequestTimeout(Optional.of(timeOut).orElse(connectionRequestTimeout))
                .build();
        CloseableHttpClient httpCliet = httpClientBuilder
                .setDefaultRequestConfig(config)
                .setConnectionManager()
                .build();

        return httpCliet;
    }

    private static String doGet (String url, Map<String,Object> params){
        HttpClient httpClient = getHttpClient(10000);
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("token","123456789");
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (!entity.isStreaming()){
                LOGGER.debug("doGet entity string ={}",JSOn);
                return
            }else {
                LOGGER.warn("doGet entity is stream");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}