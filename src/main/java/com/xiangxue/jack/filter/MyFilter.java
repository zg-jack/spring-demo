package com.xiangxue.jack.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("======");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("======doFilter");

        //放行
        chain.doFilter((HttpServletRequest)request,(HttpServletResponse)response);
    }

    @Override
    public void destroy() {

    }
}
