package com.xiangxue.jack.tomcat;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class LoadServletImpl implements LoadServlet {
    @Override
    public void loadOnstarp(ServletContext servletContext) {
        ServletRegistration.Dynamic initServlet = servletContext.addServlet("initServlet", "com.xiangxue.jack.com.jack.controller.servlet.InitServlet");
        initServlet.setLoadOnStartup(1);
        initServlet.addMapping("/init");

//        ServletRegistration.Dynamic defaults = servletContext.addServlet("default", DefaultServlet.class);
//        defaults.setLoadOnStartup(1);
//        defaults.addMapping("*.css","*.gif","*.jpg","*.js");
    }
}
