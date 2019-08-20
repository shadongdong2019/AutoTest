package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void groupsOnServer1(){
        System.out.println("这是服务器端测试用例111111111");
    }
    @Test(groups = "server")
    public void groupsOnServer2(){
        System.out.println("这是服务器端测试用例22222222");
    }
    @Test(groups = "client")
    public void groupsOnClient3(){
        System.out.println("这是客户端测试用例3333333");
    }
    @Test(groups = "client")
    public void groupsOnClient4(){
        System.out.println("这是客户端测试用例44444444");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("服务器端用例执行之前");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("服务器端用例执行之后");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("客户端用例执行之前");
    }
    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("客户端用例执行之后");
    }
}
