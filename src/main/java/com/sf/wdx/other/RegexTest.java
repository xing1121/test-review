package com.sf.wdx.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 描述：正则表达式
 
下面代码用到的一些符号的简介：
		.		匹配除换行符 \n 之外的任何单字符。要匹配 . ，请使用 \. 。
		*		匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。
		+		匹配前面的子表达式一次或多次。例如，'zo+' 能匹配 "zo" 以及 "zoo"，但不能匹配 "z"。+ 等价于 {1,}。
		?		匹配前面的子表达式零次或一次。例如，"do(es)?" 可以匹配 "do" 、 "does" 中的 "does" 、 "doxy" 中的 "do" 。? 等价于 {0,1}。
		()		标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。要匹配这些字符，请使用 \( 和 \)。
		{n,m}	m 和 n 均为非负整数，其中n <= m。最少匹配 n 次且最多匹配 m 次。例如，"o{1,3}" 将匹配 "fooooood" 中的前三个 o。'o{0,1}' 等价于 'o?'。请注意在逗号和两个数之间不能有空格。
		[xyz]	字符集合。匹配所包含的任意一个字符。例如， '[abc]' 可以匹配 "plain" 中的 'a'。
		[a-z]	字符范围。匹配指定范围内的任意字符。例如，'[a-z]' 可以匹配 'a' 到 'z' 范围内的任意小写字母字符。
 
三种匹配模式：
	greedy字符串可回溯
	lazy模糊串可回溯
	possessive永不回溯
	
Java正则表达式使用的引擎实现是 NFA 自动机，这种正则表达式引擎在进行字符匹配时会发生回溯（backtracking），导致CPU飙高。

 *
 * @author 80002888
 * @date   2019年6月5日
 */
public class RegexTest {
	
	@Test
	public void test3() {
		String text = "abc5ef6";
		
		/**
			.+[0-9]验证abc5ef6
			贪婪--字符串回溯，.+默认读取整个字符串进行匹配，直到模糊串走完一遍。
			匹配器被强制要求第一次尝试匹配时读入整个输入串，如果第一次尝试匹配失败，则从后往前逐个字符地回退并尝试再次匹配，直到匹配成功或没有字符可回退。
				.读取abc5ef6
				.匹配a，字符串前进
				.匹配b，字符串前进
				.匹配c，字符串前进
				.匹配5，字符串前进
				.匹配e，字符串前进
				.匹配f，字符串前进
				.匹配6，字符串到达结尾，模糊串前进，字符串回溯
				[0-9]读取6
				[0-9]匹配6，匹配成功。
				匹配成功一次。
		 */
		Matcher mGreddy = Pattern.compile(".+[0-9]").matcher(text);
	    while (mGreddy.find()) { 
	        System.out.println("matched form " + mGreddy.start() + " to " + mGreddy.end());  
	    }
	    System.out.println(mGreddy.matches() + "\n");
	    
	    /**
			.+?[0-9]验证abc5ef6
			懒惰--模糊串回溯，.+默认读取最少的字符串进行匹配也就是1个，直到字符串走完一遍。
	     	它从输入串的首(字符)位置开始，在一次尝试匹配查找中只勉强地读一个字符，直到尝试完整个字符串。
	     		.读取a
	     		.匹配a，模糊串前进，字符串前进
	     		[0-9]读取b
	     		[0-9]不匹配b。模糊串回溯
	     		.读取b
	     		.匹配b，模糊串前进，字符串前进
	     		[0-9]读取c
	     		[0-9]不匹配c。模糊串回溯
	     		.读取c
	     		.匹配c，模糊串前进，字符串前进
	     		[0-9]读取5
	     		[0-9]匹配5，匹配成功。
	     		[0-9]读取e
	     		[0-9]不匹配e。模糊串回溯
	     		.读取f
	     		.匹配f，模糊串前进，字符串前进
	     		[0-9]读取6
	     		[0-9]匹配6，匹配成功。
	     		匹配成功两次。
	     */
		Matcher mLazy = Pattern.compile(".+?[0-9]").matcher(text);
	    while (mLazy.find()) { 
	        System.out.println("matched form " + mLazy.start() + " to " + mLazy.end());  
	    } 
	    System.out.println(mLazy.matches() + "\n");
	    
	    /**
	      	.++[0-9]验证abc5ef6
	    	占有--都不会回溯，匹配失败
	    	总是读入整个输入串，尝试一次(仅且一次)，从不回退。
	    		.读取abc5ef6
				.匹配a，字符串前进
				.匹配b，字符串前进
				.匹配c，字符串前进
				.匹配5，字符串前进
				.匹配e，字符串前进
				.匹配f，字符串前进
				.匹配6，字符串到达结尾，匹配失败。
	     */
		Matcher mPossessive = Pattern.compile(".++[0-9]").matcher(text);
	    while (mPossessive.find()) { 
	        System.out.println("matched form " + mPossessive.start() + " to " + mPossessive.end());  
	    } 
	    System.out.println(mPossessive.matches() + "\n");
	}  
	
	@Test
	public void test2() {  
		String text = "xfooxxxxxxfoo";
		
		// 贪婪
		Matcher mGreddy = Pattern.compile(".*foo").matcher(text);
	    while (mGreddy.find()) { 
	        System.out.println("matched form " + mGreddy.start() + " to " + mGreddy.end());  
	    } 
	    System.out.println(mGreddy.matches() + "\n");
	    
	    // 懒惰
		Matcher mLazy = Pattern.compile(".*?foo").matcher(text);
	    while (mLazy.find()) { 
	        System.out.println("matched form " + mLazy.start() + " to " + mLazy.end());  
	    } 
	    System.out.println(mLazy.matches() + "\n");
	    
	    // 占有
		Matcher mPossessive = Pattern.compile(".*+foo").matcher(text);
	    while (mPossessive.find()) { 
	        System.out.println("matched form " + mPossessive.start() + " to " + mPossessive.end());  
	    } 
	    System.out.println(mPossessive.matches() + "\n");
	}  
	
	@Test
	public void test1() {
		String text = "abbc";
		
		// 贪婪
		Matcher mGreddy = Pattern.compile("ab{1,3}c").matcher(text);
	    while (mGreddy.find()) { 
	        System.out.println("matched form " + mGreddy.start() + " to " + mGreddy.end());  
	    } 
	    System.out.println(mGreddy.matches() + "\n");
	    
	    // 懒惰
		Matcher mLazy = Pattern.compile("ab{1,3}?c").matcher(text);
	    while (mLazy.find()) { 
	        System.out.println("matched form " + mLazy.start() + " to " + mLazy.end());  
	    } 
	    System.out.println(mLazy.matches() + "\n");
	    
	    // 占有
		Matcher mPossessive = Pattern.compile("ab{1,3}+c").matcher(text);
	    while (mPossessive.find()) { 
	        System.out.println("matched form " + mPossessive.start() + " to " + mPossessive.end());  
	    } 
	    System.out.println(mPossessive.matches() + "\n");
	}  
	
}
