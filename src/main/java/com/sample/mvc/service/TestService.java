package com.sample.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDao;
import com.sample.mvc.Entity.User;

@Service
public class TestService {

	@Resource
	private BasicDao basicdao;

	public Integer insert(User user) {
		return basicdao.insert(user);
		
	}
	
	
	

}
