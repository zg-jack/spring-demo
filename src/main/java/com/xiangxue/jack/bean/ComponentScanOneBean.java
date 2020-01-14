package com.xiangxue.jack.bean;

import com.xiangxue.jack.datasource.DataSourceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackageClasses = DataSourceConfiguration.class)
public class ComponentScanOneBean {
}
