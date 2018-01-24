package com.microdao.test.test;

import com.microdao.core.handle.JdbcDao;
import com.microdao.test.init.Testv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fudh on 2018/1/24.
 */
@Service("TestService")
public class TestServiceImpl {

    @Autowired
    private JdbcDao jdbcDao;


    public void  test(){
        Testv testv=new Testv();
        testv.setName("fu");
        testv.setUserName("dahua");
        testv.setThird("big");
        jdbcDao.insert(testv);
        System.out.println("end");
    }
}
