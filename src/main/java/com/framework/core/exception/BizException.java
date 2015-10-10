package com.framework.core.exception;




/**自定义(运行时)业务异常.
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午9:23:57
 */
public class BizException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3531241910349398696L;
	private String descr;
	
	public BizException(String descr){
		
//		super(Const.ResponseStatusCode.BIZEXCEPTION);
		this.descr = descr;
	}
	
	public BizException(String code,String descr){
		
		super(code);
		this.descr = descr;
	}
	
	public String getDescr() {
		return descr;
	}

}
