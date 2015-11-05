package com.sample.mvc.Entity;

import java.io.Serializable;

public class UserRoleLink implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -644408760737143275L;
	private Integer userId;
	private Integer roleId;
	private Integer status;
	private String createTime;
	private String updateTime;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	

}
