package com.hjw.service.impl;

import com.hjw.POJO.User;
import com.hjw.mapper.UserMapper;
import com.hjw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user)
    {
        User u = userMapper.selectByUsernameAndPassword(user);

        return u;
    }

    @Override
    public void register(User user)
    {
        userMapper.insert(user);
    }

    @Override
    public User verify(User user)
    {
        User u = userMapper.selectByUsernameAndPhone(user);
        return u;
    }

    @Override
    public void update(User user)
    {
        userMapper.update(user);
    }
}
