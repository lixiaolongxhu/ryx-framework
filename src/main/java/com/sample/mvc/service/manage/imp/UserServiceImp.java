package com.sample.mvc.service.manage.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDao;
import com.sample.mvc.service.manage.UserService;



@Service
@SuppressWarnings("rawtypes")
public class UserServiceImp  implements UserService{
	
	@Resource
	private BasicDao basicdao;
	

}
