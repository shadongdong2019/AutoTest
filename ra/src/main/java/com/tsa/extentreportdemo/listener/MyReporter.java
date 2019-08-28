package com.tsa.extentreportdemo.listener;

import com.aventstack.extentreports.ExtentTest;

/**
 * @Auther: ***
 * @Date: 2019/3/1
 * @Description:
 */
public class MyReporter {
    public static ExtentTest report;
    private static String testName;

    public static String getTestName() {
        return testName;
    }

    public static void setTestName(String testName) {
        MyReporter.testName = testName;
    }
}