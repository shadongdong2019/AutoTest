package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {
    public void sut1(){
        System.out.println("GroupsOnClasss2中的sut1运行");
    }

    public void sut2(){
        System.out.println("GroupsOnClasss2中的sut2运行");
    }
}
