package test;

import java.util.List;

public class Order {

	private String businessUuid;
	private String token;
	private String price;
	private int  test;
	private Integer  integerTest;
	
	private List<OrderDetail> orderDetailList;

	private List<Object>  path;
	
	
	private String __cobertura_counters="1";
	
	
	
	

	

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public Integer getIntegerTest() {
		return integerTest;
	}

	public void setIntegerTest(Integer integerTest) {
		this.integerTest = integerTest;
	}

	public String get__cobertura_counters() {
		return __cobertura_counters;
	}

	public void set__cobertura_counters(String __cobertura_counters) {
		this.__cobertura_counters = __cobertura_counters;
	}

	public List<Object> getPath() {
		return path;
	}

	public void setPath(List<Object> path) {
		this.path = path;
	}

	public String getBusinessUuid() {
		return businessUuid;
	}

	public void setBusinessUuid(String businessUuid) {
		this.businessUuid = businessUuid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
	
}
