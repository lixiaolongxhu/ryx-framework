package com.sample.db.model;

import java.io.Serializable;

public class UserRoleLink extends UserRoleLinkKey implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.status
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.createTime
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.updateTime
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.status
	 * @return  the value of user_role_link.status
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.status
	 * @param status  the value for user_role_link.status
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.createTime
	 * @return  the value of user_role_link.createTime
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.createTime
	 * @param createtime  the value for user_role_link.createTime
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.updateTime
	 * @return  the value of user_role_link.updateTime
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.updateTime
	 * @param updatetime  the value for user_role_link.updateTime
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
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
		sb.append(", status=").append(status);
		sb.append(", createtime=").append(createtime);
		sb.append(", updatetime=").append(updatetime);
		sb.append("]");
		return sb.toString();
	}
}