package com.tester.cotroller;

import com.tester.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
//import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Log4j
@RestController
@Api(value="demo",description = "MyBatis Controller第一个demo")
@RequestMapping(value = "/demo")
public class UserController {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    //private SqlSessionFactory sqlSessionFactory;
    @RequestMapping(value="/getUserCount",method= RequestMethod.GET)
    @ApiOperation("获取用户总数")
    public int getUserCount(){
        return sqlSessionTemplate.selectOne("getUserCount");
    }
    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public void addUser(@RequestBody User user){
        sqlSessionTemplate.insert("addUser",user);
    }
}
