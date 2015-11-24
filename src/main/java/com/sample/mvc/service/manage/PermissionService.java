package com.sample.mvc.service.manage;

import java.util.List;

import com.sample.mvc.Entity.Permission;

public interface PermissionService {

	/**查询权限菜单列表
	 * 
	 * @return
	 */
	List<Permission> findPermissionMenu();

}
