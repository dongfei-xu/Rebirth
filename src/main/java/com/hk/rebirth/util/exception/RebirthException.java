package com.hk.rebirth.util.exception;

/**
 * @Author:dongfei.xu
 * @Date: 2018/6/22 14:17
 */
public class RebirthException extends RuntimeException {
    private String errorCode ;

    private String errorMsg;

    public RebirthException(){

    }

    public RebirthException(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
