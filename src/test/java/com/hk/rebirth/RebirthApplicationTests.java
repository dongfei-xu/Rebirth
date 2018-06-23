package com.hk.rebirth;

import com.hk.rebirth.util.enums.EnumUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class RebirthApplicationTests {

	@Test
	public void contextLoads() {
		System.out.print("SUCC");
	}

	@Test
	public void getEnumCode() {
		String code = "FAIL";
		System.out.println(EnumUtils.isContains(code));
		System.out.println("SUCC");
	}

}
