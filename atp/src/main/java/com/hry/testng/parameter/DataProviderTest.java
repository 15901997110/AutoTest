package com.hry.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Test(dataProvider = "dataprovider")
    public void dataProviderTest(String name ,String password){
        System.out.println("name:"+name+";  password:"+password);
    }

    @DataProvider(name = "dataprovider")
    public Object[][] data(){
        return new Object[][]{
                {"zhangsan","123456"},
                {"lisi","000000"}
        };
    }
}
