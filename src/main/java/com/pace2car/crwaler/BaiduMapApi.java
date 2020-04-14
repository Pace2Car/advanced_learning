package com.pace2car.crwaler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author chenjiahao
 * @date 2019/11/4 13:44
 */
public class BaiduMapApi {
    private static final String AK = "wb0yPcSzO3sOjz2PGLk7R0VutrccOZD4";

    public static void main(String[] args) throws IOException {
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个get请求
        HttpGet httpget = new HttpGet("http://api.map.baidu.com/place/v2/search?query=停车场&tag=停车场&region=成都&page_size=200&page_num=0&scope=2&output=json&ak=" + AK);

        HttpGet detailGet = new HttpGet("http://api.map.baidu.com/place/v2/detail?uid=d74a2ce7a5f59fd407026f7a&output=json&scope=2&ak=" + AK);
        //3.执行get请求并返回结果
        CloseableHttpResponse response = httpclient.execute(httpget);
        CloseableHttpResponse detailRes = httpclient.execute(detailGet);
        try {
            //4.处理结果
            HttpEntity httpEntity = response.getEntity();
            String result = EntityUtils.toString(httpEntity);
            System.out.println(result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject.get("results"));

            HttpEntity detailEntity = detailRes.getEntity();
            String detail = EntityUtils.toString(detailEntity);
            System.out.println(detail);
            JSONObject detailObject = JSONObject.parseObject(detail);
            System.out.println(detailObject);
        } finally {
            response.close();
        }
    }
}
