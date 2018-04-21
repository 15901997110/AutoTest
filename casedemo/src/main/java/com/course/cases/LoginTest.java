package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFileUtil;
import com.course.utils.DbUtil;
import org.apache.http.impl.client.HttpClients;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeTest
    public void beforeTest(){
        TestConfig.getUserInfoUrl= ConfigFileUtil.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl=ConfigFileUtil.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserUrl= ConfigFileUtil.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.loginUrl=ConfigFileUtil.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl=ConfigFileUtil.getUrl(InterfaceName.UPDATEUSERINFO);

        TestConfig.httpClient= HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();
    }

    @Test(groups = "loginTrue",description = "登录成功接口测试")
    public void loginTrue() throws Exception{
        SqlSession session= DbUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }
    @Test(groups = "loginFalse",description = "登录失败接口测试")
    public void loginFalse() throws Exception{
        SqlSession session= DbUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }
}
