package com.sample.mvc.service.manage.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDao;
import com.framework.core.dao.DslSql;
import com.sample.mvc.Entity.ResType;
import com.sample.mvc.service.ResTypeService;

@Service
public class ResTypeServiceImp implements ResTypeService {
	
	@Resource
	private BasicDao basicdao;

	@Override
	public List<ResType> findAllResType() {
		// TODO Auto-generated method stub
		ResType resType=new ResType();
		DslSql dslSql=new DslSql(resType).select("*").from("res_type").where();
		return basicdao.query(dslSql, ResType.class);
	}
}
