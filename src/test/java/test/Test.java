package test;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanMap;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import com.alibaba.fastjson.JSON;
import com.framework.core.dao.DslSql;
import com.framework.core.vo.ResultVo;

public class Test {

	private static  final  Logger  LOG=LoggerFactory.getLogger(Test.class); 
	
	private static int i;
	private int i2;
	
	public static void testd(){
//		i2=2;
//		int i3;
//		TransactionProxyFactoryBean.class
//		JdkDynamicAopProxy.class;
		
//		ProxyFactoryBean
		
//		JdbcTemplate.class
		
//		KeyGenerator 
//		@Caching
//	    Cache 
		
//		MapperScannerConfigurer
	}
	
	
	/**
	 * 
	 * @param args
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		
		LOG.debug("日志输出测试");
		
		Order orders = new Order();
	
		orders.setBusinessUuid("businessUuid4234324");

		Order order2 = new Order();
		
		OrderDetail od2 = new OrderDetail();
		od2.setBusinessUuid("orders2");
		
		
		
		 
          BeanMap  m = BeanMap.create(orders);  
  
          System.out.println("输出对象m全部属性： "+ m);
          System.out.println("输出对应属性的值： "+m.get("businessUuid"));  
          System.out.println("输出属性类型：" +m.getPropertyType("businessUuid").getSimpleName());
          System.out.println("输出属性类型：" +m.getPropertyType("test").getSimpleName());
          System.out.println("输出属性类型：" +m.getPropertyType("integerTest").getSimpleName());
          BeanMap  objBeanMap = BeanMap.create(orders); 
          Set<String> keySet=objBeanMap.keySet();
          for (String key : keySet) {
       	      System.out.println(key);
          } 
          
          //          m.clear();
          OrderDetail od = new OrderDetail();
        
          BeanCopier b = BeanCopier.create(OrderDetail.class, Order.class, false);  
       
        
//         b.copy(orders, od, null);  
//         
//		System.out.println("输出复制拷贝后的值 ："+od.getBusinessUuid());

	
//		BeanUtils.copyProperties(order2, od2);

//		System.out.println(order2.getBusinessUuid());
//
//		Business b = new Business();
//
//		BeanUtils.copyProperties(b, orders);
//
//		System.out.println(b.getBusinessUuid());
//
//		BeanUtils.copyProperties(b, od2);
//
//		System.out.println(b.getBusinessUuid());
//		
//		System.out.println("输出获取指定对象的属性值 ： "+BeanUtils.getProperty(b, "businessUuid"));
//
//		System.out.println("输出某对象的属性名以及属性所对应的值"+BeanUtils.describe(od2));;
//		
//		System.out.println(""+BeanUtils.setCacheFast(map, fast););
          
          System.out.println("测试dslsql:  "+new DslSql(orders).select(" uuid ").from(" order ") .where("businessUuid").toSql());
          System.out.println("测试dslsql:  "+new DslSql(orders).generateInsertSql());
	
          ResultVo  result=new ResultVo("", ResultVo.RESPONSE_CODE_EXCEPTION, "操作返回对象非框架定义的对象或其子类");
          
          
          System.out.println(JSON.toJSONString(result));
          
          System.out.println(JSON.toJSONString(orders));
//          
//          int i;
//          System.out.println(i);
	}

}
