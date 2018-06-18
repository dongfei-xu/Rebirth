package com.hk.rebirth.util;

import java.util.Optional;

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
        /**
         *  返回int值2进制 中 指定值1的个数
         */
//        String m = new String("hello");
//        String n = new String("hello");
        StringBuilder s = new StringBuilder();

        System.out.println(Integer.bitCount(7));
        Integer i = 100000;
        System.out.println(i.byteValue());

        Boolean flag = new Boolean("s");
        System.out.println((int)(char)(byte)-1);
//        Arrays;
//        ArrayList;
        Optional<String> name = Optional.of("Sanaulla");
        Optional<String> upperName = name.map((key) -> key.toUpperCase());
        System.out.println(upperName.orElse("No value found"));
        System.out.print(flag);
    }

}
