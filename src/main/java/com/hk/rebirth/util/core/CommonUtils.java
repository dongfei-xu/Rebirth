package com.hk.rebirth.util.core;

/**
 * @Author:dongfei.xu
 * @Description: Util 类
 * @Date: 2018/7/13 14:36
 */
public class CommonUtils {

    /**
     *  是否包含中文字符
     * @param char c
     * @return boolean
     */
    public static boolean isChinese(char c){
        // 中文编码正则
        String regex = "[\\u4e00-\\u9fa5]";
        return String.valueOf(c).matches(regex);
    }
}
