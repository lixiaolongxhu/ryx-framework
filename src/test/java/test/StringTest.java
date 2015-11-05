package test;

import org.apache.log4j.chainsaw.Main;
import org.springframework.scheduling.annotation.Async;

 
public class StringTest {
	public static void main(String[] args) {
		String str1="a"+"b"+"c";
		
		String str2="d"+"f";
		
		String str3=str1+str2;
		
		String str4=new String("hello");
		
		String str5=str4+new String("word");
		
		System.out.println(System.nanoTime());;
		System.out.println(System.currentTimeMillis());
	}
}
