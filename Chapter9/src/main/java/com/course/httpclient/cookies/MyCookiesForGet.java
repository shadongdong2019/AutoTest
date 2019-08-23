package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private  CookieStore  store;
    @BeforeTest
    public void beforeTest(){
        //只写配置文件名就可以，不用写扩展名，getBundle方法自动匹配.properties文件
        //如果.properties配置文件在resources文件夹下面，不用写路径，直接写配置文件名就可以
        //如果.properties配置文件不在resources文件夹下面，文件名需要写完整路径名（绝对路径或相对路径）
        //Locale.CHINA 表示字符编码
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void terstGetCookies() throws IOException {
        String result;
        //从配置文件中拼接url
        String uri= bundle.getString("getCookies.uri");
        String testUrl=url+uri;
        //测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        System.out.println(cookieList);
        for(Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name="+name+";  cookie value="+value);
        }
    }
    @Test(dependsOnMethods = {"terstGetCookies"})
    public void testGetWithCookies() throws IOException {
        String result;
        String uri = bundle.getString("test.get.cookie.demo");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);
        if(statusCode == 200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println("获取的文本内容="+result);
        }



    }
}
