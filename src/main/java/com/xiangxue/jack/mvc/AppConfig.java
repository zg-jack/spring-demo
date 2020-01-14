package com.xiangxue.jack.mvc;

import com.xiangxue.jack.interceptor.UserInterceptor;
import com.xiangxue.jack.interceptor.UserInterceptor1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.jsp("/jsp/", ".jsp");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/view/ok").setViewName("ok");
        registry.addViewController("/view/index").setViewName("index");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor).addPathPatterns("/user/**").excludePathPatterns("/user/query/**");
        registry.addInterceptor(new UserInterceptor1()).addPathPatterns("/user/**").excludePathPatterns("");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("classpath:/img/");
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        super.configureHandlerExceptionResolvers(exceptionResolvers);
    }


/*    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .maxAge(3600);
    }*/
}
