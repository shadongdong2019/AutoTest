package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是第一个测试用例");
    }
    @Test
    public void testCase2(){
        System.out.println("这是第二个测试例");
    }

    @BeforeMethod
    public void beforMethod(){
        System.out.println("这个是在测试用例执行之前执行的方法");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在测试用例执行之后执行的方法");
    }
    @BeforeClass
    public void beforClass(){
        System.out.println("这是在类之前执行的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("这是在类之后执行的方法");
    }
    @BeforeSuite
    public void beforSuite(){
        System.out.println("类之前运行测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("类之后运行测试套间");
    }
}
