package com.xiangxue.jack.mvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class SpringApplication {

    public static void main(String[] args) {
        run(SpringApplication.class,args);
    }

    public static void run(Object source, String... args) {
//        return run(new Object[] { source }, args);

        try {
            // 创建Tomcat容器
            Tomcat tomcatServer = new Tomcat();
            // 端口号设置
            tomcatServer.setPort(9090);
            // 读取项目路径 加载静态资源
            StandardContext ctx = (StandardContext) tomcatServer.addWebapp("/", new File("spring-source/src/main").getAbsolutePath());
            // 禁止重新载入
            ctx.setReloadable(false);
            // class文件读取地址
            File additionWebInfClasses = new File("spring-source/target/classes");
            // 创建WebRoot
            WebResourceRoot resources = new StandardRoot(ctx);
            // tomcat内部读取Class执行
            resources.addPreResources(
                    new DirResourceSet(resources, "/spring-source/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
            tomcatServer.start();
            // 异步等待请求执行
            tomcatServer.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

/*    public static ConfigurableApplicationContext run(Object source, String args) {

        // 创建Tomcat容器
        Tomcat tomcatServer = new Tomcat();
        // 端口号设置
        tomcatServer.setPort(8080);
        // 读取项目路径    这样可以加载到静态资源
        StandardContext ctx = null;
        try {
            ctx = (StandardContext) tomcatServer.addWebapp("/", new File("spring-source/src/main").getAbsolutePath());

            // 禁止重新载入
            ctx.setReloadable(false);
            // class文件读取地址    启动后 在target生成编译后的class文件
            File additionWebInfClasses = new File("spring-source/target/classes");
            // 创建WebRoot
            WebResourceRoot resources = new StandardRoot(ctx);
            // tomcat内部读取Class执行
            resources.addPreResources(
                    new DirResourceSet(resources, "/spring-source/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
            tomcatServer.start();
            // 异步等待请求执行
            tomcatServer.getServer().await();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        return null;
    }*/
}
