package com.sf.wdx.other;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 描述：测试异常
 * @author 80002888
 * @date   2018年9月27日
 */
public class TestException {
	
    public static void main(String[] args) {
		doMethod();
	}
    
    private static void doMethod(){
    	doMyMethod();
    }
    
    private static void doMyMethod(){
    	myMethod();
    }
    
    private static void myMethod(){
		try {
			throw new RuntimeException("hahahah");
		} catch (Exception e) {
			System.out.println(getPrintStackTrace(e));
		}
    }
    
    /**
     * 获取异常堆栈信息的字符串
     *	@ReturnType	String 
     *	@Date	2018年3月20日	下午3:20:38
     *  @Param  @param e
     *  @Param  @return
     */
    public static String getPrintStackTrace(Throwable e) {
    	StringWriter sw = new StringWriter();
    	PrintWriter pw = new PrintWriter(sw, true);
    	e.printStackTrace(pw);
    	return sw.getBuffer().toString();
    }
    
}