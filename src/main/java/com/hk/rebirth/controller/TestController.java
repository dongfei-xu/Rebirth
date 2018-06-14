package com.hk.rebirth.controller;

import com.hk.rebirth.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    private TestServiceImpl testServiceImpl;

    @RequestMapping(value = {"/init"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public List getAllUsers(){
        List list =  testServiceImpl.select();
        return list;
    }

    @RequestMapping(value = {"/str"},method = RequestMethod.GET)
//    @ResponseBody
    public ModelAndView init(){
        return new ModelAndView("index");
    }
}
