package com.xiangxue.jack.service.cache;

import com.alibaba.fastjson.JSONObject;
import com.xiangxue.jack.dao.CommonMapper;
import com.xiangxue.jack.pojo.ConsultConfigArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CommonMapper commonMapper;

    @Cacheable(cacheNames = "redisCache",key = "'jack' + #id")
    @Override
    public String queryData(String id) {
        System.out.println("======CacheServiceImpl.queryData");
        List<ConsultConfigArea> areas = commonMapper.queryAreaById(id);
        return JSONObject.toJSONString(areas);
    }

    @CachePut(cacheNames = "redisCache",key = "'jack' + #id")
    @Override
    public String putCache(String id) {
        System.out.println("======CacheServiceImpl.queryData");
        List<ConsultConfigArea> areas = commonMapper.queryAreaById(id);
        return JSONObject.toJSONString(areas);
    }

    @Cacheable(cacheNames = "redisCache",key = "'jack' + #id")
    @Override
    public String getCache(String id) {
        return null;
    }

    @Cacheable(cacheNames = "mapCache",key = "'jack' + #id")
    @Override
    public String mapCache(String id) {
        System.out.println("=========CacheServiceImpl.mapCache");
        return "数据存储在map中";
    }
}
