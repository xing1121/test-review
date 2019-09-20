package com.sf.wdx.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 描述：测试读取系统错误日志文件
 * @author 80002888
 * @date   2018年9月27日
 */
public class TestIO {

	@Test
	public void testHa(){
		try {
			final String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
			File file = new File("/app/logs/error/");
			boolean b = file.exists();
			if (!b) {
				return;
			}
			File[] files = file.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().startsWith("stms_server_"+dateStr+".") && pathname.getName().endsWith(".log")) {
						return true;
					}
					return false;
				}
			});
			
			for (File f : files) {
				System.out.println(f.getName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIO(){
		int count = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		StringBuffer message = null;
		try {
			final String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
			message = new StringBuffer();
			fis = new FileInputStream(new File("/app/logs/error/stms_server_"+dateStr+".0.log"));
			
			byte[] bs = new byte[1024];
			
			System.out.println(bs.length);
			
			while (fis.read(bs) != -1 ) {
				message = message.append(new String(bs));
				if (message.length() > 8*1024) {
					// 大于8K输出
					fos = new FileOutputStream(new File("/user/80002888/桌面/test/stms_server_20180125.0-"+count+".log"));
					fos.write(message.toString().getBytes());
					System.out.println(message);
					message = new StringBuffer();;
					count++;
				}
			}
			if (message.toString()!=null && !message.toString().equals("")) {
				fos = new FileOutputStream(new File("/user/80002888/桌面/test/stms_server_20180125.0-"+count+".log"));
				fos.write(message.toString().getBytes());
			}
			fos.close();
			fis.close();
			
			System.out.println("执行完毕！");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
