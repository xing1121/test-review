package com.sf.wdx.review1;

import java.util.Arrays;

public class PassValue {
	public static void main(String[] args) {
		int i = 1;
		String str = "hello";
		Integer num = 200;
		int[] arr = {1,2,3,4,5};
		MyData my = new MyData(10);
		
		change(i,str,num,arr,my);
		
		// 1 hello 200 {2,2,3,4,5} 11
		System.out.println("i = " + i);
		System.out.println("str = " + str);
		System.out.println("num = " + num);
		System.out.println("arr = " + Arrays.toString(arr));
		System.out.println("my.a = " + my.a);
	}
	public static void change(int j, String s, Integer n, int[] a,MyData m){
		j += 1;
		s += "world";
		n += 1;
		a[0] += 1;
		m.a += 1;
	}
}
class MyData{
	int a;

	public MyData(int a) {
		this.a = a;
	}
	
}
