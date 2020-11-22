package com.nx.dynamic.ds.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.nx.dynamic.ds.properties.DataBaseMastProperties;
import com.nx.dynamic.ds.properties.DataBaseSlaveProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Slf4j
public class DataSourceConfig {

    @Autowired
    private DataBaseMastProperties dataBaseMastProperties;

    @Autowired
    private DataBaseSlaveProperties dataBaseSlaveProperties;

    @Bean(name = "dataBaseMastDataSource")
    @Primary
    public DataSource dataBaseMastDataSource() throws SQLException {
        log.info("----------dataBaseMastDataSource install--------------");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataBaseMastProperties.getUrl());
        dataSource.setUsername(dataBaseMastProperties.getUsername());
        dataSource.setPassword(dataBaseMastProperties.getPassword());
        dataSource.setDriverClassName(dataBaseMastProperties.getDriverClassName());
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 1 FROM DUAL");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(25);
        dataSource.setFilters("stat,wall,slf4j");
        dataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500");
        dataSource.setUseGlobalDataSourceStat(true);
        return dataSource;
    }

    @Bean(name = "dataBaseSlaveDataSource")
    public DataSource dataBaseSlaveDataSource() throws SQLException {
        log.info("----------DataBaseSlaveDataSource install--------------");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataBaseSlaveProperties.getUrl());
        dataSource.setUsername(dataBaseSlaveProperties.getUsername());
        dataSource.setPassword(dataBaseSlaveProperties.getPassword());
        dataSource.setDriverClassName(dataBaseSlaveProperties.getDriverClassName());
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 1 FROM DUAL");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(25);
        dataSource.setFilters("stat,wall,slf4j");
        dataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500");
        dataSource.setUseGlobalDataSourceStat(true);
        return dataSource;
    }

}
