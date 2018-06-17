package com.hk.rebirth.tailgate.code;

public interface ILong {
    /**
     * Native
     * native关键字说明其修饰的方法是一个原生态方法，方法对应的实现不是在当前文件，而是在用其他语言（如C和C++）实现的文件中。
     * Java语言本身不能对操作系统底层进行访问和操作，但是可以通过JNI接口调用其他语言来实现对底层的访问。
     */
    public static final long MIN_VALUE = 0x8000000000000000L;
    public static final long MAX_VALUE = 0x7fffffffffffffffL;

    /**
     *  Class的getPrimitiveClass是一个native方法，在Class.c中有个Java_java_lang_Class_getPrimitiveClass方法与之对应，
     *  所以JVM层面会通过JVM_FindPrimitiveClass函数根据”long”字符串获得jclass，最终到Java层则为Class<Long>。
     */
//    public static final Class<Long>     TYPE = (Class<Long>) Class.getPrimitiveClass("long");

    /**
     *  返回由第二个参数指定的基数的第一个参数的字符串表示形式
     */
//    public static String toString(long i, int radix) {
//        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
//            radix = 10;
//        if (radix == 10)
//            return toString(i);
//        char[] buf = new char[65];
//        int charPos = 64;
//        boolean negative = (i < 0);
//
//        if (!negative) {
//            i = -i;
//        }
//
//        while (i <= -radix) {
//            buf[charPos--] = Integer.digits[(int)(-(i % radix))];
//            i = i / radix;
//        }
//        buf[charPos] = Integer.digits[(int)(-i)];
//
//        if (negative) {
//            buf[--charPos] = '-';
//        }
//
//        return new String(buf, charPos, (65 - charPos));
//    }



//    Long;
}
