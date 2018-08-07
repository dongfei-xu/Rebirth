package com.hk.rebirth.util.common;

/**
 * @Author:dongfei.xu
 * @Description: Default function
 * @Date: 2018/7/18 13:31
 */
@FunctionalInterface
public interface DefaultInterface {

    String test();


    default String init(){
        System.out.print("Interface default function");
        return "OK";
    }

}
