package com.xiangxue.jack.filter;

import javax.servlet.*;
import java.io.IOException;

public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    /*
    * value、origins属性：配置允许访问的源，如: http://anxminise.cc，*表示允许全部的域名
        methods属性：配置跨域请求支持的方式，如：GET、POST，且一次性返回全部支持的方式
        maxAge属性：配置预检请求的有效时间， 单位是秒，表示：在多长时间内，不需要发出第二次预检请求
        allowCredentials属性：配置是否允许发送Cookie，用于 凭证请求， 默认不发送cookie
        allowedHeaders属性：配置允许的自定义请求头，用于 预检请求
        exposedHeaders属性：配置响应的头信息， 在其中可以设置其他的头信息，不进行配置时， 默认可以获取到Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma字段
    *
    * */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("=========跨域过滤器=========");
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
