package com.xiangxue.jack.service.goods;

import com.xiangxue.jack.pojo.ZgGoods;

import java.util.List;

public interface GoodsService {

    void addGoods(ZgGoods zgGoods);

    List<ZgGoods> queryAll();
}
