package com.framework.core.dao;

import java.util.List;
import com.framework.core.vo.PageVo;

/**通用dao层接口.
 * @author lixiaolong
 * @version datetime：2015年10月14日  上午10:37:10
 */

public interface BasicDao {

	/**添加数据库记录.
	 * 
	 * @param object  实体类对象
	 * @return  返回受影响的记录条数
	 */
	public Integer insert(Object object);
	
	/**添加数据库记录.
	 * 
	 * @param object  添加到数据库的实体类
	 * @param primaryKeyName  自增长主键名
	 * @return  返回自增长主键值
	 */
	public Integer    insert(Object object, String primaryKeyName);
	
	/**向数据库修javabean对应的数据库表记录.
	 * 
	 * @param object   javabean对象
	 * @param conditionFieldNameS  修改where条件对应的字段名数组，各个字段间采用与运算
	 * @return  返回受影响的记录条数
	 */
	public Integer update(Object object, String... conditionFieldNameS);
	
	/**向数据库删除javabean对应的数据库记录.
	 * 
	 * @param object
	 *            javabean对象
	 * @param conditionFieldName
	 *            删除where条件对应的字段名数组，各个字段间采用与运算
	 * @return  返回受影响的记录条数            
	 */
	public Integer delete(Object object, String... conditionFieldName);
	
	/**执行查询操作.
	 * 
	 * @param dslSql   封装的查询工具类（封装后的sql语句）
	 * @param cls      返回参数对象的class类型定义
	 * @return 返回查询结果的list
	 */
	public List<Object> query(DslSql dslSql, Class<Object> cls);
	
	/**执行查询操作.
	 * 
	 * @param dslSql   封装的查询工具类（封装后的sql语句）
	 * @param cls      返回参数对象的class类型定义
	 * @return   返回传入传入参数class类型的实体类对象；仅返回一条记录
	 */
	public Object queryOne(DslSql dslSql, Class<Object> cls);
	
	/**执行查询返回单列对象，统计记录条数，查询数据库某列的值等.
	 * 
	 * @param dslSql   封装的查询工具类（封装后的sql语句）
	 *           
	 * @return 返回查询统计的记录条数
	 */
	public Integer queryCount(DslSql dslSql);
	
	/**分页查询.
	 * @param dslSql  统计结果集列表
	 * @param totalDslSql 统计结果集记录条数
	 * @param cls     返回传入传入参数class类型的实体类对象
	 * @return    返回查询的记录结果集与记录条数
	 */
	public  PageVo    queryPaging(DslSql dslSql, DslSql totalDslSql, Class<Object> cls);
}
