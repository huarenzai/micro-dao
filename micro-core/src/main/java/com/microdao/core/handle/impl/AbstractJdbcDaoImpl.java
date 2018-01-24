package com.microdao.core.handle.impl;

import org.springframework.jdbc.core.JdbcOperations;

/**
 * 操作对象
 * Created by fudh on 2018/1/24.
 */
public abstract class AbstractJdbcDaoImpl {
    /**
     * spring jdbc 对象
     */
    protected JdbcOperations jdbcTemplate;

    public JdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
