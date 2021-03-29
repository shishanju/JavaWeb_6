package com.lemon.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "/*")
public class EnCodeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器工作中");
        //解决post中文乱码
        request.setCharacterEncoding("utf-8");
        //放行
        chain.doFilter(request, response);
    }
}
