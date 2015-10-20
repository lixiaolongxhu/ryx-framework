package com.sample.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.framework.core.dao.BasicDaoImp;
import com.framework.core.exception.BizException;
import com.sample.mvc.Entity.User;

@Service
public class TestService {

	@Resource
	private BasicDaoImp basicdao;
	@Resource
	private Test2Service  test2Service;

	public Integer insert(User user) {
		return basicdao.insert(user);
		
	}
	


	public void exception() {
		// TODO Auto-generated method stub
		throw new BizException("统一异常处理返回测试内容");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void tran(User user) {
		
		tran2(user);
		
		throw new BizException("异常回滚测试");
	}
	
	
	public void tran2(User user){
		basicdao.insert(user);
//		throw new BizException("异常回滚测试");
	}
	

}
