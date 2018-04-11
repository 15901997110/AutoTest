package com.hry.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnno {
    @Test
    public void test1(){
        System.out.println("这是测试1");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before Test");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after test");
    }


}
