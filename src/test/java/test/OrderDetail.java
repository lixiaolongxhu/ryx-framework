package test;

import java.util.List;

public class OrderDetail {

	private String merUuid;
	private String actualPrice;
	private String number;
	
	private String businessUuid;
	private String token;
	private String price;
	
	
	private List<OrderDetail> orderDetailList;

	private List<Object>  path;
	
	
	
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
	public List<Object> getPath() {
		return path;
	}
	public void setPath(List<Object> path) {
		this.path = path;
	}
	public String getMerUuid() {
		return merUuid;
	}
	public void setMerUuid(String merUuid) {
		this.merUuid = merUuid;
	}
	public String getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(String actualPrice) {
		this.actualPrice = actualPrice;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
