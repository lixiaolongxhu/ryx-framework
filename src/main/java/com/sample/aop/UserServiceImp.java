package com.sample.aop;

//实现UserService接口  
public class UserServiceImp implements UserService{
	public void printUser(String user) {  
        System.out.println("printUser user:" + user);// 显示user  
    }

}
