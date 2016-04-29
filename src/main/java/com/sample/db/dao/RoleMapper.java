package com.sample.db.dao;

import com.sample.db.model.Role;
import com.sample.db.model.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface RoleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@SelectProvider(type = RoleSqlProvider.class, method = "countByExample")
	int countByExample(RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@DeleteProvider(type = RoleSqlProvider.class, method = "deleteByExample")
	int deleteByExample(RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@Delete({ "delete from role", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@Insert({ "insert into role (parentId, name, ", "status, createTime, ",
			"updateTime)",
			"values (#{parentid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{status,jdbcType=TINYINT}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@InsertProvider(type = RoleSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@SelectProvider(type = RoleSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "parentId", property = "parentid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<Role> selectByExampleWithRowbounds(RoleExample example,
			RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@SelectProvider(type = RoleSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "parentId", property = "parentid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<Role> selectByExample(RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@Select({ "select", "id, parentId, name, status, createTime, updateTime",
			"from role", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "parentId", property = "parentid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	Role selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@UpdateProvider(type = RoleSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Role record,
			@Param("example") RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@UpdateProvider(type = RoleSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Role record,
			@Param("example") RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@UpdateProvider(type = RoleSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbggenerated  Thu Jan 21 15:12:39 CST 2016
	 */
	@Update({ "update role", "set parentId = #{parentid,jdbcType=INTEGER},",
			"name = #{name,jdbcType=VARCHAR},",
			"status = #{status,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Role record);
}