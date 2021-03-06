package com.sample.db.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public UserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andLoginnameIsNull() {
			addCriterion("loginName is null");
			return (Criteria) this;
		}

		public Criteria andLoginnameIsNotNull() {
			addCriterion("loginName is not null");
			return (Criteria) this;
		}

		public Criteria andLoginnameEqualTo(String value) {
			addCriterion("loginName =", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameNotEqualTo(String value) {
			addCriterion("loginName <>", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameGreaterThan(String value) {
			addCriterion("loginName >", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
			addCriterion("loginName >=", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameLessThan(String value) {
			addCriterion("loginName <", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameLessThanOrEqualTo(String value) {
			addCriterion("loginName <=", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameLike(String value) {
			addCriterion("loginName like", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameNotLike(String value) {
			addCriterion("loginName not like", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameIn(List<String> values) {
			addCriterion("loginName in", values, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameNotIn(List<String> values) {
			addCriterion("loginName not in", values, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameBetween(String value1, String value2) {
			addCriterion("loginName between", value1, value2, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameNotBetween(String value1, String value2) {
			addCriterion("loginName not between", value1, value2, "loginname");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andTokenIsNull() {
			addCriterion("token is null");
			return (Criteria) this;
		}

		public Criteria andTokenIsNotNull() {
			addCriterion("token is not null");
			return (Criteria) this;
		}

		public Criteria andTokenEqualTo(String value) {
			addCriterion("token =", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenNotEqualTo(String value) {
			addCriterion("token <>", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenGreaterThan(String value) {
			addCriterion("token >", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenGreaterThanOrEqualTo(String value) {
			addCriterion("token >=", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenLessThan(String value) {
			addCriterion("token <", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenLessThanOrEqualTo(String value) {
			addCriterion("token <=", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenLike(String value) {
			addCriterion("token like", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenNotLike(String value) {
			addCriterion("token not like", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenIn(List<String> values) {
			addCriterion("token in", values, "token");
			return (Criteria) this;
		}

		public Criteria andTokenNotIn(List<String> values) {
			addCriterion("token not in", values, "token");
			return (Criteria) this;
		}

		public Criteria andTokenBetween(String value1, String value2) {
			addCriterion("token between", value1, value2, "token");
			return (Criteria) this;
		}

		public Criteria andTokenNotBetween(String value1, String value2) {
			addCriterion("token not between", value1, value2, "token");
			return (Criteria) this;
		}

		public Criteria andRealnameIsNull() {
			addCriterion("realName is null");
			return (Criteria) this;
		}

		public Criteria andRealnameIsNotNull() {
			addCriterion("realName is not null");
			return (Criteria) this;
		}

		public Criteria andRealnameEqualTo(String value) {
			addCriterion("realName =", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameNotEqualTo(String value) {
			addCriterion("realName <>", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameGreaterThan(String value) {
			addCriterion("realName >", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameGreaterThanOrEqualTo(String value) {
			addCriterion("realName >=", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameLessThan(String value) {
			addCriterion("realName <", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameLessThanOrEqualTo(String value) {
			addCriterion("realName <=", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameLike(String value) {
			addCriterion("realName like", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameNotLike(String value) {
			addCriterion("realName not like", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameIn(List<String> values) {
			addCriterion("realName in", values, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameNotIn(List<String> values) {
			addCriterion("realName not in", values, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameBetween(String value1, String value2) {
			addCriterion("realName between", value1, value2, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameNotBetween(String value1, String value2) {
			addCriterion("realName not between", value1, value2, "realname");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNull() {
			addCriterion("nickname is null");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNotNull() {
			addCriterion("nickname is not null");
			return (Criteria) this;
		}

		public Criteria andNicknameEqualTo(String value) {
			addCriterion("nickname =", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotEqualTo(String value) {
			addCriterion("nickname <>", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThan(String value) {
			addCriterion("nickname >", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThanOrEqualTo(String value) {
			addCriterion("nickname >=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThan(String value) {
			addCriterion("nickname <", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThanOrEqualTo(String value) {
			addCriterion("nickname <=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLike(String value) {
			addCriterion("nickname like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotLike(String value) {
			addCriterion("nickname not like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameIn(List<String> values) {
			addCriterion("nickname in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotIn(List<String> values) {
			addCriterion("nickname not in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameBetween(String value1, String value2) {
			addCriterion("nickname between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotBetween(String value1, String value2) {
			addCriterion("nickname not between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andPortraitpathIsNull() {
			addCriterion("portraitPath is null");
			return (Criteria) this;
		}

		public Criteria andPortraitpathIsNotNull() {
			addCriterion("portraitPath is not null");
			return (Criteria) this;
		}

		public Criteria andPortraitpathEqualTo(String value) {
			addCriterion("portraitPath =", value, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathNotEqualTo(String value) {
			addCriterion("portraitPath <>", value, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathGreaterThan(String value) {
			addCriterion("portraitPath >", value, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathGreaterThanOrEqualTo(String value) {
			addCriterion("portraitPath >=", value, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathLessThan(String value) {
			addCriterion("portraitPath <", value, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathLessThanOrEqualTo(String value) {
			addCriterion("portraitPath <=", value, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathLike(String value) {
			addCriterion("portraitPath like", value, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathNotLike(String value) {
			addCriterion("portraitPath not like", value, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathIn(List<String> values) {
			addCriterion("portraitPath in", values, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathNotIn(List<String> values) {
			addCriterion("portraitPath not in", values, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathBetween(String value1, String value2) {
			addCriterion("portraitPath between", value1, value2, "portraitpath");
			return (Criteria) this;
		}

		public Criteria andPortraitpathNotBetween(String value1, String value2) {
			addCriterion("portraitPath not between", value1, value2,
					"portraitpath");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Byte value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Byte value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Byte value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Byte value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Byte value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Byte> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Byte> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Byte value1, Byte value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("createTime is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("createTime is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(String value) {
			addCriterion("createTime =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(String value) {
			addCriterion("createTime <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(String value) {
			addCriterion("createTime >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
			addCriterion("createTime >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(String value) {
			addCriterion("createTime <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(String value) {
			addCriterion("createTime <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLike(String value) {
			addCriterion("createTime like", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotLike(String value) {
			addCriterion("createTime not like", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<String> values) {
			addCriterion("createTime in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<String> values) {
			addCriterion("createTime not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(String value1, String value2) {
			addCriterion("createTime between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(String value1, String value2) {
			addCriterion("createTime not between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIsNull() {
			addCriterion("updateTime is null");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIsNotNull() {
			addCriterion("updateTime is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeEqualTo(String value) {
			addCriterion("updateTime =", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotEqualTo(String value) {
			addCriterion("updateTime <>", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeGreaterThan(String value) {
			addCriterion("updateTime >", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
			addCriterion("updateTime >=", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeLessThan(String value) {
			addCriterion("updateTime <", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
			addCriterion("updateTime <=", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeLike(String value) {
			addCriterion("updateTime like", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotLike(String value) {
			addCriterion("updateTime not like", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIn(List<String> values) {
			addCriterion("updateTime in", values, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotIn(List<String> values) {
			addCriterion("updateTime not in", values, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeBetween(String value1, String value2) {
			addCriterion("updateTime between", value1, value2, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotBetween(String value1, String value2) {
			addCriterion("updateTime not between", value1, value2, "updatetime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbggenerated do_not_delete_during_merge Thu Jan 21 14:21:10 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}