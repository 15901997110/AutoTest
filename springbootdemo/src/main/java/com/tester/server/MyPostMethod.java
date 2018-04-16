package com.tester.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value="/",description = "这是我全部的post方法")
@RequestMapping("/post")
public class MyPostMethod {
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ApiOperation(value="登录接口,成功后获取Cookies信息",httpMethod ="POST" )
    public String login(HttpServletResponse response,
                        @RequestParam(value="userName",required = true) String name,
                        @RequestParam(value="password",required = true) String pwd){
        if(name.equals("zhangsan")&&pwd.equals("123456")) {
            response.addCookie(new Cookie("login", "lunimei-post"));
            return "恭喜你,登录成功,用户:lunimei-post";
        }else{
            return "请输入正常的用户名和密码!";
        }
    }
}
