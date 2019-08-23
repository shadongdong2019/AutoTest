package com.course.testng.multithread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
    @Test
    public void test1(){
        System.out.printf("Thread ID=%s",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("Thread ID=%s",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("Thread ID=%s",Thread.currentThread().getId());
    }
}