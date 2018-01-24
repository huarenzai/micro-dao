package com.microdao;

import com.microdao.common.util.NameUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String helloWorld = NameUtils.getColumNameByFiled("helloWorld");
        System.out.println( helloWorld );
    }
}
