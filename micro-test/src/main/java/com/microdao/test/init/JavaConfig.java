package com.microdao.test.init;

import com.alibaba.druid.pool.DruidDataSource;
import com.dexcoder.dal.SimpleSqlFactory;
import com.microdao.core.handle.JdbcDao;
import com.microdao.core.handle.impl.JdbcDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by fudh on 2018/1/24.
 */
@Configuration
@ComponentScan(basePackages = {"com.microdao.test.test"})
public class JavaConfig {


    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return  dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public SimpleSqlFactory sqlFactory(){
        return new SimpleSqlFactory();
    }

    @Bean
    public JdbcDao jdbcDao(JdbcTemplate jdbcTemplate, SimpleSqlFactory sqlFactory){
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setJdbcTemplate(jdbcTemplate);
        return jdbcDao;
    }
}
