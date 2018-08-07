package com.hk.rebirth.core;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:dongfei.xu
 * @Description:
 * @Date: 2018/8/7 10:29
 */
@Service
public class Show {

    private static Logger logger = LoggerFactory.getLogger(Show.class);

    public void test(){
        String url = "http://127.0.0.1:8083/test/ok";
        Map<String, Object> request = new HashMap();
        request.put("test","test");
        request.put("wang","");
        String result = "";
        try {
            result = sxDispatcherSendPost(url, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public static String sxDispatcherSendPost(String url, Map<String, Object> params) throws IOException {
        List<BasicNameValuePair> pairList = new ArrayList<>();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            pairList.add(new BasicNameValuePair(param.getKey(), param.getValue().toString()));
        }
        HttpPost httpPost = new HttpPost(url);

        //添加代理，用于抓包
//        HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
//        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(8000).setConnectTimeout(8000).setSocketTimeout(8000).setProxy(proxy).build();
//        httpPost.setConfig(requestConfig);

        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));

        HttpClient _httpClient = HttpClients.createDefault();
        HttpResponse resp = _httpClient.execute(httpPost);
        logger.info("resp:{}", JSON.toJSONString(resp));
        return String.valueOf(resp.getStatusLine().getStatusCode());
    }
}
