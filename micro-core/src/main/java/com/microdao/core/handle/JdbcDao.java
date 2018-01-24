package com.microdao.core.handle;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/24.
 */
public interface JdbcDao {
    /**
     * 插入一条数据
     * @param entity
     * @param <T>
     * @return
     */
    void insert(Object entity);
}
