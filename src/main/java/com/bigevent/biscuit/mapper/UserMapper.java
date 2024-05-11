package com.bigevent.biscuit.mapper;

import com.bigevent.biscuit.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    //根据用户名查询
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);
    //添加
    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{username},#{password},now(),now())")
    void add(@Param("username") String username, @Param("password") String password);
}
