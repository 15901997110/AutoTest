package com.hry.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu2")
public class GroupOnClass2 {
    public void test1(){
        System.out.println("stu2.test1");
    }
    public void test2(){
        System.out.println("stu2.test2");
    }
}
