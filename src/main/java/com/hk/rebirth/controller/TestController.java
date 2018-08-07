package com.hk.rebirth.controller;

import com.alibaba.fastjson.JSON;
import com.hk.rebirth.core.Show;
import com.hk.rebirth.pojo.UserInfoPo;
import com.hk.rebirth.redis.core.ISequence;
import com.hk.rebirth.service.IUserInfoService;
import com.hk.rebirth.util.RedisUtil;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private ISequence iSequence;

    @Autowired
    private Show show;


    @RequestMapping(value = {"/init"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public List getAllUsers(){
        List list =  userInfoService.select();
        return list;
    }

    @RequestMapping(value = {"/test"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
//    @ResponseBody
    public ModelAndView test(){
        List list =  userInfoService.select();
        return new ModelAndView("test");
    }

    @RequestMapping(value = {"/insert"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String insert(){
        UserInfoPo userInfoPo = new UserInfoPo();
        userInfoPo.setUserName("事物测试");
        UserInfoPo userInfoPo1 = new UserInfoPo();
        userInfoPo1.setUserName("事物测试1");
        int m = userInfoService.insert(userInfoPo1);
        int i = userInfoService.insertSelective(userInfoPo);
        return "i = "+ i +",m = " + m;
    }

    @RequestMapping(value = {"/str"},method = RequestMethod.GET)
//    @ResponseBody
    public String init(Model model, Object obj){
//        return new ModelAndView("index");

        show.test();
        if(true) {
            model.addAttribute("model",obj);
            return "redirect:/test/ok";
        }else{
            return "";
        }
    }

    @RequestMapping(value = {"/ok"},method = RequestMethod.GET)
    public ModelAndView ok(){
//        System.out.println(request);
//        System.out.println(test);
        return new ModelAndView("ok");
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

    @RequestMapping(value = "/sequence",method = RequestMethod.GET)
    @ResponseBody
    public String sequence(){
        return iSequence.universalSequence();
    }

}
