package com.xiangxue.jack.test;

import com.xiangxue.jack.bean.ComponentScanBean;
import com.xiangxue.jack.service.cache.CacheService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CacheTest {

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }
    
    @Test
    public void test1() {
        CacheManager bean = applicationContext.getBean(CacheManager.class);
        Cache cache = bean.getCache("redisCache");
        cache.put("cacheName","redisCache");
        Cache.ValueWrapper cacheName = cache.get("cacheName");
        System.out.println(cacheName.get());
    }

    @Test
    public void test2() {
        CacheService bean = applicationContext.getBean(CacheService.class);
        bean.queryData("XJ14");
    }

    @Test
    public void test3() {
        CacheService bean = applicationContext.getBean(CacheService.class);
        bean.putCache("XJ14");

        bean.getCache("XJ14");
    }

    @Test
    public void test4() {
        CacheService bean = applicationContext.getBean(CacheService.class);
        System.out.println(bean.mapCache("123456"));

        System.out.println(bean.mapCache("123456"));
    }
}
