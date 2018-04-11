package com.hry.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void test(){
        System.out.println("这是一个异常测试");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
