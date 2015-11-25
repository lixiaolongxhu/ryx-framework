package com.sample.mvc.service.manage.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDao;
import com.framework.core.dao.DslSql;
import com.sample.mvc.Entity.Resource;
import com.sample.mvc.service.manage.ResourceService;

@Service
public class ResourceServiceImp implements ResourceService {

	@javax.annotation.Resource
	private BasicDao basicdao;
	
	@Override
	public List<Resource> findResourceList() {
		Resource resource=new Resource();
		DslSql dslSql=new DslSql(resource).select("*").from("resource").where();
		return basicdao.query(dslSql, Resource.class);
	}

}
