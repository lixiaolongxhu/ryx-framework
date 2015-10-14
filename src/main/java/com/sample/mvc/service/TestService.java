package com.sample.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDaoImp;
import com.framework.core.exception.BizException;
import com.sample.mvc.Entity.User;

@Service
public class TestService {

	@Resource
	private BasicDaoImp basicdao;

	public Integer insert(User user) {
		return basicdao.insert(user);
		
	}
	


	public void exception() {
		// TODO Auto-generated method stub
		throw new BizException("统一异常处理返回测试内容");
	}
	
	
	

}
