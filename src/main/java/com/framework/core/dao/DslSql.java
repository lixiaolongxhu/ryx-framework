package  com.framework.core.dao;


import java.util.Set;

import org.springframework.util.StringUtils;

import com.framework.core.dto.PageDto;

import net.sf.cglib.beans.BeanMap;

/**自动生成sql类.
 * @author lixiaolong
 * @version datetime：2015年10月8日  上午10:32:09
 */
public class DslSql {

	
	/**表名.
	 * 
	 */
	private  String tableName = "";

	/**查询sql.
	 * 
	 */
	private  StringBuilder selectSql = new StringBuilder(" ");

	/**查询where.
	 * 
	 */
	private  StringBuilder selectWhere = new StringBuilder(" where 1=1");

	/**javabean属性名数组.
	 * 
	 */
	private  String[] attributeName;
	/**javabean属性值数组.
	 * 
	 */
	private  Object[] attributeValue;
	/**javabean属性类型数组.
	 * 
	 */
	private  String[] attributeType;
	
	/**初始以及获取javabean的信息的构造函数.
	 * 
	 * @param obj  传入需要处理的javabean对象
	 */
	@SuppressWarnings("unchecked")
	public DslSql(Object obj)  {	
       BeanMap  objBeanMap = BeanMap.create(obj); 
       Set<String> keySet=objBeanMap.keySet();
       Integer  keySetSize=keySet.size();
       this.attributeName=new String[keySetSize];
       this.attributeValue=new Object[keySetSize];
       this.attributeType=new String[keySetSize];
   	   int i=0;
   	   for (String key : keySet) {
   		   if ("__cobertura_counters".equals(key)){
   			   continue;
   		   }
   		   attributeName[i]=key;
   		   attributeType[i]=objBeanMap.getPropertyType(key).getSimpleName();
   		   attributeValue[i]=objBeanMap.get(key);    
    	   i++;
   	   } 
	   this.tableName = StringUtils.uncapitalize(obj.getClass().getSimpleName());
	}
	
	/**进行类名与数据库表名转换.
	 * 规则： 类名 UserRoleLink--- 表名   user_role_link
	 * @param name  编码的名称
	 * @return  返回修改后的表名
	 */
	private  String underscoreName(String name) {
		
		StringBuilder result = new StringBuilder();
		
		for (char letter : name.toCharArray()) {
			if (Character.isUpperCase(letter)) {
				result.append("_");
				result.append(String.valueOf(letter).toLowerCase());
			} else  {
				
				result.append(letter);
			}
		}
		result.insert(0, "`");
		result.append("`");
		return result.toString();
	}
	
