package com.sample.db.model;

import java.io.Serializable;

public class UserRoleLinkKey implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.userId
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	private Integer userid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.roleId
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	private Integer roleid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.userId
	 * @return  the value of user_role_link.userId
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public Integer getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.userId
	 * @param userid  the value for user_role_link.userId
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.roleId
	 * @return  the value of user_role_link.roleId
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.roleId
	 * @param roleid  the value for user_role_link.roleId
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", userid=").append(userid);
		sb.append(", roleid=").append(roleid);
		sb.append("]");
		return sb.toString();
	}
}