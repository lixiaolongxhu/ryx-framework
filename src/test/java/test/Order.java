package test;

import java.util.List;

public class Order {

	private String businessUuid;
	private String token;
	private String price;
	
	
	private List<OrderDetail> orderDetailList;

	private List<Object>  path;
	
	
	private String __cobertura_counters="1";
	
	
	
	

	

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
