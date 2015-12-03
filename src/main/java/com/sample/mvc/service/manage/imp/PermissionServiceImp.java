package com.sample.mvc.service.manage.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDao;
import com.framework.core.dao.DslSql;
import com.sample.constant.ConstPermission;
import com.sample.mvc.Entity.Permission;
import com.sample.mvc.service.manage.PermissionService;
import com.sample.mvc.vo.manage.TreeVo;

@Service
public class PermissionServiceImp implements PermissionService {

	@Resource
	private BasicDao  basicdao;
	
	@Override
	public List<Permission> findPermissionMenu(TreeVo vo) {
		Permission per=new Permission();
		per.setType(ConstPermission.MENU);
		DslSql dslSql=new DslSql(per).select("*").from("permission").where("type");
		
		return basicdao.query(dslSql, Permission.class);
	}

}
