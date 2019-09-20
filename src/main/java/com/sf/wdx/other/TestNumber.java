package com.sf.wdx.other;

import org.junit.Test;

public class TestNumber {
	
	// 4.346100000003304%
	@Test
	public void saveM(){
		
		for (double d = 1.0; d < 10.0; d = d + 0.0001) {
			
			double base = 0.0;
			double yearRate = d / 100;
			double monthRate = yearRate / 12;
			double ext = 200.0;
			
			int size = 360;
			for (int i = 1; i <= size; i++) {
				base = base * (1 + monthRate);
				base = base + ext;
			}
			System.out.println(base);
			
			
			double ext2 = 516.63;
			base = base - 64959.62;
			System.out.println(base);
			
			int size2 = 240;
			for (int j = 1; j <= size2; j++) {
				base = base * (1 + monthRate);
				base = base - ext2;
			}
			System.out.println(base);
			
			if (base <= 5 && base >= -5) {
				System.out.println("-------------------" + d);
				System.out.println("-------------------" + base);
				return;
			}
			
		}
		
	}
	
	@Test
	public void getM(){

	}
	
	@Test
	public void exercise(){
		for (int i = 1; i <= 100; i++) {
			switch (i) {
			case 1:
				System.out.println(1111);
				break;
			case 2:
				System.out.println(2222);
				break;
			case 3:
				System.out.println(3333);
				break;
			default:
				System.out.println("----");
				break;
			}
		}
	}
	
	@Test
	public void testNum05(){
		Math.random(); // [0, 1)
	}
	
	@Test
	public void testNum04(){
		lable01 : for (int j = 0; j < 10; j++) {
			System.out.println(j);
			for (int i = 0; i < 10; i++) {
				if (i == 8) {
//					continue lable01;
					break lable01;
				}
				System.out.println(i);
			}
		}
	}
	
	@Test
	public void testNum03(){
		int a = Integer.MAX_VALUE;
		int b = a * 4;
		
		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void testNum02(){
//		long l = (long)1.22;
		
		int n1 = 0x14;
		int n2 = 0b10100;
		int n3 = 024;
		int n4 = 20;
		
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
	}
	
	@Test
	public void testNum01(){
		int i1 = 8;
		int i2 = 12;
		
		int s1 = i1 & i2;
		int s2 = i1 | i2;
		int s3 = ~i1;
		int s4 = i1^i2;
		int s5 = i1 << 2;
		int s6 = i1 >> 2;
		
		System.out.println(s1); // 8
		System.out.println(s2); // 12
		System.out.println(s3); // -9
		System.out.println(s4); // 4
		System.out.println(s5); // 32
		System.out.println(s6); // 2
	}
	
}