	/**生成javabean的mysql单表插入语句.
	 * 
	 * @return 返回对应的javabean插入sql语句。
	
	 */
	public  String generateInsertSql(){
		
		StringBuilder sql = new StringBuilder("");
		sql.append(" insert into ");
		sql.append(underscoreName(tableName));
		sql.append(" (");

		for (int i = 0; i < attributeName.length; i++) {
			if (attributeValue[i]!=null) {	
				sql.append(attributeName[i]);
				sql.append(",");
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		sql.append(" values (");
		for (int i = 0; i < attributeName.length; i++) {
			if (attributeValue[i]!=null) {
				sql.append(getAttributeValueSqlByType(attributeValue[i], attributeType[i]));
				sql.append(",");
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		return sql.toString();
	}
	
	/**生成javabean的mysql单表插入语句，不插入设置主键名的字段.
	 * 
	 * @param  primaryKeyName 主键名
	 * @return 返回对应的javabean插入sql语句。
	
	 */
	public  String generateInsertSql( String  primaryKeyName){
		
		StringBuilder sql = new StringBuilder("");
		sql.append(" insert into ");
		sql.append(underscoreName(tableName));
		sql.append(" (");

		for (int i = 0; i < attributeName.length; i++) {
			if (attributeValue[i]!=null && !attributeValue[i].equals(primaryKeyName)) {	
				sql.append(attributeName[i]);
				sql.append(",");
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		sql.append(" values (");
		for (int i = 0; i < attributeName.length; i++) {
			if (attributeValue[i]!=null && !attributeValue[i].equals(primaryKeyName)) {
				sql.append(getAttributeValueSqlByType(attributeValue[i], attributeType[i]));
				sql.append(",");
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		return sql.toString();
	}
	
	/**根据参数类型获取对应的值.
	 * 
	 * @param value  属性值
	 * @param type   属性值对应的类型
	 * @return  返回修正后的属性值
	 */
    private String getAttributeValueSqlByType(Object value, String type) {
    	if (value == null) {
    		return null;
    	}
		if ("String".equals(type.trim())) {
			StringBuilder  valueSql=new StringBuilder("");
			valueSql.append("'");
			valueSql.append(value);
			valueSql.append("'");
			return  valueSql.toString();
		}
		return value.toString();
	}
    

	/**生成javabean的mysql单表修改语句.
	 * 
	 * @param conditionFieldName
	 *            修改sql对应where后面的条件字段数组，各字段之间使用与运算
	 * @return 返回对应的javabean修改sql语句
	 */
	public  String generateUpdateSql(String[] conditionFieldName){
		
		StringBuilder sql = new StringBuilder("");
		sql.append(" update ");
		sql.append(underscoreName(tableName));
		sql.append(" set ");
		
		for (int i = 0; i < attributeName.length; i++) {
			if (attributeValue[i] != null ) {	
				sql.append(attributeName[i]);
				sql.append("=");
				sql.append(getAttributeValueSqlByType(attributeValue[i] , attributeType[i]));
				sql.append(",");
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" where ");
		for (int i = 0; i < conditionFieldName.length; i++) {
			if (i != 0) {
				sql.append(" and ");
			}
			sql.append(conditionFieldName[i]);
			sql.append("=");
			sql.append(getConditionValueSql(conditionFieldName[i]));

		}
		return sql.toString();
	}
	
	/**根据条件名，获取对应的值.
	 * 
	 * @param conditionName 条件名
	 * @return 返回条件的值sql
	 */
    private String getConditionValueSql(String conditionName) {
    	String conditionSql="''";
    	
		for (int i=0; i<attributeName.length; i++){
			if (conditionName.trim().equals(attributeName[i])){
				conditionSql = getAttributeValueSqlByType(attributeValue[i], attributeType[i]);
				break;
			}
		}
		return conditionSql;
	}


	/**生成javabean的mysql单表删除语句.
	 * 
	 * @param conditionFieldName
	 *            删除sql对应where后面的条件字段数组，各个字段之间使用与运算
	 * @return 返回对应javabean删除的sql语句
	 */
	public  String generateDeleteSql(
			String[] conditionFieldName) {
		StringBuilder sql = new StringBuilder("");
		sql.append(" delete from  ");
		sql.append(underscoreName(tableName));
		sql.append(" where  ");
		for (int i = 0; i < conditionFieldName.length; i++) {
			if (i != 0) {
				sql.append(" and ");
			}
			sql.append(conditionFieldName[i]);
			sql.append("=");
			sql.append(getConditionValueSql(conditionFieldName[i]));
		}
		return sql.toString();

	}

	
	
	/**查询sql 语句封装方法
	 * 查询sql 语句格式规范
	 * ------------begin
	 */
	
	/**查询select 关键字.
	 * 
	 * @param select 查询内容.
	 * @return 返回对象本身
	 */
	public DslSql select(String select) {
		selectSql.append(" select  ");
		selectSql.append(select);
		return this;
	}

	/**查询from关键字.
	 * 
	 * @param selectTableName  查询表名
	 * @return  返回对象本身
	 */
	public DslSql from(String selectTableName) {
		selectSql.append(" from ");
		selectSql.append("`");
		selectSql.append(selectTableName.trim());
		selectSql.append("`");
		return this;
	}

	/**内连接.
	 * @param selectTableName  查询表名
	 * @return  返回对象本身
	 */
	public DslSql innerJoin(String selectTableName) {
		selectSql.append(" inner join ");
		selectSql.append(selectTableName);
		return this;
	}
	
	/**左连接.
	 * @param selectTableName  查询表名
	 * @return  返回对象本身
	 */
	public DslSql leftJoin(String selectTableName) {
		selectSql.append(" left join ");
		selectSql.append(selectTableName);
		return this;
	}

	/**右连接.
	 * @param selectTableName  查询表名
	 * @return  返回对象本身
	 */
	public DslSql rightJoin(String selectTableName) {
		selectSql.append(" right join " + selectTableName);
		return this;
	}
	
	/**连接查询 on.
	 * @param on  连接查询条件
	 * @return 返回对象本身
	 */
	public DslSql on(String on) {
		selectSql.append(" on ");
		selectSql.append(on);
		return this;
	}

	/**where查询.
	 * @param fields  查询条件名称
	 * @return  返回对象本身
	 */
	public DslSql where(String... fields) {
		
		for (String condtionName : fields) {
			String[] condtionNameArray=getCondtionNameSql(condtionName);
			String valueSql=getConditionValueSql(condtionNameArray[1]);
			if (valueSql == null) {
				continue;
			}
			selectWhere.append(" and ");
			selectWhere.append(condtionNameArray[0]);
			selectWhere.append("=");
			selectWhere.append(valueSql);
			
		}
		selectSql.append(selectWhere);
		return this;
	}
	/**处理条件名.
	 * 
	 * 
	 * @param condtionName  条件名
	 * @return 返回处理后的条件数组
	 */
	private String[] getCondtionNameSql(String condtionName) {
		String[]  nameArray=new String[2];
		StringBuilder  name=new StringBuilder();
		String[] condtionNameArray= condtionName.split("\\.");
    	if (condtionNameArray.length>1){	
    		name.append(condtionNameArray[0]);
    		name.append(".");
    		name.append("`");
    		name.append(condtionNameArray[1]);
    		name.append("`");
    		nameArray[0]=name.toString();
    		nameArray[1]=condtionNameArray[1];
    	} else {
    		name.append("`");
    		name.append(condtionNameArray[0]);
    		name.append("`");
    		nameArray[0]=name.toString();
    		nameArray[1]=condtionName;
    	}
		return nameArray;
	}

	/**空where 语句.
	 * @return 返回对象本身
	 */
	public DslSql where() {
		selectSql.append(selectWhere);
		return this;
	}

	

	/**like 查询sql.
	 * @param column  查询列名  --对应数据库列名
	 * @param fieldValue  查询条件  --查询dto对应属性的值
	 * @param prefix  前百分号  --like查询的左百分号
	 * @param suffix  后百分号  --like查询的右百分号
	 * 
	 * @return  返回对象本身
	 */
	public DslSql likeAs(String column, String fieldValue, String prefix, String suffix){
		if (column.isEmpty() || fieldValue.isEmpty()){
			return this;
		}
		
		selectSql.append(" and ");
		selectWhere.append(getCondtionNameSql(column)[0]);
		selectSql.append(" like ");
		selectSql.append("'");
		if (!prefix.isEmpty()){
			selectSql.append(prefix);
		}
		selectSql.append(fieldValue.trim());
		if (!suffix.isEmpty()){
			selectSql.append(suffix);
		}
		selectSql.append("'");
	
		return this;
	}

	

	/**innerSql 查询.
	 * @param columnName  查询列名  --对应数据库列名
	 * @param innerSql    in关键字中的内部sql
	 * @return  返回对象本身
	 */
	public DslSql andInnerSql(String columnName, String innerSql) {
		
		if (columnName.isEmpty() || innerSql.isEmpty()){
			return this;
		}
		selectSql.append(" and ");
		selectSql.append(getCondtionNameSql(columnName)[0]);
		selectSql.append(" in ( ");
		selectSql.append(innerSql);
		selectSql.append(" ) ");
		
		return this;
	}
	
	/**not in 查询.
	 * @param columnName  查询列名  --对应数据库列名
	 * @param innerSql    in关键字中的内部sql
	 * @return  返回对象本身
	 */
	public DslSql andNotInnerSql(String columnName, String innerSql) {
		if (columnName.isEmpty() || innerSql.isEmpty()){
			return this;
		}
		selectSql.append(" and ");
		selectSql.append(getCondtionNameSql(columnName)[0]);
		selectSql.append(" not  in ( ");
		selectSql.append(innerSql);
		selectSql.append(" ) ");
		
		return this;
	}
	
	
	/**and查询条件定义.
	 * @param columnName  查询列名  --对应数据库列名
	 * @param fieldName   查询对应javabean的属性名
	 * @return  返回对象本身
	 */
	public DslSql and(String columnName, String fieldName) {
		
		if (columnName.isEmpty() || fieldName.isEmpty()){
			return  this;
		}
		
		selectSql.append(" and ");
		selectSql.append(getCondtionNameSql(columnName)[0]);
		selectSql.append(" = ");
		selectSql.append(getConditionValueSql(fieldName));
		
		return this;
	}
	
    /**分组语句.  
     * @param groupBy  分组条件
     * @return  返回对象本身
    */
	public DslSql groupBy(String groupBy) {
		selectSql.append(" group by ");
		selectSql.append(groupBy);
		return this;
	}

	/**排序语句.
	 * @param orderBy  排序条件
	* @return  返回对象本身
	 */
	public DslSql orderBy(String orderBy) {
		selectSql.append(" order by ");
		selectSql.append(orderBy);
		return this;
	}

	/**分页查询限定.
	 * @param page  分页对象
	 * @return  返回对象本身
	 */
	public DslSql limit(PageDto page) {
		if (page!=null && page.getStart()!=null && page.getLimit()!=null){
			selectSql.append(" limit ");
			selectSql.append((page.getStart()-1)*page.getLimit());
			selectSql.append(" , ");
			selectSql.append(page.getLimit());
			return this;
		} else if (page!=null && page.getPage()!=null && page.getRows()!=null){
			selectSql.append(" limit ");
			selectSql.append((page.getPage()-1)*page.getRows());
			selectSql.append(" , ");
			selectSql.append(page.getRows());
			return this;
		} else {
			return this;
		}
		
	}

	
	/**and大于与小于的范围比较.
	 * @param column      查询列名  --对应数据库列名
	 * @param startField  查询条件  --查询dto对应的属性名
	 * @param endField    查询条件  --查询dto对应的属性名
	 * @return  返回对象本身
	 */
	public DslSql andRange(String column, String startField, String endField) {
		if (column.isEmpty()){
			return  this;
		}
		String columnName=getCondtionNameSql(column)[0];
		if (!startField.isEmpty()){
			selectSql.append(" and  ");
			selectSql.append(columnName);
			selectSql.append(">=");
			selectSql.append(getConditionValueSql(startField));
		}
		
		if (!endField.isEmpty()){
			selectSql.append(" and  ");
			selectSql.append(columnName);
			selectSql.append("<=");
			selectSql.append(getConditionValueSql(endField));
		}
		
    	return this;
    }

	/**小于比较.
	 * @param column  查询列名  --对应数据库列名
	 * @param field  查询条件  --查询dto对应的属性名
	 * @return  返回对象本身
	 */
	public DslSql andLessThan(String column, String field){
		if (column.isEmpty()){
			return  this;
		}
		String columnName=getCondtionNameSql(column)[0];
		if (!field.isEmpty()){
			selectSql.append(" and  ");
			selectSql.append(columnName);
			selectSql.append("<=");
			selectSql.append(getConditionValueSql(field));
		}

    	return this;
	}
	
	
	/**大于比较.
	 * @param column  查询列名  --对应数据库列名
	 * @param field  查询条件  --查询dto对应的属性名
	 * @return  返回对象本身
	 */
	public DslSql andMoreThan(String column, String field){
		if (column.isEmpty()){
			return  this;
		}
		String columnName=getCondtionNameSql(column)[0];
		if (!field.isEmpty()){
			selectSql.append(" and  ");
			selectSql.append(columnName);
			selectSql.append(">=");
			selectSql.append(getConditionValueSql(field));
		}

    	return this;
	   
	}
	
	
	
	/**having的范围比较.
	 * @param column      查询列名  --对应数据库列名
	 * @param startField  查询条件  --查询dto对应的属性名
	 * @param endField    查询条件  --查询dto对应的属性名
	 * @return  返回对象本身
	 */
	public DslSql having(String column, String startField, String endField) {
    	
		if (column.isEmpty()){
			return  this;
		}
		String columnName=getCondtionNameSql(column)[0];
		if (!startField.isEmpty()){
			selectSql.append(" having  ");
			selectSql.append(columnName);
			selectSql.append(">=");
			selectSql.append(getConditionValueSql(startField));
		}
		
		if (!endField.isEmpty()){
			selectSql.append(" and  ");
			selectSql.append(columnName);
			selectSql.append("<=");
			selectSql.append(getConditionValueSql(endField));
		}
		
    	return this;
    }
	
	/**or 查询.
	 * @param fields 查询添加 or (condtion and conditon)
	 * @return  返回对象本身
	 */
	public DslSql or(String... fields) {
		if (fields == null ){
			return this;
		}
		StringBuilder or = new StringBuilder(" or (");
		for (String condtionName : fields) {
			String[] condtionNameArray=getCondtionNameSql(condtionName);
			or.append(" and ");
			or.append(condtionNameArray[0]);
			or.append("=");
			or.append(getConditionValueSql(condtionNameArray[1]));
			
		}
		or.append(" ) ");
		selectSql.append(selectWhere);
		selectSql.append(or);
		return this;
	}
	
	/**and自定义sql语句.
	 * @param condition 自定义sql
	 * @return  返回对象本身
	 */
	public DslSql andConditionSql(String condition) {
		selectSql.append(" and (");
		selectSql.append(condition);
		selectSql.append(" )");
		return this;
	}
	
	/**转换为sql语句.
	 * @return  返回对象本身
	 */
	public String toSql() {
		return selectSql.toString();
	}
	
	/**
	 * 查询sql 语句封装方法
	 * 查询sql 语句格式规范
	 * ------------end
	 */
	
}
