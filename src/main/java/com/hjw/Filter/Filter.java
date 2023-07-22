package com.hjw.Filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Filter implements jakarta.servlet.Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        jakarta.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {

    }

    @Override
    public void destroy()
    {
        jakarta.servlet.Filter.super.destroy();
    }
}
