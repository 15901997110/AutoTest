package com.tester;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MyTestClass {
    @Test
    public void test1(){
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        Assert.assertTrue(true);
    }
    @Test
    public void test3(){
        Assert.assertTrue(true);
    }
    @Test
    public void test4(){
        Assert.assertTrue(true);
    }
    @Test
    public void test5(){
        Assert.assertTrue(true);
    }
    @Test
    public void test6(){
        Assert.assertTrue(false);
    }
    @Test
    public void test7(){
        Assert.assertTrue(true);
    }
    @Test
    public void test8(){
        Reporter.log("这是我自己使用Reporter打印的log");
    }
    @Test
    public void test9(){
        throw new RuntimeException("这是我自己抛的异常!");
    }
}
