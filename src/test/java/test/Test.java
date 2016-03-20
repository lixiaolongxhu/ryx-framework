package test;

import java.util.*;

public class Test {
	public int i=0;
	public String s="";
	public Test t;
	
	public void check(int i , String s,Test t){
		System.out.println("test.i="+t.i);
		this.i=i;
		System.out.println("test.i="+t.i);
		this.s=s;
		this.t=t;
		i=-2;
		s="hello";
		System.out.println("this.i="+this.i);
		System.out.println("this.s="+this.s);
		System.out.println("this.t="+this.t);
		System.out.println("t="+t);
		System.out.println("t.i="+t.i);
		System.out.println("t.s="+t.s);
		System.out.println("this.t.i"+this.t.i);
		System.out.println("this.t.s"+this.t.s);
	}
	
	
	
	public static void  getTitle(String title,int len,String dot){
		String chinese = "[\u4e00-\u9fa5]";
		int valueLength=0;
		String s="";
		for (int i = 0; i < title.length(); i++) {
			   String temp = title.substring(i, i + 1);
			   if (temp.matches(chinese)) {
			    valueLength += 2;
			   } else {
			    valueLength += 1;
			   }
			   
			   if(valueLength<=len){
				     s=s+temp;
			   }else{
				   s=s+dot;
				   break;
			   }
		}
		
		System.out.println("输出字符串处理结果： "+s);
	}
	
	public void print() {
		
		try {
			
			System.out.println("try  begin");
			if(true){
				System.out.println("进入一次跑出");
				throw  new Exception();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch");
		}finally{
			System.out.println("finaally");
		}
	}
	
	
	public static void main(String args[]) {
	Test  test=new Test();
	System.out.println("Test.main()");
	test.print();
	System.out.println("测试结束");
	
	
	System.out.println("-------------------------------------");
	test.i=-1;
	test.s="word";
	int i=-3;
	String s="world--3";
	test.check(i, s, test);
	
	System.out.println("-------------------------------------");
	Test.getTitle("java编程", 3, "...");
	Test.getTitle("java编程", 4, "...");
	Test.getTitle("java编程", 5, "...");
	Test.getTitle("java编程", 6, "...");
	Test.getTitle("java编程", 7, "...");
	Test.getTitle("java编程题", 8, "...");
	}
}