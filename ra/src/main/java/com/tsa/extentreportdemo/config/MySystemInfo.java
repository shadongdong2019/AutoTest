package com.tsa.extentreportdemo.config;

import com.vimalselvam.testng.SystemInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: ***
 * @Date:2019/3/1
 * @Description:
 */
public class MySystemInfo implements SystemInfo {

    @Override
    public Map<String, String> getSystemInfo() {

        Map<String, String> systemInfo = new HashMap<>();
        systemInfo.put("测试人员", "majing");

        return systemInfo;
    }
}