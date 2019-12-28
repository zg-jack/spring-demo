package com.xiangxue.jack.service.area;

import com.xiangxue.jack.dao.CommonMapper;
import com.xiangxue.jack.pojo.ConsultConfigArea;
import com.xiangxue.jack.pojo.ZgGoods;
import com.xiangxue.jack.service.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    
    @Transactional
    @Override
    public String queryAreaFromDB(Map param) {
        logger.info("================从mysql里面查询数据 事务1========================");
        List<ConsultConfigArea> areas = commonMapper.queryAreaByAreaCode(param);
        ((AreaService) (AopContext.currentProxy())).queryAreaFromRedisOne(null);
        return "OK";
    }

    @Transactional
    @Override
    public String queryAreaFromRedisOne(Map param) {
        logger.info("================从mysql里面查询数据 事务2========================");
        return "OK";
    }

    @Override
    public String queryAreaFromRedisTow(Map param) {
       return null;
    }

    @Transactional
    @Override
    public int addArea(ConsultConfigArea area) {
        int i = commonMapper.addArea(area);

        new Thread(() -> {
            ZgGoods zgGoods = new ZgGoods();
            zgGoods.setGoodName("CQWW4");
            zgGoods.setGoodCode("CQWW4");
            zgGoods.setCount(100);

            goodsService.addGoods(zgGoods);
        }).start();

        return i;
    }
}
