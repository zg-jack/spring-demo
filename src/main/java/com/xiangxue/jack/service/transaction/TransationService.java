package com.xiangxue.jack.service.transaction;


import com.xiangxue.jack.pojo.ConsultConfigArea;
import com.xiangxue.jack.pojo.ZgGoods;

public interface TransationService {

    void transation(ConsultConfigArea area, ZgGoods zgGoods);

    int getTicket();

    int getTicketModeOne();
}
