package com.hk.rebirth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:dongfei.xu
 * @Desc: 自定义注解 解密类
 * @Date: 2018/8/27 15:24
 */

/**
 *  @Retention– 定义该注解的生命周期 english: 保留
 *      RetentionPolicy.CLASS : 在类加载的时候丢弃。在字节码文件的处理中有用。注解默认使用这种方式
 *      RetentionPolicy.RUNTIME : 始终不会丢弃，运行期也保留该注解,因此可以使用反射机制读取该注解的信息。
 *  @Target– 表示该注解用于什么地方。默认值为任何元素
 *      ElementType.CONSTRUCTOR:用于描述构造器
 *      ElementType.FIELD:成员变量、对象、属性（包括enum实例）
 *      ElementType.LOCAL_VARIABLE:用于描述局部变量
 *      ElementType.METHOD:用于描述方法
 */

// 自定义注解 用于字段校验 方法简介 字段加解密
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface Decrypt {
    String decryptType() default "MD5";     // 加解密方式 MD5 3DS SHA-256
    String decryptMsg() default "";
}
