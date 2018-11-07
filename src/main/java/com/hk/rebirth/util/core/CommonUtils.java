package com.hk.rebirth.util.core;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongfei.xu
 * @Description: Util 类
 * @Date: 2018/7/13 14:36
 */
@Slf4j
public class CommonUtils {


    /**
     *  是否包含中文字符
     * @param c
     * @return boolean
     */
    public static boolean isChinese(char c){
        // 中文编码正则
        String regex = "[\\u4e00-\\u9fa5]";
        return String.valueOf(c).matches(regex);
    }

    public static void main(String[] args){
        Map<String, String> map = new HashMap();
//        Iterator;
        for(String key : map.keySet()){
            log.info(key);
            map.get(key);
        }
        for(Map.Entry<String, String> entry: map.entrySet()){
            entry.getKey();
            entry.getValue();
        }

        while (true){

        }
    }
}
