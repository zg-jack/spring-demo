package com.xiangxue.jack.dao;

import com.xiangxue.jack.pojo.ConsultConfigArea;
import com.xiangxue.jack.pojo.ZgGoods;
import com.xiangxue.jack.pojo.ZgTicket;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommonMapper {

    @Select("select * from consult_configarea where areaCode=#{areaCode}")
    List<ConsultConfigArea> queryAreaByAreaCode(Map param);

    @Insert("insert into consult_configarea(AREACODE,AREANAME,STATE) values(#{areaCode},#{areaName},#{state})")
    int addArea(ConsultConfigArea area);

    @Insert("insert into zg_goods (goodCode, goodName, count\n" +
            "\t\t)\n" +
            "\t\tvalues (#{goodCode,jdbcType=VARCHAR}, #{goodName,jdbcType=VARCHAR},\n" +
            "\t\t#{count,jdbcType=INTEGER}\n" +
            "\t\t)")
    int addGood(ZgGoods zgGoods);

    @Select("select * from zg_goods where goodCode=#{goodCode}")
    List<ZgGoods> queryGoodsByGoodCode(String goodCode);

    @Select("select * from zg_goods")
    List<ZgGoods> queryAll();

    @Update("update zg_ticket set version=versoin+1 where ticketId = #{ticketId} and version = #{version}")
    int updateLock(Map map);


    @Select("select * from zg_ticket where ticketId = #{ticketId}")
    List<ZgTicket> queryTicketById(String ticketId);

    @Update("update zg_ticket set ticketCount=ticketCount-#{ticketCount} where ticketId = #{ticketId} and ticketCount >= #{ticketCount}")
    int updateTicket(ZgTicket zgTicket);
}
