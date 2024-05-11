package com.bigevent.biscuit.service.impl;

import com.bigevent.biscuit.utils.Md5Util;
import com.bigevent.biscuit.mapper.UserMapper;
import com.bigevent.biscuit.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //密码要进行加密处理
        String md5String = Md5Util.getMD5String(password);
        //添加
        userMapper.add(username,md5String);
    }
}
