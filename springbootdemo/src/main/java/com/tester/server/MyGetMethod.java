package com.tester.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookeis", method = RequestMethod.GET)
    @ApiOperation("访问得到Cookies信息")
    public String getCookies(HttpServletResponse response) {
        Cookie login = new Cookie("login", "lunimei-true");
        response.addCookie(login);
        return "获取cookies成功";
    }

    @RequestMapping(value = "/getWithCookies", method = {RequestMethod.GET})
    @ApiOperation("携带Cookies信息才可以访问成功")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {

        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login") && cookie.getValue().equals("lunimei-true")) {
                    return "恭喜你,携带Cookie访问我成功";
                }
            }
        }
        return "需要携带Cookies信息才可访问我!";
    }
    @RequestMapping(value="/get/param/{startParam}/{endParam}",method=RequestMethod.GET)
    @ApiOperation("按页数及每页显示条数查询商品列表")
    public String getWithParam(@PathVariable("startParam") Integer start,@PathVariable("endParam") Integer end){
        return "带参数的响应,start:"+start+",end:"+end;
    }
}
