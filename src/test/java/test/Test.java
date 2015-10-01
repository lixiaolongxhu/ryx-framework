package test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private static  final  Logger  LOG=LoggerFactory.getLogger(Test.class); 
	
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
	
		orders.setBusinessUuid("orders");

		Order order2 = new Order();
		OrderDetail od = new OrderDetail();
		OrderDetail od2 = new OrderDetail();
		od2.setBusinessUuid("orders2");
		BeanUtils.copyProperties(od, orders);
		System.out.println(od.getBusinessUuid());

		BeanUtils.copyProperties(order2, od2);

		System.out.println(order2.getBusinessUuid());

		Business b = new Business();

		BeanUtils.copyProperties(b, orders);

		System.out.println(b.getBusinessUuid());

		BeanUtils.copyProperties(b, od2);

		System.out.println(b.getBusinessUuid());
		
		System.out.println("输出获取指定对象的属性值 ： "+BeanUtils.getProperty(b, "businessUuid"));

		System.out.println("输出某对象的属性名以及属性所对应的值"+BeanUtils.describe(od2));;
	}

}
