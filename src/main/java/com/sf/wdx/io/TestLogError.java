package com.sf.wdx.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLogError {

	/**
	 * 扫描今天的异常日志
	 * 
	 * @ReturnType Map<String,String>
	 * @Date 2018年1月27日 下午2:29:18
	 * @Param @return
	 */
	public static void scanTodayErrorLog() {
		try {
			final String dateStr = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()); // 今天日期，如：20180127
			File folder = new File("/app/logs/error/"); // error目录下
			if (!folder.exists()) {
				return;
			}
			File[] files = folder.listFiles((file) -> (file.getName().startsWith("stms_server_" + dateStr + ".")
					&& file.getName().endsWith(".log")));
			if (files.length == 0) {
				return;
			}
			for (File file : files) {
				handleOneFile(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理一个错误日志文件
	 * 
	 * @ReturnType void
	 * @Date 2018年1月27日 下午2:43:15
	 * @Param @param file
	 */
	public static void handleOneFile(File file) {
		FileInputStream fis = null;
		StringBuffer message = null;
		int num = 0;
		try {
			if (file == null) {
				return;
			}
			fis = new FileInputStream(file);
			byte[] bs = new byte[1024];
			while (fis.read(bs) != -1) {
				if (message == null) {
					message = new StringBuffer();
				}
				message = message.append(new String(bs));
				if (message.length() > 8 * 1024) { // 大于8M拆分为新的文件
					sendErrorLogEmail(file.getName() + "-" + num + ".txt", message.toString());
					message = null;
					num++;
				}
			}
			if (message != null && message.length() != 0 && message.toString() != ""
					&& message.toString().length() != 0) {
				sendErrorLogEmail(file.getName() + "-" + num + ".txt", message.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * 发送异常日志邮件
	 * 
	 * @ReturnType void
	 * @Date 2018年1月27日 下午2:28:35
	 * @Param @param contentMap<文件名=文件内容>
	 */
	public static void sendErrorLogEmail(String name, String content) {
		try {
			if (content == null || content.trim().equals("") || name == null || name.trim().equals("")) {
				return;
			}
			//
			FileOutputStream fos = new FileOutputStream(new File("/user/80002888/桌面/test/" + name));
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		scanTodayErrorLog();
		System.out.println("制造成功！");
	}

}
