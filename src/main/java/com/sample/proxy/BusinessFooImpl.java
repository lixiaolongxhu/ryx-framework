package com.sample.proxy;

//真实角色：真正实现业务逻辑方法  
public class BusinessFooImpl implements BusinessFoo  
{  
  public void foo()  
  {  
      System.out.println("BusinessFooImpl.foo()");  
  }  
}
