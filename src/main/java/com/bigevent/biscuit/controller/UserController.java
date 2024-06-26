package com.bigevent.biscuit.controller;

import com.bigevent.biscuit.pojo.Result;
import com.bigevent.biscuit.pojo.User;
import com.bigevent.biscuit.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/user" )
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password) {
       {//查询用户
            User u = userService.findByUserName(username);
            if (u == null) {
                //没有占用
                //注册
                userService.register(username, password);
                return Result.success();
            } else {
                //占用
                return Result.error("用户名已被占用");
            }
        }
    }
}
