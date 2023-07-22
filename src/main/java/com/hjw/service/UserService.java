package com.hjw.service;


import com.hjw.POJO.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService
{
    User login(User user);

    void register(User user);

    User verify(User user);

    void update(User user);
}
