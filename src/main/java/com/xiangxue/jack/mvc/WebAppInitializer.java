package com.xiangxue.jack.mvc;

import com.xiangxue.jack.filter.CorsFilter;
import com.xiangxue.jack.filter.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringContainer.class};
    }

    //SpringMVC配置子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcContainer.class};
    }

    //获取DispatcherServlet的映射信息
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        MyFilter myFilter = new MyFilter();
        CorsFilter corsFilter = new CorsFilter();
        return new Filter[]{myFilter,corsFilter};
    }
}
