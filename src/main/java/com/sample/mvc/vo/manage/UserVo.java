package com.sample.mvc.vo.manage;

import com.sample.mvc.Entity.Permission;
import com.sample.mvc.Entity.Role;

import java.io.Serializable;
import java.util.List;

import com.sample.mvc.Entity.User;

public class UserVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5649512482264089155L;

	private User user;

	private List<Role> roleList;
	
	private List<Permission> permissionList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	
	
}
