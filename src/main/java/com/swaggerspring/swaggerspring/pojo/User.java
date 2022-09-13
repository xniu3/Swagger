package com.swaggerspring.swaggerspring.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("User entity class")
public class User {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
