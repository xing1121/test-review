package com.sf.wdx.singleton;

/**
 * 描述：双重锁单例懒汉式
 * 		在单例懒汉式的基础上增加代码345
 * 		3的作用是防止并发，
 * 		4的作用是当对象已经初始化后提供方法执行速度（减少没必要的加锁）
 * 		5的作用是利用被volatile关键字修饰的变量禁止指令重排的特性解决DCL失效问题
 * 			DCL失效：有可能代码2处对象创建，但属性还没有初始化，另一个线程就在代码4处返回对象，这时读到的属性是错误的
 * 			代码2做了三个操作：①为对象分配内存空间 ②对象属性初始化 ③引用指向对象内存空间 ④初次访问对象
 * 				②和③有可能出现指令重排序，在单线程的情况下，上诉操作不会出现问题，但多线程的情况下，重排序可能导致读到对象属性异常。
 * 		volatile：
 * 			不具备互斥性（synchronized具备），多个线程可以同时操作变量
 *			不能保证变量的原子性
 * 			Java1.5以前，只能保证对象的内存可见性
 * 			Java1.5之后，具有内存可见性，有序性（被volatile修饰的对象，将禁止该对象上的读写指令重排序）
 * @author 80002888
 * @date   2019年3月12日
 */
public class DCLLazySingleton {

	private volatile static DCLLazySingleton singleton;	// 5
	
	private DCLLazySingleton() {
	}

	public static DCLLazySingleton getInstance(){
		if (singleton != null) {						// 4
			return singleton;
		}
		synchronized (DCLLazySingleton.class) {			// 3
			if (singleton == null) { 					// 1
				singleton = new DCLLazySingleton(); 	// 2
			}
		}
		return singleton;
	}
	
}
