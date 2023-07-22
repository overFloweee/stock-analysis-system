package com.hjw.Controller;


import com.hjw.POJO.Result;
import com.hjw.POJO.User;
import com.hjw.service.UserService;
import com.hjw.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class loginController
{
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user)
    {
        log.info("用户登陆：{}{}", user.getUsername(), user.getPassword());
        User u = userService.login(user);

        // 如果登陆成功则下发令牌
        if (u != null)
        {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", u.getUsername());
            claims.put("phone", u.getPhone());

            String jwt = JwtUtils.generate(claims);

            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误！");
    }


    @PutMapping("/register")
    public Result resgister(@RequestBody User user)
    {
        log.info("用户注册：{}", user);
        userService.register(user);

        return Result.success();
    }

    @PostMapping("/verify")
    public Result verify(@RequestBody User user)
    {
        log.info("用户校验的信息：{}{}", user.getUsername(), user.getPhone());
        User u = userService.verify(user);
        return u != null ? Result.success() : Result.error("校验的用户名和手机号不匹配！");
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user)
    {
        log.info("用户{}密码的更新{}", user.getUsername(), user.getPassword());
        userService.update(user);

        return Result.success();
    }

}

