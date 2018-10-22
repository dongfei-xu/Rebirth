package com.hk.rebirth;

import com.hk.rebirth.pojo.UserInfoPo;
import com.hk.rebirth.service.IUserInfoService;
import lombok.extern.slf4j.XSlf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
public class RebirthApplicationTests {

//	@Autowired
//	private IUserInfoService userInfoService;

	@Test
	public void contextLoads() {
		System.out.print("SUCC");
	}

//	@Test
//	@Transactional
//	public void insert() {
//		UserInfoPo userInfoPo = new UserInfoPo();
//		userInfoPo.setUserName("事物测试");
//		userInfoService.insertSelective(userInfoPo);
//
//		throw new NullPointerException();
//	}

	@Test
	public void throwable() {
		try{
			Throwable throwable = new Throwable();
			throw new Exception("Error", throwable);
		} catch (Exception e) {
//			System.out.println(e.fillInStackTrace());
//			System.out.println(e.getCause());
//			System.out.println(e.getLocalizedMessage());
//			System.out.println(e.getSuppressed());
		}


//		System.out.println("throwable:" + throwable.fillInStackTrace());
//		System.out.println(throwable.getCause());
//		System.out.println(throwable.getLocalizedMessage());
//		System.out.println(throwable.getStackTrace());
//		System.out.println(throwable.getSuppressed());
	}

	@Test
	public void system(){
//		System;
	}

}
