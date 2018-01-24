package com.microdao.test.init;


import com.microdao.core.annotation.Column;
import com.microdao.core.annotation.Table;

import java.io.Serializable;

/**
 * Created by fudh on 2018/1/24.
 */
@Table(name = "testv",pkField = "id")
public class Testv implements Serializable {
    private int id;
    private String name;
    private String userName;

    @Column(name = "third_name")
    private String third;

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
