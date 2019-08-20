package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("name="+name +";   age="+age);
    }
    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",20},
                {"wangwu",25}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1中的name="+name +";   age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2中的name="+name +";   age="+age);
    }
    @DataProvider(name="methodData")
    public Object[][] methodProvider(Method method){
        Object[][] o=null;
        if(method.getName().equals("test1")){
            o = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",25}
            };
        }else if(method.getName().equals("test2")){
            o = new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",60}
            };
        }
        return o;
    }
}
