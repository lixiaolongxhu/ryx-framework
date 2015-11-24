package com.sample.mvc.controller.manage.extdirectspring;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mvc.Entity.Permission;
import com.sample.mvc.service.manage.PermissionService;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;

@Service
public class ActionPermission {
	

	@Resource
	private PermissionService permissionService;
	
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<Permission> read(ExtDirectStoreReadRequest request) {
		List<Permission>  perList=permissionService.findPermissionMenu();
		

		return new ExtDirectStoreReadResult<Permission>(perList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<Permission> create(List<Permission> resources) {
//		resources.get(0).setCls(1);
//		resourceMapper.insert(resources.get(0));
//		if(resources.get(0).getType() == 1){ //视频资源
//			ssMgr.addChannelToList(resources.get(0).getId());
//		}
//		return new ExtDirectStoreReadResult<Resource>(resources.get(0));
		return null ;
		
	}

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<Permission> resources) {
		return 0;
//		return resourceMapper.deleteByPrimaryKey(resources.get(0).getId());
	}
}
