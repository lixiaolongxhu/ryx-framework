package com.framework.core.dao;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.framework.core.exception.BizException;
import com.framework.core.util.ExceptionUtil;
import com.framework.core.vo.PageVo;


/**通用dao层封装.
 * @author lixiaolong
 * @version datetime：2015年9月28日  下午3:18:54
 * @param <T> 泛型
 */
@Repository
public class BasicDaoImp<T>  implements   BasicDao<T> {
	
	/**日志.
	 * 
	 */
	private static final Logger LOG = LoggerFactory.getLogger(BasicDaoImp.class);


	/**spring jdbcTempate.
	 * 
	 */
	private JdbcTemplate jdbcTemplate;
	
	
	/**注入spring jdbcTemplate.
	 * 
	 * @param jdbcTemplate  jdbc
	 */
	@Resource(name="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	/**添加数据库记录.
	 * 
	 * @param object  实体类对象
	 * @return  返回受影响的记录条数
	 */
	@Override
	public Integer insert(Object object){

		String sql =new DslSql(object).generateInsertSql();
		LOG.info("Insert sql:" +  sql);
		Integer affectedRecordNumber=0;
		try {
			affectedRecordNumber=jdbcTemplate.update(sql);	
		} catch (Exception e){
			LOG.error(ExceptionUtil.getExceptionDetail(e));
		} finally {
			if (affectedRecordNumber<=0){
				LOG.warn("数据库添加记录失败!");
				throw new BizException("数据库添加记录失败 !");
			}		
		}
		return affectedRecordNumber;
	
	}
	
	/**添加数据库记录.
	 * 
	 * @param object  添加到数据库的实体类
	 * @param primaryKeyName  自增长主键名
	 * @return  返回自增长主键值
	 */
	@Override
	public Integer    insert(Object object, String primaryKeyName){
		String sql =new DslSql(object).generateInsertSql(primaryKeyName);
		LOG.info("Insert sql:" +  sql);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer affectedRecordNumber=0;
		try {
			affectedRecordNumber =   jdbcTemplate.update(sql, keyHolder);	
		} catch (Exception e){
			LOG.error(ExceptionUtil.getExceptionDetail(e));
		} finally {
			if (affectedRecordNumber<=0){
				LOG.warn("数据库添加记录失败!");
				throw new BizException("数据库添加记录失败 !");
			}		
		} 
		return keyHolder.getKey().intValue();
	}
	
	

	/**向数据库修javabean对应的数据库表记录.
	 * 
	 * @param object   javabean对象
	 * @param conditionFieldNameS  修改where条件对应的字段名数组，各个字段间采用与运算
	 * @return  返回受影响的记录条数
	 */
	@Override
	public Integer update(Object object, String... conditionFieldNameS){
		
		String sql = new DslSql(object).generateUpdateSql(
				conditionFieldNameS);
		LOG.info("update  sql:" + sql);
		Integer affectedRecordNumber=0;
		try {
			affectedRecordNumber=jdbcTemplate.update(sql);	
		} catch (Exception e){
			LOG.error(ExceptionUtil.getExceptionDetail(e));
		} finally {
			if (affectedRecordNumber<=0){
				LOG.warn("数据库修改记录失败 !");
				throw new BizException("数据库修改记录失败 !");
			}		
		}
		return affectedRecordNumber;
	}
	
	/**向数据库删除javabean对应的数据库记录.
	 * 
	 * @param object
	 *            javabean对象
	 * @param conditionFieldName
	 *            删除where条件对应的字段名数组，各个字段间采用与运算
	 * @return  返回受影响的记录条数            
	 */
	@Override
	public Integer delete(Object object, String... conditionFieldName) {
		String sql =new DslSql(object).generateDeleteSql(conditionFieldName);
		LOG.info("Delete() sql:" + sql);
		Integer affectedRecordNumber=0;
		try {
			affectedRecordNumber=jdbcTemplate.update(sql);	
		} catch (Exception e){
			LOG.error(ExceptionUtil.getExceptionDetail(e));
		} finally {
			if (affectedRecordNumber<=0){
				LOG.warn("数据库删除记录失败!");
				throw new BizException("数据库删除记录失败!");
			}		
		}
		return affectedRecordNumber;
	}
	
	
	/**执行查询操作.
	 * 
	 * @param dslSql   封装的查询工具类（封装后的sql语句）
	 * @param cls      返回参数对象的class类型定义
	 * @return 返回查询结果的list
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> query(DslSql dslSql, Class<T> cls) {
		String sql=dslSql.toSql();
		LOG.info("query  sql:" + sql);	
		List<T> returnList=new ArrayList<T>();
		try {
			returnList= jdbcTemplate.query(sql, new BeanPropertyRowMapper(cls));
		} catch (Exception e){
			LOG.error(ExceptionUtil.getExceptionDetail(e));
			throw new BizException("查询数据库列表记录出现异常!");
		} 
		
		if (returnList==null){
			return new ArrayList<T>();
		}
		return returnList;
			
	}
	
	/**执行查询操作.
	 * 
	 * @param dslSql   封装的查询工具类（封装后的sql语句）
	 * @param cls      返回参数对象的class类型定义
	 * @return   返回传入传入参数class类型的实体类对象；仅返回一条记录
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T queryOne(DslSql dslSql, Class<T> cls) {
		String sql = dslSql.toSql()+" LIMIT 1";
		LOG.info(" queryOne  sql:"+sql);
		T obj = null;
		try {
		    obj=(T) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(cls));
		} catch (Exception e){
			LOG.error(ExceptionUtil.getExceptionDetail(e));
			throw new BizException("查询数据库期望返回一条记录，实际未返回一条记录!");
		}
		
		if (obj == null) {
			try {
				return cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				LOG.error(ExceptionUtil.getExceptionDetail(e));
				throw new BizException("查询数据库一条记录，实际返回为空，实例出空对象时出现异常!");
			}
		} else {
			return obj;
		}
			

	}
	
	
	/**执行查询返回单列对象，统计记录条数，查询数据库某列的值等.
	 * 
	 * @param dslSql   封装的查询工具类（封装后的sql语句）
	 *           
	 * @return 返回查询统计的记录条数
	 */
	@Override
	public Integer queryCount(DslSql dslSql) {
		String sql=dslSql.toSql();
		LOG.info("QueryCount()  sql:" + sql);
		Integer   num=0;
		try {
			num=jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (Exception e) {
			LOG.error(ExceptionUtil.getExceptionDetail(e));
			throw new BizException("查询数据库记录条数出现异常!");
		}
		
		if (num==null){
			num=0;
		}
		return num;
	}
	
	
	/**分页查询.
	 * @param dslSql  统计结果集列表
	 * @param totalDslSql 统计结果集记录条数
	 * @param cls     返回传入传入参数class类型的实体类对象
	 * @return    返回查询的记录结果集与记录条数
	 */
	@Override
	public  PageVo<T>   queryPaging(DslSql dslSql, DslSql totalDslSql, Class<T> cls) {
		LOG.info("queryPageing  dslSql:"+dslSql.toSql());
		LOG.info("queryPageing  totalDslSql:"+totalDslSql.toSql());
		List<T>  rows=query(dslSql, cls);
		Integer   total=queryCount(totalDslSql);
		return new PageVo<T>(rows, total);
		
	}


	

}
