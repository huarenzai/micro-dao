package com.microdao.common.exception;

/**
 * Created by fudh on 2018/1/24.
 */
public class MicroException extends RuntimeException {

    public MicroException(String msg){
        super(msg);
    }
    public MicroException(String msg,Throwable e){
        super(msg,e);
    }
}
