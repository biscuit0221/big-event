package com.bigevent.biscuit.service.impl;

import com.bigevent.biscuit.pojo.User;

public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);
    //注册
    void register(String username, String password);
}
