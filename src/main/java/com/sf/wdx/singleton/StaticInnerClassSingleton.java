package com.sf.wdx.singleton;

/**
 * 描述：静态内部类单例
 * 		加载一个类时，其内部类不会同时被加载。
 * 		一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生一次。 
 * 		由于在调用 StaticSingleton.getInstance() 的时候，才会对单例进行初始化，而且通过反射，是不能从外部类获取内部类的属性的。
 * 		由于静态内部类的特性，只有在其被第一次引用的时候才会被加载，所以可以保证其线程安全性。 
 * @author 80002888
 * @date   2019年3月12日
 */
public class StaticInnerClassSingleton {

	private StaticInnerClassSingleton() {
	}

	private static class StaticInnerClassSingletonHolder {
		private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
	}
	
	public StaticInnerClassSingleton getInstance(){
		return StaticInnerClassSingletonHolder.singleton;
	}
	
}
