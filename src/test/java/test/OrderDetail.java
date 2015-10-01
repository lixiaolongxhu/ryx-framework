package test;

public class OrderDetail  extends Order{

	private String merUuid;
	private String actualPrice;
	private String number;
	
	
	
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
