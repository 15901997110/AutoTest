package com.hry.testng.suite;

import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void login(){
        System.out.println("登录成功!");
    }

    @Test(enabled=false)
    public void login2(){
        System.out.println("用例忽略!");
    }
}
