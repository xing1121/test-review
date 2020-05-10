package com.sf.wdx.jol;

import org.openjdk.jol.info.ClassLayout;


/**
 * 
 * 描述：

JOL全称为Java Object Layout，是分析JVM中对象布局的工具

 * @author wdx
 * @time   2020年5月10日
 */
public class JolTest {

	public static void main(String[] args) {
		ObjectA oa = new ObjectA();
		System.out.println(ClassLayout.parseInstance(oa).toPrintable());

		ObjectB ob = new ObjectB();
		System.out.println(ClassLayout.parseInstance(ob).toPrintable());
		
		ObjectC oc = new ObjectC();
		System.out.println(ClassLayout.parseInstance(oc).toPrintable());
		
		ObjectD od = new ObjectD();
		System.out.println(ClassLayout.parseInstance(od).toPrintable());
	}
	
}

class ObjectA {
	
}

class ObjectB {
	private long a;
}

class ObjectC {
	private long a;
	private int b;
}

class ObjectD {
	private long a;
	private int b;
	private int[] c = new int[0];
}

