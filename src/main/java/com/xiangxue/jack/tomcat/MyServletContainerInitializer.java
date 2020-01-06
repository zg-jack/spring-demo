package com.xiangxue.jack.tomcat;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

@HandlesTypes(LoadServlet.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        Iterator var4;
        if (set != null) {
            var4 = set.iterator();
            while (var4.hasNext()) {
                Class<?> clazz = (Class<?>) var4.next();
                if (!clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers()) && LoadServlet.class.isAssignableFrom(clazz)) {
                    try {
                        ((LoadServlet) clazz.newInstance()).loadOnstarp(servletContext);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
