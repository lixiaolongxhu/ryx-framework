package com.sample.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.framework.core.dao.BasicDao;
import com.framework.core.dao.BasicDaoImp;
import com.framework.core.exception.BizException;
import com.sample.mvc.Entity.User;
@Service
public class Test2Service {

	@Resource
	private BasicDao basicdao;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void tran2(User user){
		basicdao.insert(user);
//		throw new BizException("异常回滚测试");
	}

}
