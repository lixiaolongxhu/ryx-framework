package com.sample.db.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.sample.db.model.RolePermissionLink;
import com.sample.db.model.RolePermissionLinkExample.Criteria;
import com.sample.db.model.RolePermissionLinkExample.Criterion;
import com.sample.db.model.RolePermissionLinkExample;
import java.util.List;
import java.util.Map;

public class RolePermissionLinkSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String countByExample(RolePermissionLinkExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("role_permission_link");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String deleteByExample(RolePermissionLinkExample example) {
		BEGIN();
		DELETE_FROM("role_permission_link");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String insertSelective(RolePermissionLink record) {
		BEGIN();
		INSERT_INTO("role_permission_link");
		if (record.getRoleid() != null) {
			VALUES("roleId", "#{roleid,jdbcType=INTEGER}");
		}
		if (record.getPermissionid() != null) {
			VALUES("permissionId", "#{permissionid,jdbcType=INTEGER}");
		}
		if (record.getStatus() != null) {
			VALUES("status", "#{status,jdbcType=TINYINT}");
		}
		if (record.getCreatetime() != null) {
			VALUES("createTime", "#{createtime,jdbcType=VARCHAR}");
		}
		if (record.getUpdatetime() != null) {
			VALUES("updateTime", "#{updatetime,jdbcType=VARCHAR}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String selectByExample(RolePermissionLinkExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("roleId");
		} else {
			SELECT("roleId");
		}
		SELECT("permissionId");
		SELECT("status");
		SELECT("createTime");
		SELECT("updateTime");
		FROM("role_permission_link");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		RolePermissionLink record = (RolePermissionLink) parameter
				.get("record");
		RolePermissionLinkExample example = (RolePermissionLinkExample) parameter
				.get("example");
		BEGIN();
		UPDATE("role_permission_link");
		if (record.getRoleid() != null) {
			SET("roleId = #{record.roleid,jdbcType=INTEGER}");
		}
		if (record.getPermissionid() != null) {
			SET("permissionId = #{record.permissionid,jdbcType=INTEGER}");
		}
		if (record.getStatus() != null) {
			SET("status = #{record.status,jdbcType=TINYINT}");
		}
		if (record.getCreatetime() != null) {
			SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		}
		if (record.getUpdatetime() != null) {
			SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("role_permission_link");
		SET("roleId = #{record.roleid,jdbcType=INTEGER}");
		SET("permissionId = #{record.permissionid,jdbcType=INTEGER}");
		SET("status = #{record.status,jdbcType=TINYINT}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		RolePermissionLinkExample example = (RolePermissionLinkExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	public String updateByPrimaryKeySelective(RolePermissionLink record) {
		BEGIN();
		UPDATE("role_permission_link");
		if (record.getStatus() != null) {
			SET("status = #{status,jdbcType=TINYINT}");
		}
		if (record.getCreatetime() != null) {
			SET("createTime = #{createtime,jdbcType=VARCHAR}");
		}
		if (record.getUpdatetime() != null) {
			SET("updateTime = #{updatetime,jdbcType=VARCHAR}");
		}
		WHERE("roleId = #{roleid,jdbcType=INTEGER}");
		WHERE("permissionId = #{permissionid,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	protected void applyWhere(RolePermissionLinkExample example,
			boolean includeExamplePhrase) {
		if (example == null) {
			return;
		}
		String parmPhrase1;
		String parmPhrase1_th;
		String parmPhrase2;
		String parmPhrase2_th;
		String parmPhrase3;
		String parmPhrase3_th;
		if (includeExamplePhrase) {
			parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		} else {
			parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		}
		StringBuilder sb = new StringBuilder();
		List<Criteria> oredCriteria = example.getOredCriteria();
		boolean firstCriteria = true;
		for (int i = 0; i < oredCriteria.size(); i++) {
			Criteria criteria = oredCriteria.get(i);
			if (criteria.isValid()) {
				if (firstCriteria) {
					firstCriteria = false;
				} else {
					sb.append(" or ");
				}
				sb.append('(');
				List<Criterion> criterions = criteria.getAllCriteria();
				boolean firstCriterion = true;
				for (int j = 0; j < criterions.size(); j++) {
					Criterion criterion = criterions.get(j);
					if (firstCriterion) {
						firstCriterion = false;
					} else {
						sb.append(" and ");
					}
					if (criterion.isNoValue()) {
						sb.append(criterion.getCondition());
					} else if (criterion.isSingleValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase1,
									criterion.getCondition(), i, j));
						} else {
							sb.append(String.format(parmPhrase1_th,
									criterion.getCondition(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase2,
									criterion.getCondition(), i, j, i, j));
						} else {
							sb.append(String.format(parmPhrase2_th,
									criterion.getCondition(), i, j,
									criterion.getTypeHandler(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isListValue()) {
						sb.append(criterion.getCondition());
						sb.append(" (");
						List<?> listItems = (List<?>) criterion.getValue();
						boolean comma = false;
						for (int k = 0; k < listItems.size(); k++) {
							if (comma) {
								sb.append(", ");
							} else {
								comma = true;
							}
							if (criterion.getTypeHandler() == null) {
								sb.append(String.format(parmPhrase3, i, j, k));
							} else {
								sb.append(String.format(parmPhrase3_th, i, j,
										k, criterion.getTypeHandler()));
							}
						}
						sb.append(')');
					}
				}
				sb.append(')');
			}
		}
		if (sb.length() > 0) {
			WHERE(sb.toString());
		}
	}
}