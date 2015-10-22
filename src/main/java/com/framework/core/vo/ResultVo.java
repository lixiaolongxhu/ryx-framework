package com.framework.core.vo;

import java.io.Serializable;

/**统一Controller返回对象.
 * @author lixiaolong
 * @version datetime：2015年9月25日  上午10:01:59
 */
public class ResultVo  implements Serializable{

	/**序列化.
	 * 
	 */
	private static final long serialVersionUID = -3349595823350546669L;

	/**返回业务数据.
	 * 
	 */
	private  Object r;
	
	/**返回信息注解.
	 * 
	 */
	private  String msg;
	
	/**返回的状态码.
	 * 
	 */
	private  Integer status;
	
	/**请求响应成功.
	 */
	public static final Integer RESPONSE_CODE_OK=0;
	
	/**请求响应未登录.
	 */
	public static final Integer RESPONSE_CODE_NO_LOGIN=-1;
	
	/**请求响应用户名或密码错误.
	 * 
	 */
	public static final Integer RESPONSE_CODE_LOGIN_FAILURE=-2;
	/**请求响应当前用户无操作该功能权限.
	 * 
	 */
	public static final Integer RESPONSE_CODE_NO_PERMISSION=-3;
	
	/**请求响应当前请求参数错误.
	 */
	public static final Integer RESPONSE_CODE_PARAMETER_ERROR=-4;
	
	/**用户操作出现不合法的情况或者异常.
	 */
	public static final Integer RESPONSE_CODE_EXCEPTION=-5;
	

	/**默认构造函数，返回空.
	 * 
	 */
	public   ResultVo(){
		this.status = RESPONSE_CODE_OK;
		this.r = new Object();
		this.msg = "请求成功，返回空数据!";
	}
	
	/**返回业务数据构造函数，其他状态默认.
	 * 
	 * @param r 业务数据
	 */
	public ResultVo(Object r){
		this.status = RESPONSE_CODE_OK;
		this.msg = "请求成功，返回业务数据!";
		this.r = r;
	}
	
	/**返回业务数据以及信息备注的构造函数；其他默认.
	 * 
	 * @param r  业务数据
	 * @param msg  业务数据的备注信息
	 */
	public ResultVo(Object r, String msg){
		this.status = RESPONSE_CODE_OK;
		this.msg = msg;
		this.r = r;
	}
	
	/**全信息构造函数返回.
	 * 
	 * @param r    业务数据
	 * @param msg   业务数据备注
	 * @param status  返回的状态值
	 */
	public  ResultVo(Object r, Integer status, String msg){
		this.status = status;
		this.msg = msg;
		this.r = r;
	}
	
	/**返回业务数据，以及状态值对应的信息.
	 * 
	 * @param r    业务数据
	 * @param status  返回的状态值
	 */
	public  ResultVo(Object r, Integer status){
		this.r = r;
		this.status = status;
		if (status == RESPONSE_CODE_OK){
			this.msg = "请求响应成功";
		} else if (status == RESPONSE_CODE_NO_LOGIN) {
			this.msg = "请求响应未登录";
		} else if (status == RESPONSE_CODE_LOGIN_FAILURE) {
			this.msg = "请求响应用户名或密码错误";
		} else if (status == RESPONSE_CODE_NO_PERMISSION) {
			this.msg = "请求响应当前用户无操作该功能权限";
		} else if (status == RESPONSE_CODE_PARAMETER_ERROR) {
			this.msg = "请求响应当前请求参数错误";
		} else {
			this.msg = "用户操作出现不合法的情况或者异常";
		}
		
	}

	/**get set 方法.
	 * 
	 * @return get set 方法
	 */
	public Object getR() {
		return r;
	}

	/**get set 方法.
	 * 
	 * @param r get set 方法
	 */
	public void setR(Object r) {
		this.r = r;
	}

	/**get set 方法.
	 * 
	 * @return  get set 方法
	 */
	public String getMsg() {
		return msg;
	}

	/**get set 方法.
	 * 
	 * @param msg get set 方法
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**get set 方法.
	 * 
	 * @return get set 方法
	 */
	public Integer getStatus() {
		return status;
	}

	/**get set 方法.
	 * 
	 * @param status get set 方法
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
