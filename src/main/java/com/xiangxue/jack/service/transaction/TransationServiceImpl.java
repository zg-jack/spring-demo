package com.xiangxue.jack.service.transaction;

import com.xiangxue.jack.pojo.ConsultConfigArea;
import com.xiangxue.jack.pojo.ZgGoods;
import com.xiangxue.jack.service.area.AreaService;
import com.xiangxue.jack.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("transationServiceImpl")
public class TransationServiceImpl implements TransationService {

    @Autowired
    AreaService areaService;

    @Autowired
    GoodsService goodsService;

    //开启了事务
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    @Override
    public void transation(ConsultConfigArea area, ZgGoods zgGoods) {
        try {
            areaService.addArea(area);
            goodsService.addGoods(zgGoods);
        }catch (Exception e) {

        }
    }
    //提交事务
}
