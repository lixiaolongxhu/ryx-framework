package com.sample.mvc.controller.manage.extdirectspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mvc.Entity.Resource;
import com.sample.mvc.service.manage.ResourceService;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;



@Service
public class ActionResource {
	
	@javax.annotation.Resource
	private ResourceService resourceService;
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<Resource> read(ExtDirectStoreReadRequest request) {

		List<Resource>   list=resourceService.findResourceList();
		return new ExtDirectStoreReadResult<Resource>(list);
	}

//	// 插入
//	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
//	public ExtDirectStoreReadResult<Resource> create(List<Resource> resources) {
//		resources.get(0).setCls(1);
//		resourceMapper.insert(resources.get(0));
//		if(resources.get(0).getType() == 1){ //视频资源
//			ssMgr.addChannelToList(resources.get(0).getId());
//		}
//		return new ExtDirectStoreReadResult<Resource>(resources.get(0));
//	}
//
//	// 删除
//	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
//	public int destroy(List<Resource> resources) {
//		return resourceMapper.deleteByPrimaryKey(resources.get(0).getId());
//	}
}
