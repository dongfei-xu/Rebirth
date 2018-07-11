package com.hk.rebirth.util.common.signleton;

/**
 * @Author:dongfei.xu
 * @Description: 懒汉模式
 * @Date: 2018/7/11 15:14
 */
public class Signleton {
    private static Signleton instance;

    private Signleton(){};

    public static Signleton getInstance() {
        if(null == instance){
            instance = new Signleton();
        }
        return instance;
    }

    // 双重锁
    private volatile static  Signleton instance1;

    public static Signleton getInstance1(){
        if(null == instance1){
            synchronized(Signleton.class){
                if(null == instance1){
                    instance1 = new Signleton();
                }
            }
        }
        return instance1;
    }
}
