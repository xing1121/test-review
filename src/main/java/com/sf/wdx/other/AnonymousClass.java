package com.sf.wdx.other;

import com.sf.wdx.domain.Person;

public class AnonymousClass {  
    
	
    public void run(){
    	
    	Person p = new Person();
    	
    	new Thread(()->{
    		
    		p.setName("zhangsan");		//编译通过
    		System.out.println(p);
    		
    	}).start();
     
    	
	    @SuppressWarnings("unused")
		class InnerClass{
	    	
	    	@Override
	    	public String toString(){
//	    		p = new Person();		//编译失败
	    		return p.toString();
	    	}
	    	
	    }
    }
    
    
}  