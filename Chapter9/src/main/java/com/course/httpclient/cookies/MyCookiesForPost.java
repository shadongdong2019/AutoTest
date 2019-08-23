package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private CookieStore store;
    private ResourceBundle bundles;

    @BeforeTest
    public void beforeTest(){
        //获取配置文件内容
        this.bundles = ResourceBundle.getBundle("application", Locale.CHINA);
        //获取配置文件中具体的url
        this.url = this.bundles.getString("test.url");
    }
    @Test
    public void terstGetCookies() throws IOException {
        //获取配置文件中请求地址的路径
        String uri = this.bundles.getString("getCookies.uri");
        //拼接最终的请求地址
        String testurl = this.url+uri;
        //创建client执行get请求
        DefaultHttpClient client = new DefaultHttpClient();
        //创建get请求
        HttpGet  get = new HttpGet(testurl);
        //执行get请求,并获取响应结果
        HttpResponse response = client.execute(get);
        //获取响应结果
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        //获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookieList = this.store.getCookies();
        for(Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name="+name+";  cookie value="+value);
        }
    }
    @Test(dependsOnMethods = {"terstGetCookies"})
    public void testPostMethod() throws IOException {
        //获取请求地址路径
        String uri = this.bundles.getString("test.post.cookie.demo");
        //获取最终的请求地址
        String testurl = this.url+uri;
        //声名一个client对像，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声名一个post请求方法
        HttpPost post = new HttpPost(testurl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","wangwu");
        param.put("age","15");
        //设置请求头信息headers
        post.setHeader("content-type","application/json");
        //将参数信息添加到post方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声名一个对像来进行响应结果存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取字符串格式的响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理响结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转化成为json对像
        JSONObject resultJson = new JSONObject(result);
        //获取结果值
        String success = (String) resultJson.get("huhansan");
        String age = (String) resultJson.get("age");
        //具体判断返回的结果值
        Assert.assertEquals("success",success);
        Assert.assertEquals("success",age);
    }
}
