package com.hry.testng.multithread;

import org.testng.annotations.Test;

//多线程
public class MultiThreadOnAnnotation {
    @Test(invocationCount = 10,threadPoolSize = 5)
    public void multiThreadTest(){
        System.out.println("1....");
        System.out.printf("Thread ID : %s%n",Thread.currentThread().getId());
    }
}
