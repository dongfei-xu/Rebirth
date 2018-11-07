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

//	-server  Server 模式才能进行逃逸分析
//-Xmx10m	 堆最大内存10m
//-Xms10m    堆初始空间10m
//-XX:+PrintGC	打印GC日志
//-XX:+DoEscapeAnalysis		开启逃逸分析
//-XX:-UseTLAB	关闭TLAB
//-XX:+EliminateAllocations 开启标量替换

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
		String s;
		System.out.println(System.currentTimeMillis());
		for(int i=0; i< 100; i++){
			s = new String("111");
		}
		System.out.println(System.currentTimeMillis());

		System.out.println(System.currentTimeMillis());
//		System;
	}

}
