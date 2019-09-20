package com.sf.wdx.singleton;

/**
 * 描述：单例懒汉式
 * 		问题：可能出现并发问题，多个线程同时进入代码1，判断都为null，同时执行代码2，导致出现两个不同对象。
 * @author 80002888
 * @date   2019年3月12日
 */
public class LazySingleton {

	private static LazySingleton singleton;
	
	private LazySingleton() {
	}

	public static LazySingleton getInstance(){
		if (singleton == null) {						// 1
			singleton = new LazySingleton();			// 2
		}
		return singleton;
	}
	
}
