package com.sf.wdx.other;

import org.junit.Test;

/**
 * 描述：测试异常
 * @author 80002888
 * @date   2019年6月17日
 */
public class TestException2 {
	
	@Test
	public void test1(){
		try {
			method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void method1() throws NullPointerException {
		System.out.println(1/0);
	}
	
}
