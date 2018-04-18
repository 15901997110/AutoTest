package com.tester.server;

import com.tester.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value="MyPostMethod",description = "这是我全部的post方法")
@RequestMapping("/MyPostMethod")
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

    @RequestMapping(value="/getUserList",method=RequestMethod.POST)
    @ApiOperation(value="获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request , @RequestBody User u){
        Cookie[] cookies = request.getCookies();
        if(!Objects.isNull(cookies)){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("login")&&cookie.getValue().equals("lunimei-post")
                        &&u.getName().equals("luqiwei")){
                    User user=new User();
                    user.setName("lisi");
                    user.setAge(18);
                    user.setSex("M");
                    return user.toString();
                }
            }
        }
        return "需要携带cookie才有权限获取用户列表!";
    }
}
