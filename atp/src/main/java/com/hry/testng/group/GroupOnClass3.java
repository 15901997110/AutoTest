package com.hry.testng.group;

import org.testng.annotations.Test;

@Test(groups="teacher")
public class GroupOnClass3 {
    public void test1(){
        System.out.println("teacher.test1");
    }
    public void test2(){
        System.out.println("teacher.test2");
    }
}
