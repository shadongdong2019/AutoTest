package com.course.testng.multithread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotation {
    @Test(invocationCount = 1,threadPoolSize = 10)
    public void test1(){
        System.out.println(1);
        System.out.printf("Thread ID=%s%n",Thread.currentThread().getId());
    }
}