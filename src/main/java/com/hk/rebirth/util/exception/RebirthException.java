package com.hk.rebirth.util.exception;

public class RebirthException extends RuntimeException {

    private String errorCode;

    private String errorMsg;

    RebirthException(){
        super();
    }

    RebirthException(String errorCode,Throwable cause){
        super(cause);
        this.errorCode = errorCode;
    }

    RebirthException(String errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    RebirthException(String errorCode,Object... object){
        this.errorCode = errorCode;
        this.errorMsg = object.toString();
    }
}
