package com.framework.core.dao;


import javax.annotation.Resource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**通用dao层封装.
 * @author lixiaolong
 * @version datetime：2015年9月28日  下午3:18:54
 */
@Repository
public class BasicDao {

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Resource(name="namedJdbcTemplate")
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	public BasicDao() {
		
	}

}
