package com.sf.wdx.other;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

public class TestIP {

	@Test
	public void test1(){
		// 获得本机的IP地址
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
		} 
		// 获取用户名
		System.out.println(System.getProperty("user.name"));
		
		// 获取系统的环境变量
		Map<String, String> env = System.getenv();
		Set<Entry<String, String>> entrySet = env.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
		
		System.out.println("-------------------------------------------");
		
		// 获取JVM的环境变量
		Properties properties = System.getProperties();
		Set<Entry<Object, Object>> entrySet2 = properties.entrySet();
		for (Entry<Object, Object> entry2 : entrySet2) {
			System.out.println(entry2.getKey() + "--" + entry2.getValue());
		}
	}
	
}
