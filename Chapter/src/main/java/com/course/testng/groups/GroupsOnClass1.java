package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {
    public void sut1(){
        System.out.println("GroupsOnClasss1中的sut1运行");
    }

    public void sut2(){
        System.out.println("GroupsOnClasss1中的sut2运行");
    }
}
