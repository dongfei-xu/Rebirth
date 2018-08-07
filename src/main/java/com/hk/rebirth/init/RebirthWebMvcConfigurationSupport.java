package com.hk.rebirth.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:dongfei.xu
 * @Description:
 * @Date: 2018/8/7 12:37
 */
@Configuration
public class RebirthWebMvcConfigurationSupport extends WebMvcConfigurerAdapter  {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("/js/**")
                .addResourceLocations("WEB-INF/js/");
        super.addResourceHandlers(registry);
    }

}
