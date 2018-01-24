package com.microdao;

import com.microdao.test.init.JavaConfig;
import com.microdao.test.test.TestServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        TestServiceImpl testServiceImpl = (TestServiceImpl)context.getBean("TestService");
        testServiceImpl.test();
    }
}
