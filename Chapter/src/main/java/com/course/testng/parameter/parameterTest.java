package com.course.testng.parameter;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterTest {
    @Test
    @Parameters({"name","age"})
    public void test(String name,int age){
        System.out.println("name="+name+",age="+age);
    }
}
