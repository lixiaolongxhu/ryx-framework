package com.sample.mvc.vo.manage;

import java.util.List;

import com.sample.mvc.Entity.Permission;

public class PermisssionVo  extends Permission{

	private  List<Permission>  children;

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}
	
	
}
