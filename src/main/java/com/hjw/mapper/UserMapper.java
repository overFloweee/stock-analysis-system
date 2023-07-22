package com.hjw.mapper;

import com.hjw.POJO.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper
{

    @Select("select * from user where username =#{username} and password =#{password}")
    User selectByUsernameAndPassword(User user);

    @Insert("insert into user (username, password, phone) values (#{username},#{password},#{phone})")
    void insert(User user);

    @Select("select * from user where username = #{username} and phone = #{phone}")
    User selectByUsernameAndPhone(User user);

    @Update("update user set password = #{password} where username = #{username}")
    void update(User user);
}
