package com.xiangxue.jack.service.goods;

import com.xiangxue.jack.dao.CommonMapper;
import com.xiangxue.jack.pojo.ZgGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    CommonMapper commonMapper;

    @Transactional
    @Override
    public int addGoods(ZgGoods zgGoods) {
        int i = commonMapper.addGood(zgGoods);
        return i;
    }
}
