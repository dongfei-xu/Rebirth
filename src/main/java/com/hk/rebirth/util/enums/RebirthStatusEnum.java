package com.hk.rebirth.util.enums;

/**
 *
 */
public enum RebirthStatusEnum {

    SUCC("SUCC","成功"),
    INIT("INIT", "初始化"),
    HANDING("HANDING","处理中"),
    OTHER("OTHER","其他"),
    FAIL("FAIL","失败");

    private String code;
    private String msg;

    RebirthStatusEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
