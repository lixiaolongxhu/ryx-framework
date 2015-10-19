package com.sample.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestInterceptor {

	 public static void main(String[] args) {  
	        ApplicationContext ctx = new FileSystemXmlApplicationContext(  
	                "classpath:applicationContext.xml");  
//	        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");      
	          
	        UserService us = (UserService) ctx.getBean("userService");  
	        us.printUser("shawn");  
	  
	    }

}
