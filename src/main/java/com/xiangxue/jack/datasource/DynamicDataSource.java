package com.xiangxue.jack.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        String ds = DynamicDataSourceHolder.getDs();

        System.out.println("=========选择的数据源：" + ds);
        return ds;
    }
}
