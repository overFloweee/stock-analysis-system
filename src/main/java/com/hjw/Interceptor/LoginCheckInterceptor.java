package com.hjw.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// @Component
public class LoginCheckInterceptor implements HandlerInterceptor
{
    @Override   // 在Controller里的方法执行之前的方法。放行为 true,否则为false
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("preHandle...");
        return true;
    }

    @Override   // 在Controller里的方法执行之后的方法。
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        System.out.println("postHandle...");
    }

    @Override  // 视图渲染完毕之后，才执行的方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        System.out.println("afterCompletion...");
    }
}
