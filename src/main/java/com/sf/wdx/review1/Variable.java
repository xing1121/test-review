package com.sf.wdx.review1;

@SuppressWarnings({"unused", "static-access"})
public class Variable {
	static int s;//成员变量，类变量
	int i;//成员变量，实例变量
	int j;//成员变量，实例变量
	{
		int i = 1;//非静态代码块中的局部变量 i
		i++;
		j++;
		s++;
	}
	public void test(int j){//形参，局部变量,j
		j++;
		i++;
		s++;
	}
	public static void main(String[] args) {//形参，局部变量，args
		Variable obj1 = new Variable();//局部变量，obj1
		Variable obj2 = new Variable();//局部变量，obj2
		obj1.test(10);
		obj1.test(20);
		obj2.test(30);
		// 2 1 5
		System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
		// 1 1 5
		System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
	}
}

