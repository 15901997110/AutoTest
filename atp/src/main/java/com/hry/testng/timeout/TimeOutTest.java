package com.hry.testng.timeout;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)//3000ms=3s
    public void timeoutSuccess() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }
    @Test(timeOut = 2000)
    public void timeoutFaled() throws InterruptedException {
        Thread.sleep(3000);
    }
}
