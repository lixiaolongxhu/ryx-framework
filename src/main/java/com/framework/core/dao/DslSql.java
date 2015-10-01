package  com.framework.core.dao;

import java.lang.reflect.Field;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
///**
// * 自动生成sql工具类
// * (注意事项： 整型数据为0时，会判断为空；所以系统设计判断时，请从1开始)
// * @author lixiaolong
// *
// */
//public class DslSql {
//
//	private  static Logger  log=LoggerFactory.getLogger(DslSql.class);
//	
//	private  Object obj;
//	
//	private  String tableName = "";
//
//	private  StringBuilder sql = new StringBuilder();
//
//	private  StringBuilder where = new StringBuilder(" where 1=1");
//
//	private  String[] attributeName;
//	
//	private  Object[] attributeValue;
//	
//	private  String[] attributeType;
//	
//	/**
//	 * 生成javabean的mysql单表插入语句。
//	 * 
//	 * @param object
//	 *            要插入数据库单表对应的javabean。
//	 * @param generatedkeyName
//	 *            对应数据库自增长字段或者主键字段的名称。
//	 *            （如果存在多字段的组合主键，就选着其中一个字段作为generatedkeyName，
//	 *            同时isAddGeneratekey必须设置为true，即全表字段插入）。
//	 * @param isAddGeneratekey
//	 *            在插入数据时是否插入自增长字段或者主键：isAddGeneratekey=false表示不插入，
//	 *            isAddGeneratekey=true表示插入。
//	 *            （如果不是自增长的主键字段，isAddGeneratekey就必须设置为true）。
//	 * @return 返回对应的javabean插入sql语句，采用命名参数的格式。
//	 * @throws IllegalArgumentException
//	 * @throws IllegalAccessException
//	 */
//	public  String generateInsertSql(
//			String generatedkeyName, boolean isAddGeneratekey)
//			 {
//		
//		StringBuilder sql = new StringBuilder("");
//		sql.append(" insert into ");
//		sql.append(underscoreName(tableName));
//		sql.append(" (");
//	
//		for (int i = 0; i < attributeName.length; i++) {
//			if (isAddGeneratekey == false
//					&& ToolHelper.equalsString(generatedkeyName,
//							attributeName[i])) {
//				continue;
//			}
//			if (ToolHelper.isNotEmpty(attributeValue[i])) {
//				
//				sql.append(attributeName[i]);
//			
//				sql.append(",");
//			}
//		}
//		sql.deleteCharAt(sql.length() - 1);
//		sql.append(")");
//		sql.append(" values (");
//		for (int i = 0; i < attributeName.length; i++) {
//			if (isAddGeneratekey == false
//					&& ToolHelper.equalsString(generatedkeyName,
//							attributeName[i])) {
//				continue;
//			}
//			if (ToolHelper.isNotEmpty(attributeValue[i])) {
//				sql.append(":");
//				sql.append(attributeName[i]);
//				sql.append(",");
//			}
//
//		}
//		sql.deleteCharAt(sql.length() - 1);
//		sql.append(")");
//		return sql.toString();
//	}
//
//	/**
//	 * 生成javabean的mysql单表修改语句
//	 * 
//	 * @param object
//	 *            要修改数据库单表对应的javabean
//	 * @param conditionFieldName
//	 *            修改sql对应where后面的条件字段数组，各字段之间使用与运算
//	 * @return 返回对应的javabean修改sql语句，采用命名参数的格式
//	 * @throws IllegalArgumentException
//	 * @throws IllegalAccessException
//	 */
//	public  String generateUpdateSql(
//			String[] conditionFieldName){
//		
//		StringBuilder sql = new StringBuilder("");
//		sql.append(" update ");
//		sql.append(underscoreName(tableName));
//		sql.append(" set ");
//		
//		for (int i = 0; i < attributeName.length; i++) {
//			if (ToolHelper.isNotEmpty(attributeValue[i])
//					&& !attributeValue[i].toString().equals("0")) {
//				
//				sql.append(attributeName[i]);
//				
//				sql.append("=");
//				sql.append(":");
//				sql.append(attributeName[i]);
//				sql.append(",");
//			}
//		}
//		sql.deleteCharAt(sql.length() - 1);
//		sql.append(" where ");
//		for (int i = 0; i < conditionFieldName.length; i++) {
//			if (i != 0) {
//				sql.append(" and ");
//			}
//			sql.append(conditionFieldName[i]);
//			sql.append("=:");
//			sql.append(conditionFieldName[i]);
//
//		}
//		return sql.toString();
//	}
//
//	/**
//	 * 生成javabean的mysql单表删除语句
//	 * 
//	 * @param object
//	 *            要删除数据库单表对应的javabean
//	 * @param conditionFieldName
//	 *            删除sql对应where后面的条件字段数组，各个字段之间使用与运算
//	 * @return 返回对应javabean删除的sql语句，采用命令参数的格式
//	 * @throws IllegalArgumentException
//	 * @throws IllegalAccessException
//	 */
//	public  String generateDeleteSql(Object object,
//			String[] conditionFieldName) {
//		StringBuilder sql = new StringBuilder("");
//		sql.append(" delete from  ");
//		sql.append(underscoreName(tableName));
//		sql.append(" where  ");
//		for (int i = 0; i < conditionFieldName.length; i++) {
//			if (i != 0) {
//				sql.append(" and ");
//			}
//			sql.append(conditionFieldName[i]);
//			sql.append("=:");
//			sql.append(conditionFieldName[i]);
//		}
//		return sql.toString();
//
//	}
//
//	
//	/**
//	 * 查询sql 语句封装方法
//	 * 查询sql 语句格式规范
//	 * ---beign
//	 * @throws IllegalAccessException 
//	 * @throws IllegalArgumentException 
//	 */
//	public DslSql(Object obj)  {
//		
//        if(obj!=null){
//        	try {
//    			setClassAttribute(obj);
//    		} catch (IllegalArgumentException | IllegalAccessException e) {
//    			e.printStackTrace();
//    			log.error(ExceptionUtil.getExceptionDetail(e, "DslSql()生成sql语句时；获取类对象属性值出现异常！"));
//    		}
//    		
//    		String className = obj.getClass().getSimpleName();
//    		this.tableName = underscoreName(StringUtils.uncapitalize(className));
//        }
//		
//		this.obj = obj;
//	}
//
//	public DslSql(String table, Object obj) {
//		
//		if(obj!=null){
//			try {
//				setClassAttribute(obj);
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				e.printStackTrace();
//				log.error(ExceptionUtil.getExceptionDetail(e, "DslSql()生成sql语句时；获取类对象属性值出现异常！"));
//			}
//			
//			this.tableName = underscoreName(StringUtils.uncapitalize(table));
//		}
//		
//		this.obj = obj;
//	}
//	
//	public DslSql() {
//		this.obj = obj;
//	}
//	
//	/**
//	 * 设置类属性名，属性值，属性类型等信息
//	 * @param obj
//	 * @throws IllegalAccessException 
//	 * @throws IllegalArgumentException 
//	 */
//	private  void setClassAttribute(Object obj) throws IllegalArgumentException, IllegalAccessException{
//		
//		if(obj==null){
//			return;
//		}
//		
//		// 获取属性
//		Map< String, Field > map = BeanUtil.getClassFields(obj.getClass ( ), true );
//		
//		attributeName=new String[map.size()];	
//		attributeValue=new Object[map.size()];
//		attributeType=new  String[map.size()];
//		
//		int i=0;
//		for ( Object key : map.keySet ( ) ){
//			if(ToolHelper.equalsString(map.get(key).getName(), "__cobertura_counters")){
//				//移除maven 覆盖单元测试率注入的字段
//				continue;
//			}
//			attributeName[i]=map.get(key).getName();
//			attributeValue[i]=map.get(key).get(obj);
//			attributeType[i]=map.get(key).getType().toString();
//			
//			i++;
//		}
//	}
//	
//	
//	public DslSql select(String select) {
//		sql.append(" select  " + select);
//		return this;
//	}
//
//	public DslSql from(String tableName) {
//		sql.append(" from " + tableName);
//		return this;
//	}
//
//	/**
//	 * 内连接
//	 * @param table
//	 * @return
//	 */
//	public DslSql innerJoin(String table) {
//		sql.append(" inner join " + underscoreName(table));
//		return this;
//	}
//	
//	/**
//	 * 左连接
//	 * @param table
//	 * @return
//	 */
//	public DslSql leftJoin(String table) {
//		sql.append(" left join " + underscoreName(table));
//		return this;
//	}
//
//	/**
//	 * 右连接
//	 * @param table
//	 * @return
//	 */
//	public DslSql rightJoin(String table) {
//		sql.append(" right join " + underscoreName(table));
//		return this;
//	}
//	
//	/**
//	 * 连接查询 on
//	 * @param on
//	 * @return
//	 */
//	public DslSql on(String on) {
////		sql.append(" on " + underscoreName(on));
//		sql.append(" on " +on);
//		return this;
//	}
//
//	/**
//	 * where查询
//	 * @param fields
//	 * @return
//	 */
//	public DslSql where(String... fields) {
//
//		for (String field : fields) {
//			String[] f = field.split("\\.");
//			String _field = f.length > 1 ? f[1] : field;
//			
//			String columnName = f.length>1?(f[0]+".`"+f[1]+"`"):"`"+field.trim()+"`";
//			for (int i = 0; i < attributeName.length; i++) {
//				//如何整行数据为0，则判断为空
//				if(attributeType[i]!=null && (ToolHelper.equalsString("int", attributeType[i]) &&  attributeValue[i]!=null && ToolHelper.equalsString("0", attributeValue[i].toString()) )){
//					attributeValue[i]=null;
//				}
//				if (ToolHelper.equalsString(_field, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					where.append(" and " + columnName.trim() + "=:" + _field.trim());
//					break;
//				}
//			}
//
//		}
//		sql.append(where);
//		return this;
//	}
//	
//	/**
//	 * 空where 语句
//	 * @return
//	 */
//	public DslSql where() {
//		sql.append(where);
//		return this;
//	}
//
//	/**
//	 * 
//	 * @param prefix  前百分号
//	 * @param Suffix  后百分号
//	 * @param fields  查询条件
//	 * @return
//	 */
//	@Deprecated
//	public DslSql like(String... fields) {
//		
//		boolean dynamicWhere = false;
//		StringBuilder or = new StringBuilder(" and ( ");
//		
//		for (String field : fields) {
//
//			String[] f = field.split("\\.");
//			String _field = f.length > 1 ? f[1] : field;
//			String columnName = f.length>1?(f[0]+".`"+f[1]+"`"):"`"+field+"`";
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(_field, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					or.append("  " + columnName + " like :" + _field+"  and ");
//					dynamicWhere = true;
//					break;
//				}
//			}
//			
//			
//		}
//		if (dynamicWhere) {
//			int len = or.length();
//			or.delete(len - 4, len);
//			or.append(")");
//			sql.append(or);
//		}
//		return this;
//		
//
//	}
//
//	/**
//	 * @param column  查询列名  --对应数据库列名
//	 * @param fields  查询条件  --查询dto对应属性的值
//	 * @param prefix  前百分号  --like查询的左百分号
//	 * @param Suffix  后百分号  --like查询的右百分号
//	 * 
//	 * @return
//	 */
//	public DslSql likeAs(String column, String fieldValue,String prefix,String suffix){
//		if(ToolHelper.isEmpty(column)){
//			return this;
//		}
//		if(ToolHelper.isNotEmpty(column)){
//			for (int i = 0; i < attributeName.length; i++) {
//				if(ToolHelper.isNotEmpty(fieldValue)){
//					sql.append(" and ");
//					sql.append(column.trim());
//					sql.append(" like ");
//					sql.append("'");
//					if(ToolHelper.isNotEmpty(prefix)){
//						sql.append(prefix);
//					}
//					sql.append(fieldValue.trim());
//					if(ToolHelper.isNotEmpty(suffix)){
//						sql.append(suffix);
//					}
//					sql.append("'");
//					break;
//				}
//			}
//		}
//		return this;
//	}
//
//	/**
//	 * or 查询
//	 * @param fields
//	 * @return
//	 */
//	public DslSql or(String... fields) {
//		boolean dynamicWhere = false;
//		StringBuilder or = new StringBuilder(" or (");
//		for (String field : fields) {
//
//			
//			String[] f = field.split("\\.");
//			String _field = f.length > 1 ? f[1] : field;
//			String columnName = f.length>1?(f[0]+".`"+f[1]+"`"):"`"+field+"`";
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(_field, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					where.append(" and " + columnName + "=:" + _field);
//					break;
//				}
//			}
//			
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(_field, attributeName[i])) {
//					or.append("  " + attributeName[i] + "=:" + _field+"  or ");
//					dynamicWhere = true;
//					break;
//				}
//			}
//			
//			
//		}
//		if (dynamicWhere) {
//			int len = or.length();
//			or.delete(len - 4, len);
//			or.append(")");
//			sql.append(or);
//		}
//		return this;
//	}
//
//	/**
//	 *  and  in  查询
//	 * @param column  查询列名  --对应数据库列名
//	 * @param field   查询dto对应的属性名
//	 * @return
//	 */
//	public DslSql andIn(String column, String field) {
//		if(ToolHelper.isEmpty(column)){
//			return this;
//		}
//		if(ToolHelper.isEmpty(field)){
//			return this;
//		}
//		
//		if(ToolHelper.isNotEmpty(field)){
//			sql.append(" and `" + column + "` in (" + field + ")");
//		}
//		return this;
//	}
//
//	/**
//	 * not in  sql 查询
//	 * @param column  查询列名  --对应数据库列名
//	 * @param field   查询dto对应的属性名
//	 * @return
//	 */
//	public DslSql andInnerSql(String column, String field) {
//		
//		if(ToolHelper.isEmpty(column)){
//			return this;
//		}
//		if(ToolHelper.isEmpty(field)){
//			return this;
//		}
//		
//		String[] f = column.split("\\.");
//		String columnName = f.length > 1 ? (f[0] + ".`" + f[1] + "`")
//				: "`" + column + "`";
//
//		sql.append(" and " + columnName + " in (" + field + ")");
//		return this;
//	}
//
//	/**
//	 * not in 查询
//	 * @param column  查询列名  --对应数据库列名
//	 * @param field   查询dto对应的属性名
//	 * @return
//	 */
//	public DslSql andNotInSql(String column, String field) {
//		if(ToolHelper.isEmpty(column)){
//			return this;
//		}
//		if(ToolHelper.isEmpty(field)){
//			return this;
//		}
//		sql.append(" and " + column+ " not in (" + field + ")");
//		return this;
//	}
//
//	/**
//	 * and自定义sql语句
//	 * @param condition
//	 * @return
//	 */
//	public DslSql andConditionSql(String condition) {
//		sql.append(" and (" + condition);
//		sql.append(" )");
//		return this;
//	}
//
//	/**
//	 * and查询条件定义
//	 * @param column  查询列名  --对应数据库列名
//	 * @param field   查询dto对应的属性名
//	 * @return
//	 */
//	public DslSql and(String column, String field) {
//		if(ToolHelper.isEmpty(column)){
//			return  this;
//		}
//		
//		if(ToolHelper.isNotEmpty(field)){
//			
//			String[] f = field.split("\\.");
//			String _field = f.length > 1 ? f[1] : field;
//			
////			String columnName = f.length>1?(f[0]+".`"+f[1]+"`"):"`"+field.trim()+"`";
//			for (int i = 0; i < attributeName.length; i++) {
//				//如何整行数据为0，则判断为空
//				if(attributeType[i]!=null && (ToolHelper.equalsString("int", attributeType[i]) &&  attributeValue[i]!=null && ToolHelper.equalsString("0", attributeValue[i].toString()) )){
//					attributeValue[i]=null;
//				}
//				if (ToolHelper.equalsString(_field, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					sql.append(" and " + column.trim() + "=:" + _field.trim());
//					break;
//				}
//			}
//			
//		}
//		return this;
//	}
//	
//    /**
//     * 分组语句
//     * @param groupBy
//     * @return
//     */
//	public DslSql groupBy(String groupBy) {
//		sql.append(" group by " + groupBy);
//		return this;
//	}
//    
//	/**
//	 * 排序语句
//	 * @param orderBy
//	 * @return
//	 */
//	public DslSql orderBy(String orderBy) {
//		sql.append(" order by " + orderBy);
//		return this;
//	}
//
//	/**
//	 * 分页查询限定
//	 * @param page
//	 * @return
//	 */
//	public DslSql limit(PageDto page) {
//		if(page!=null && page.getStart()!=null && ToolHelper.isNotEmpty(page.getLimit())){
//			sql.append(" limit ");
//			sql.append((page.getStart()-1)*page.getLimit());
//			sql.append(" , ");
//			sql.append(page.getLimit());
//			return this;
//		}else  if(page!=null && page.getPage()!=null && ToolHelper.isNotEmpty(page.getRows())){
//			sql.append(" limit ");
//			sql.append((page.getPage()-1)*page.getRows());
//			sql.append(" , ");
//			sql.append(page.getRows());
//			return this;
//		}else{
//			return this;
//		}
//		
//	}
//
//	/**
//	 * having的范围比较
//	 * @param column      查询列名  --对应数据库列名
//	 * @param startField  查询条件  --查询dto对应的属性名
//	 * @param endField    查询条件  --查询dto对应的属性名
//	 * @return
//	 */
//	public DslSql having(String column,String startField,String endField) {
//    	
//		if(ToolHelper.isEmpty(column)){
//			return  this;
//		}
//		
//		if(ToolHelper.isNotEmpty(startField)){
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(startField, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					sql.append(" having  " + column + ">=:" + startField);
//					break;
//				}
//			}
//			
//		}
//		
//		if(ToolHelper.isNotEmpty(endField)){
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(endField, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					sql.append(" and  " + column+ "<:" + endField+" ");
//					break;
//				}
//			}
//		}
//    	return this;
//    }
//	
//	/**
//	 * and大于与小于的范围比较
//	 * @param column      查询列名  --对应数据库列名
//	 * @param startField  查询条件  --查询dto对应的属性名
//	 * @param endField    查询条件  --查询dto对应的属性名
//	 * @return
//	 */
//	public DslSql andRange(String column,String startField,String endField) {
//		if(ToolHelper.isEmpty(column)){
//			return  this;
//		}
//		
//		if(ToolHelper.isNotEmpty(startField)){
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(startField, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					sql.append(" and  " + column + ">=:" + startField);
//					break;
//				}
//			}
//			
//		}
//		
//		if(ToolHelper.isNotEmpty(endField)){
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(endField, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					sql.append(" and  " + column + "<=:" + endField);
//					break;
//				}
//			}
//		}
//		
//    	return this;
//    }
//
//	/**
//	 * 小于比较
//	 * @param column  查询列名  --对应数据库列名
//	 * @param field  查询条件  --查询dto对应的属性名
//	 * @return
//	 */
//	public DslSql andLessThan(String column,String field){
//		if(ToolHelper.isEmpty(column)){
//			return this;
//		}
//		if(ToolHelper.isNotEmpty(field)){
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(field, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					sql.append(" and " + column +"<=:" + field);
//					break;
//				}
//			}
//		}
//	    return this;
//	}
//	
//	
//	/**
//	 * 大于比较
//	 * @param column  查询列名  --对应数据库列名
//	 * @param field  查询条件  --查询dto对应的属性名
//	 * @return
//	 */
//	public DslSql andMoreThan(String column,String field){
//		if(ToolHelper.isEmpty(column)){
//			return this;
//		}
//		if(ToolHelper.isNotEmpty(field)){
//			for (int i = 0; i < attributeName.length; i++) {
//				if (ToolHelper.equalsString(field, attributeName[i])  &&  ToolHelper.isNotEmpty(attributeValue[i]) ) {
//					sql.append(" and " + column +">=:" + field);
//					break;
//				}
//			}
//		}
//	    return this;
//	}
//	
//	/**
//	 * 转换为sql语句
//	 * @return
//	 */
//	public String toSql() {
//		return sql.toString();
//	}
//	
//	/**
//	 * 查询sql 语句封装方法
//	 * 查询sql 语句格式规范
//	 * ------------end
//	 */
//	
//	
//	/**
//	 * 进行类名与数据库表名转换
//	 * 规则： 类名 UserRoleLink--- 表名   user_role_link
//	 * @param name
//	 * @return
//	 */
//	public static String underscoreName(String name) {
//		
//		StringBuilder result = new StringBuilder();
//
//		for (char letter : name.toCharArray()) {
//			if (Character.isUpperCase(letter)) {
//				result.append("_");
//				result.append(String.valueOf(letter).toLowerCase());
//			} else {
//				result.append(letter);
//			}
//		}
//
//		return result.toString();
//	}
//
//	
//	/**
//	 * 测试方法
//	 * @param args
//	 * @throws IllegalAccessException
//	 * @throws IllegalArgumentException
//	 */
//	public static void main(String[] args) throws IllegalArgumentException,
//			IllegalAccessException {
//		
//		TestSearchDto  testSearch=  new TestSearchDto();
//		testSearch.setUserName("用户名");
//		testSearch.setPage(11);
//		// 获取属性
//				Map< String, Field > map = BeanUtil.getClassFields(testSearch.getClass ( ), true );
//				
//			String[]	attributeName=new String[map.size()];	
//			Object[]	attributeValue=new Object[map.size()];
//			String[]	attributeType=new  String[map.size()];
//				
//				int i=0;
//				for ( Object key : map.keySet ( ) ){
//					if(ToolHelper.equalsString(map.get(key).getName(), "__cobertura_counters")){
//						//移除maven 覆盖单元测试率注入的字段
//						continue;
//					}
//					attributeName[i]=map.get(key).getName();
//					attributeValue[i]=map.get(key).get(testSearch);
//					attributeType[i]=map.get(key).getType().toString();
//					
//					i++;
//				}
//		
//		
//		String  sql=new DslSql(new TestSearchDto())
//		.select(" select username ,idCard  ")
//		.from(" TestModel  table1")
//		.leftJoin("  table2 as table2" ).on(" table1.uudi=table2.uuid ")
//		.where("username","idCard")
//		.orderBy("username  desc ")
////		.limit(1,10)
//		.toSql();
//		
//		System.out.println("querysql:  "+ sql) ;
//		
////		TestModel  testModel=new TestModel();
////		testModel.setIdCard("243241341341");
////		testModel.setUserName("lixiaolong");
////		System.out.println("generateInsertSql: "+new DslSql(testModel).generateInsertSql( "", false));
////		
////		String[] conditionName=new String[1];
////		conditionName[0]="userName";
////		System.out.println("generateUpdateSql: "+new DslSql(testModel).generateUpdateSql( conditionName));
////		
////		System.out.println("generateDeleteSql: "+new DslSql(testModel).generateDeleteSql(testModel, conditionName));
////		
//		
//	}
//	
//	
//	
//}
