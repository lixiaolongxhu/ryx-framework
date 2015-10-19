package com.sample.proxy;

/**动态代理测试
 * @author lixiaolong
 * @version datetime：2015年10月16日  上午9:50:06
 */
public class DynamicProxy {

	public static void main(String[] args) throws Throwable  
    {  
        BusinessFooImpl bfoo = new BusinessFooImpl();  
        BusinessFoo bf = (BusinessFoo)BusinessImplProxy.factory(bfoo);  
        bf.foo();  
        System.out.println();  
          
        BusinessBarImpl bbar = new BusinessBarImpl();  
        BusinessBar bb = (BusinessBar)BusinessImplProxy.factory(bbar);  
        String message = bb.bar("Hello,World");  
        System.out.println(message);  
    }

}
