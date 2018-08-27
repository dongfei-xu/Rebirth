package com.hk.rebirth.util.common;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:dongfei.xu
 * @Description: Http 请求操作类
 * @Date: 2018/8/21 15:06
 */
public class HttpUtils {

    /**
     *  网络环境配置
     */
    private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(15000).setConnectTimeout(15000)
            .setConnectionRequestTimeout(15000).build();

    public static String sendPost(String url, Map<String, String> params) throws Exception{
        // httpClient
        CloseableHttpClient httpClient = null;
        // httpClient 响应参数
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;

        UrlEncodedFormEntity urlEncoded = null;

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        // 创建参数队列
        List<NameValuePair> nvps = new ArrayList<>();
        for(String paramKey:params.keySet()){
            nvps.add(new BasicNameValuePair(paramKey, params.get(paramKey)));
        }
        try{
            httpClient = HttpClients.createDefault();

            urlEncoded = new UrlEncodedFormEntity(nvps, "UTF-8");
            httpPost.setEntity(urlEncoded);
            response = httpClient.execute(httpPost);
            // 获取响应状态吗
            int statusCode = response.getStatusLine().getStatusCode();

            if(null != response) {
                entity = response.getEntity();
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            httpClient.close();
        }
        return responseContent;
    }

    public static void main(String[] args) throws Exception{
        String url = "http://127.0.0.1:8081/api/controller4902/test";
        Map<String, String> param = new HashMap<>();
        param.put("mobileNo", "15617729820");
        param.put("taskId", "MJ_0000001");
        String s = HttpUtils.sendPost(url, param);

        System.out.println(s);
    }
}
