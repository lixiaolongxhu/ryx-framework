package com.framework.core.dao;


import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



/**通用dao层封装.
 * @author lixiaolong
 * @version datetime：2015年9月28日  下午3:18:54
 */
@Repository
public class BasicDao {

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name="namedJdbcTemplate")
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	@Resource(name="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public BasicDao() {
		
	}
	
	
	public void Insert(Object object){
//		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(
//				object);
//		String sql =new DslSql(object).generateInsertSql("", true);
//		log.debug("Insert  sql:" + sql);
		String sql="";
		int affectedRecordNumber=jdbcTemplate.update(sql);
//		if(affectedRecordNumber<=0){
//			log.warn("数据库添加记录失败 :  sql="+sql);
//			throw new BizException("数据库添加记录失败 :  sql="+sql);
//		}
	}

}
