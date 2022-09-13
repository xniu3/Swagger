package com.swaggerspring.swaggerspring.controllers;

import com.swaggerspring.swaggerspring.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags="这么写就对了")
@RestController
public class HelloController {
    // error请求是默认请求，
    //@RequestMapping(value = "/hello")
    @ApiOperation("Hello控制类")// operation注解是用在方法上的，而不是类。
    @PostMapping(value = "/Bonjour")
    public String Bonjour(@ApiParam("用户名") String username, @ApiParam("密码") String password){
        return "Bonjour" + "Michael" + username + password;
    }
    @PostMapping(value = "/Bonjour2")
    public String Bonjour2(@ApiParam("用户名")String username){
        return username;
    }
    @GetMapping(value = "Michael Niu")
    public String hello(){
        return "hello";
    }
    @PostMapping(value="/Username")
    public User user(String username,String password){
        return new User(username, password);
    }
    //如果将Username以及Password设置为ApiParam则无法传入参数。


}
