package com.hk.rebirth.annotation.manager;

import com.alibaba.fastjson.JSON;
import com.hk.rebirth.annotation.Decrypt;
import com.hk.rebirth.util.exception.RebirthException;
import lombok.extern.slf4j.XSlf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Author:dongfei.xu
 * @Description:
 * @Date: 2018/8/27 18:33
 */
public class AnnotationManager {

    private final static Logger logger = LoggerFactory.getLogger(AnnotationManager.class);

    /*
        获取对象字段
     */
    private static List<Field> reflectFiled(Object obj){
        List list = new ArrayList();
        Class<?> clazz = obj.getClass();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field != null && StringUtils.isNotBlank(field.getName()) && !field.getName().startsWith("this$")){//主要过滤内部类中的this
                list.add(field);
            }
        }
        StringUtils.leftPad("111", 5, "0");
        return list;
    }

    /**
     * 加密处理
     * @param obj
     */
    public static void decrypt(Object obj){
        List<Field> fields = AnnotationManager.reflectFiled(obj);
        for(Field key:fields){
            Class<?> fieldClazz = key.getType();
            if(fieldClazz != null){
                String getMethodStr = "get" + key.getName().substring(0, 1).toUpperCase() + key.getName().substring(1, key.getName().length());
                Object beanValue = AnnotationManager.getBeanValue(obj, getMethodStr);
                if(null == beanValue){
                    continue;
                }

                if(basicDataHandle(fieldClazz)){
                    Decrypt decryptType = key.getAnnotation(Decrypt.class);
                    if(null == decryptType){
                        continue;
                    }else if(StringUtils.equals(decryptType.Type(), "MD5")){
                        if(beanValue instanceof String && StringUtils.isNotBlank( (String) beanValue)){
                            // TODO
                            // 处理逻辑
                            String setMethodStr = "set" + key.getName().substring(0, 1).toUpperCase() + key.getName().substring(1, key.getName().length());
                            AnnotationManager.setBeanValue(obj, setMethodStr, beanValue);
                        }

                    }else if(StringUtils.equals(decryptType.Type(), "3DS")){
//System.exit(1);
                    }else if(StringUtils.equals(decryptType.Type(), "SHA-256")){

                    }else{
                        logger.error("不存在的加密类型");
                        throw new RebirthException();
                    }
                }else if (fieldClazz.isAssignableFrom(List.class)){
                    List list= (List) beanValue;
                    if (list == null || list.size() < 0){
                        return ;
                    }else{
                        for (Object o:list){
                            decrypt(o);
                        }
                    }
                }else if (fieldClazz.isAssignableFrom(Map.class)){
                    Map<String,Object> map= (Map) beanValue;
                    if (map == null || map.isEmpty()){
                        return ;
                    }else{
                        for (String str : map.keySet()){
                            decrypt(map.get(str));
                        }
                    }
                }else if (fieldClazz.isAssignableFrom(Set.class)){
                    Set set= (Set) beanValue;
                    if (set == null || set.isEmpty()){
                        return ;
                    }else {
                        for (Object o:set){
                            decrypt(o);
                        }
                    }
                }else{
                    logger.error("不存在的类型");
                    throw new RebirthException();
                }
            }
        }
    }

    /**
     *  获取反射对象成员变量值信息
     */
    private static Object getBeanValue(Object obj, String method){
        Method method1 = null;
        try {
            method1 = obj.getClass().getMethod(method);
            return  method1.invoke(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            logger.error("不存在的方法; Method：{}, Object:{}",method , JSON.toJSONString(obj));
            throw new RebirthException();
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常;");
            throw new RebirthException();
        }
    };

    /**
     *  赋值反射对象的成员变量信息
     */
    private static Object setBeanValue(Object obj, String method, Object var){
        Method method1 = null;
        try {
            method1 = obj.getClass().getMethod(method, String.class);
            return method1.invoke(obj, var);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RebirthException();
        }catch (Exception e){
            e.printStackTrace();
            throw new RebirthException();
        }
    }

    /**
     * 判断时候是基本数据类型
     * @param fieldClazz
     * @return
     */
    public static boolean basicDataHandle(Class fieldClazz){
        boolean flag=false;
        if (fieldClazz.isAssignableFrom(Byte.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Short.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Integer.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Long.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Float.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Double.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Character.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Boolean.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(String.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Date.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(BigDecimal.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(Timestamp.class)){
            flag=true;
        }else if (fieldClazz.isAssignableFrom(java.sql.Date.class)){
            flag=true;
        }else if (fieldClazz.isPrimitive()){//判断是否为基本类型
            flag=true;
        }
        return flag;
    }
}
