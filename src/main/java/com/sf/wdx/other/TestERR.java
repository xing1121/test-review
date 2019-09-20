package com.sf.wdx.other;

/**
 * 描述：测试异常堆栈信息丢失的情况
 * 	OmitStackTraceInFastThrow这个JVM参数的含义是，当JVM检测到程序在重复抛一个异常，在执行若干次后会将异常吞掉，
 * 	这里的若干次在jdk1.7测得是20707。即执行20707次后，stackTrace 长度会为0
 * 		JDK1.6开始，默认-XX:+OmitStackTraceInFastThrow，是开启异常堆栈优化了的。
 * 		要关闭优化，则设置-XX:-OmitStackTraceInFastThrow，则异常堆栈会完全打印。
 * @author 80002888
 * @date   2019年3月11日
 */
public class TestERR {
 	private static String x = null;
 	
 	public static void main(String[] args) { 
    	for (int i = 0; i < 1000000; i++) {
    		try {
    			getNPE(i);
    		} catch (Exception e) {
    			int lth = e.getStackTrace().length;
    			System.out.println("length："+lth);
    			e.printStackTrace();
    			if(lth == 0){
    				return;
    			}
    		}
			
		}
    } 
    
    private static void getNPE(int i){
    	System.out.println("当前执行次数为：" + i);
        System.out.println(x.toString());
    }
    
}
