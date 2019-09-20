package com.sf.wdx.singleton;

/**
 * 描述：单例饿汉式
 * @author 80002888
 * @date   2019年3月12日
 */
public class HungrySingleton {

	private static HungrySingleton singleton = new HungrySingleton();
	
	private HungrySingleton() {
	}

	public static HungrySingleton getInstance(){
		return singleton;
	}
	
}
