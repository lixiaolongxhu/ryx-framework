package com.sample.mvc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.framework.core.dao.BasicDao;

import com.framework.core.dao.DslSql;
import com.framework.core.exception.BizException;

import com.sample.mvc.Entity.JsonTest;
import com.sample.mvc.Entity.User;
import com.sample.util.DateUtil;

@Service
public class TestService {
	
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
	
	private static final Logger LOG=LoggerFactory.getLogger(TestService.class);

	@SuppressWarnings("rawtypes")
	@Resource
	private BasicDao basicdao;
	@Resource
	private Test2Service  test2Service;

	public Integer insert(User user) {
		return basicdao.insert(user);
		
	}
	


	public void exception() {
		// TODO Auto-generated method stub
		throw new BizException("统一异常处理返回测试内容");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void tran(User user) {
		
		tran2(user);
		
		throw new BizException("异常回滚测试");
	}
	
	
	public void tran2(User user){
		basicdao.insert(user);
//		throw new BizException("异常回滚测试");
	}


//	//将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key
//	//通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值
	@Cacheable(value="basicCache", key="'selectCache'+#token")
		public List<User> selectCache(String token) {
		User select =new User();
		select.setToken(token);
		DslSql dslSql=new DslSql(select)
			.select("*")
			.from("user")
			.where("token")
			.orderBy(" createTime desc");
		
		@SuppressWarnings("unchecked")
		List<User> returnUser=basicdao.query(dslSql, User.class);
		return returnUser;
	}



		@SuppressWarnings("unchecked")
		public User queryOne() {
			User select =new User();
			//select.setUuid("2ecdd93b-2769-44c6-91ed-c269b8ea7782");
			DslSql dslSql=new DslSql(select)
				.select("*")
				.from("user")
				.where("uuid","token");
		
			User returnUser=(User) basicdao.queryOne(dslSql, User.class);
			return returnUser;
		}



		public User update() {
			User user=new User();
			
			user.setUpdateTime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
			basicdao.update(user, "uuid");
			return user;
		}



		public void insert(JsonTest json) {
			basicdao.insert(json);
			
		}



		public List<JsonTest> jsonS(JsonTest json) throws SQLException {
			 Connection conn = null;
			try {
				 
	            // 加载mysql驱动程序
	            Class.forName("com.mysql.jdbc.Driver");
	            // 连接localhost上的mysql,并指定使用test数据库，用户名为root,密码为***
	            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ryx?characterEncoding=utf8",
	                                               "root", "123456");
	            if (!conn.isClosed()) {
	                System.out.println("数据库连接成功！"); //验证是否连接成功
	            }
	 
	            Statement statement = conn.createStatement();
	            //查询数据
	            ResultSet rs = statement.executeQuery("select id,jsonStr,name from json_test");
	 
	            //输出结果集（类似.net中的DataSet/DataTable）
	            while (rs.next()) {
	                System.out.println("id=" + rs.getInt("id") + ",jsonStr=" +
	                                   rs.getString("jsonStr")+", name="+rs.getString("name"));
	            }
	            rs.close();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                    conn = null;
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	 
	    
			
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		
//			//建立连接
//		
//			java.sql.Connection   con=DriverManager.getConnection("localhost","root","123456");
//
//			 
////			try {
////				con = jdbcTemplate.getDataSource().getConnection();
////			} catch (SQLException e1) {
////				// TODO Auto-generated catch block
////				e1.printStackTrace();
////			}
//			String sql = "select * from json_test";
//			PreparedStatement pstmt;
//		    try {
//		        pstmt =  (PreparedStatement) con.prepareCall(sql)  ;
//		        ResultSet rs = pstmt.executeQuery();
//		        int col = rs.getMetaData().getColumnCount();
//		        System.out.println("============================");
//		        while (rs.next()) {
//		            for (int i = 1; i <= col; i++) {
//		                System.out.print(rs.getString(i) + "\t");
//		                if ((i == 2) && (rs.getString(i).length() < 8)) {
//		                    System.out.print("\t");
//		                }
//		             }
//		            System.out.println("");
//		        }
//		            System.out.println("============================");
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		    }
			
			
			DslSql dslSql=new DslSql("");
						dslSql.select("id,jsonStr,name")
						.from("json_test");
			List<JsonTest>   j=	basicdao.query(dslSql, JsonTest.class);		
						 LOG.debug("输出jsonStr =" +j.get(0).getJsonStr());
			return  null;
		}
	

}
