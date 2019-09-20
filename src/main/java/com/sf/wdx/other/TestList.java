package com.sf.wdx.other;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class TestList {
	
	// java.util.ConcurrentModificationException
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("E");
		list.add("C");
		list.add("B");
		list.add("D");
		list.add("G");
		list.add("F");
		// 一个线程遍历
		new Thread(()->{
			for (String s : list) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println(s);
			}
		}).start();
		// 一个线程排序
		Collections.sort(list, (x1, x2)->1);	
	}
	
	@Test
	public void test2(){
		List<String> bigList = new ArrayList<>();
		for (int i = 0; i < 5000000; i++) {
			bigList.add("ABCABCABCABCABCABC"+i);
		}
		
		List<String> smallList = new ArrayList<>();
		for (int i = 2400000; i < 5000000; i++) {
			smallList.add("ABCABCABCABCABCABC"+i);
		}
		Instant begin = Instant.now();
		
//		bigList.removeAll(smallList);
		
		HashSet<String> bigSet = new HashSet<>(bigList);				// 大集合转set
		HashSet<String> smallSet = new HashSet<>(smallList);			// 小集合转set
		bigSet.removeAll(smallSet);										// 大set中剔除小set
		bigList = new ArrayList<>(bigSet);								// 大set转list
		
		System.out.println(bigList.size());
		Instant end = Instant.now();
		System.out.println("共耗时："+Duration.between(begin, end).toMillis()+"毫秒");
	}
	
	@Test
	public void test1(){
		List<String> datas = new ArrayList<>();
		datas.add("123");
		datas.add("123");
		datas.add("123");
		datas.add("asd");
		datas.add("asd2");
		datas.add("asd123");
		datas.removeIf((x)->x.equals("123"));
		System.out.println(datas);
	}
	
	@Test
	public void test0(){
		List<Object> datas = new ArrayList<>();				//①0x123指向88
		
		datas.add(new Object());
		datas.add(new Object());
		datas.add(new Object());
		datas.add(new Object());
		datas.add(new Object());
		
		fileterObject(datas);									//②实例的id为88，传入引用地址0x123
		
		System.out.println(datas.size());							//⑥datas的引用仍为0x123，依然指向88，88实例的size为5
	}
	
	public void fileterObject(List<Object> datas){		//③传入引用地址0x123的复制品，只在此方法的栈祯有效
		datas = new ArrayList<>();									//④新实例的id为99，本方法的引用地址0x123指向99
		System.out.println(datas.size());							//⑤99实例的size为0，方法结束，栈祯释放
	}
	
}
