package com.xiangxue.jack.service.area;

import com.xiangxue.jack.pojo.ConsultConfigArea;

import java.util.Map;

public interface AreaService {

    String queryAreaFromDB(Map param);

    String queryAreaFromRedisOne(Map param);

    String queryAreaFromRedisTow(Map param);

    int addArea(ConsultConfigArea area);

}
