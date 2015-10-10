package com.framework.core.exception;


/**
 * 自定义错误信息内容与格式
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午11:29:44
 */
public class BizError {
	
	private String  status;
	private String  msg;
	private Object  r;
	
	public BizError(String status, String msg,Object obj) {
		super();
		this.status = status;	
		this.msg = msg;
		r=obj;
	}
	


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}



	public Object getR() {
		return r;
	}



	public void setR(Object r) {
		this.r = r;
	}
     
	


	
	
	
	
	

}
