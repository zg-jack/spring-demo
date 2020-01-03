package com.xiangxue.jack.service.area;

import com.xiangxue.jack.dao.CommonMapper;
import com.xiangxue.jack.pojo.ConsultConfigArea;
import com.xiangxue.jack.service.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@PropertySource("classpath:config/core/core.properties")
@Service
public class AreaServiceImpl implements AreaService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${jdbc.driverClassName}")
    private String driverClass;
    @Value("${jdbc.url:jdbc}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    AreaService areaService;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = RuntimeException.class)
    @Override
    public String queryAreaFromDB(Map param) {
        logger.info("================从mysql里面查询数据 事务1========================");
        List<ConsultConfigArea> areas = commonMapper.queryAreaByAreaCode(param);

//        new Thread(() -> areaService.queryAreaFromRedisOne(null)).start();

//        areaService.queryAreaFromRedisOne(null);
        return "OK";
    }

    @Transactional
    @Override
    public String queryAreaFromRedisOne(Map param) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("================从mysql里面查询数据 事务2========================");
        return "OK";
    }

    @Transactional
    @Override
    public String queryAreaFromRedisTow(Map param) {
        return "OK";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int addArea(ConsultConfigArea area) {
        int i = commonMapper.addArea(area);
        return i;
    }
}
