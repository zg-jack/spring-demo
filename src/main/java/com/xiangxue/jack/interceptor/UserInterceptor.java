package com.xiangxue.jack.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor extends HandlerInterceptorAdapter {

    public static void main(String[] args) {
        ThreadLocal t = new ThreadLocal();
        t.set("jack");
        System.out.println("======before gc==" + t.get());
        System.gc();
        System.out.println("======after gc==" + t.get());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("======UserInterceptor用户权限校验=========");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========UserInterceptor修改modelAndView======");
        int status = response.getStatus();
        System.out.println("========UserInterceptor修改modelAndView======" + status);
//        HttpSession session = request.getSession();
//        if(modelAndView != null && session != null) {
//            String modifyViewName = modelAndView.getViewName() + "_" + session.getAttribute("language");
//            modelAndView.setViewName(modifyViewName);
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========UserInterceptor资源释放======");
    }
}
