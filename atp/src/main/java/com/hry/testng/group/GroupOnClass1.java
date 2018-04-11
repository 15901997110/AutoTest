package com.hry.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu1")
public class GroupOnClass1 {
    public void test1(){
        System.out.println("stu1.test1");
    }
    public void test2(){
        System.out.println("stu1.test2");
    }
}
