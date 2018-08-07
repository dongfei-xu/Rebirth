package com.hk.rebirth.util;

import com.hk.rebirth.util.core.CommonUtils;

public class Test {

    final static char [] DigitOnes = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    } ;

    public static void main(String[] args){
//        Thread t = new Thread(){public void run(){
//            System.out.print("ping");
//        }};
//        t.run();System.out.print("pong");

//        List<String> list = new ArrayList<>();
//
//        Class<? extends List> aClass = list.getClass();
//        try {
//            Method add = aClass.getMethod("add");
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
        char ch = 'c';
        Character c = new Character(ch);
        String s = String.valueOf(c);
        System.out.print(CommonUtils.isChinese('中'));
//        System.out.print();
    }

    static void pong(){
        System.out.print("pong");
    }


}
