package com.hk.rebirth.core.validate;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:dongfei.xu
 * @Date: 2018/8/16 16:48
 */
@Service
public class FormatValidate {
     static class ValidateVo{
        private String key;
        private String value;
        private int length;

        ValidateVo(String key, String value, int length){
            this.key = key;
            this.value = value;
            this.length = length;
        }
        ValidateVo(String key, String value){
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getLength() {
            return length;
        }
    }


    public static void lengthValidate(List<ValidateVo> list){
        for(ValidateVo vo:list){
            if(vo.getValue().length() > vo.getLength()){
//                throw new BizException(ResponseCode.PARAM_ERROR, new StringBuilder("必填参数").append(vo.getKey()).append("长度过长").toString());
            }
        }
    }
    public static void lengthValidate(ValidateVo vo){
        if(vo.getValue().length() > vo.getLength()){
//            throw new BizException(ResponseCode.PARAM_ERROR, new StringBuilder("必填参数").append(vo.getKey()).append("长度过长").toString());
        }
    }

    public static void formatValidate(List<ValidateVo> list){
        String regEx="^[a-zA-Z0-9]+$";
        Pattern p = Pattern.compile(regEx);
        for(ValidateVo vo:list){
            Matcher m = p.matcher(vo.getValue());
            if(!m.matches()){
//                throw new BizException(ResponseCode.PARAM_ERROR, new StringBuilder("必填参数").append(vo.getKey()).append("含有特殊字符").toString());
            }
        }
    }

    public static void formatValidate(ValidateVo vo) {
        String regEx = "^[a-zA-Z0-9]+$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(vo.getValue());
        if (!m.matches()) {
//            throw new BizException(ResponseCode.PARAM_ERROR, new StringBuilder("必填参数").append(vo.getKey()).append("含有特殊字符").toString());
        }
    }

    public static ValidateVo getFormatVoInstance(String key, String value){
        ValidateVo vo = new ValidateVo(key, value);
        return vo;
    }

    public static ValidateVo getLengthVoInstance(String key, String value, int length){
        ValidateVo vo = new ValidateVo(key, value, length);
        return vo;
    }
}
