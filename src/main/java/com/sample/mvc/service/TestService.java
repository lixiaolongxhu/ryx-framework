package com.sample.mvc.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.framework.core.dao.BasicDaoImp;
import com.framework.core.dao.DslSql;
import com.framework.core.exception.BizException;
import com.sample.mvc.Entity.User;

@Service
public class TestService {

	@SuppressWarnings("rawtypes")
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


	//将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key
	//通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值
	@Cacheable(value="myCache", key="'selectCache'+#token")
	public User selectCache() {
		User select =new User();
		select.setToken("f20df78d-fc4d-4b90-95f6-d2db0935120c");
		DslSql dslSql=new DslSql(select)
			.select("*")
			.from("user")
			.where("token");
		@SuppressWarnings("unchecked")
		User returnUser=(User) basicdao.queryOne(dslSql, User.class);
		return returnUser;
	}
	

}
