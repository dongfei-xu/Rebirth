package com.hk.rebirth.util.exception;

import lombok.Data;

import java.io.File;

/**
 * @Author:dongfei.xu
 * @Date: 2018/6/22 14:17
 */
@Data
public class RebirthException extends RuntimeException {
    private String errorCode ;

    private String errorMsg;

    public RebirthException(){

    }

    public RebirthException(String message){
        super(message);
    }
    public RebirthException(Throwable cause){
        super(cause);
    }

    public RebirthException(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    public RebirthException(String message, Throwable cause){
        super(message, cause);
    }

    public static void main(String[] args){
        new Throwable("错误信息");
    }

}
