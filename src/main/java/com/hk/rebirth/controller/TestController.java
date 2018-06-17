package com.hk.rebirth.controller;

import com.hk.rebirth.service.IUserInfoService;
import com.hk.rebirth.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author:dongfei.xu
 * @Date: 2018/6/14 16:03
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CacheManager cacheManager;


    @RequestMapping(value = {"/init"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public List getAllUsers(){
        List list =  userInfoService.select();
        return list;
    }

    @RequestMapping(value = {"/str"},method = RequestMethod.GET)
//    @ResponseBody
    public ModelAndView init(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    @ResponseBody
    public String get(){
        redisUtil.get("key");
        return "ok";
    }

    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    @ResponseBody
    public String post(){
        redisUtil.set("key","[1,2,3,4,5]");
        return "ok";
    }

    @RequestMapping(value = "/redis",method = RequestMethod.PUT)
    @ResponseBody
    public String put(){
        redisUtil.exists("key");
        return "ok";
    }

    @RequestMapping(value = "/redis",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(){
        redisUtil.remove("key");
        return "ok";
    }

}
