package com.hk.rebirth.util.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * @Author:dongfei.xu
 * @Description:
 * @Date: 2018/9/9 11:07
 */
public class TemplateConfig {
    private final static Logger logger = LoggerFactory.getLogger(TemplateConfig.class);

    private static Map<String, String> template = new HashMap<>();

    static {
        InputStream inputStream = null;
        try{
            InputStream resource = TemplateConfig.class.getResourceAsStream("");

            Properties prop = new Properties();
            prop.load(resource);

            Set<Object> keySet = prop.keySet();
            for (Object keyObj:
                    keySet) {
                String key = keyObj.toString();
                template.put(key, prop.getProperty(key));
            }
        } catch (Exception e){

        } finally {
            if(null == inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Map<String, String> getTemplateConfig(){
        return template;
    }
}
