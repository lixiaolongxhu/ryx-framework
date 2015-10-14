package com.framework.core.exception;

import com.framework.core.vo.ResultVo;

/**自定义(运行时)业务异常.
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午9:23:57
 */
public class BizException extends RuntimeException {


	/**序列号.
	 * 
	 */
	private static final long serialVersionUID = -6596918142750632880L;
	
	/**异常内容.
	 * 
	 */
	private String descr;
	
	/**异常码.
	 * 
	 */
	private Integer code;
	
	/**构造函数.
	 * 
	 * @param descr  异常内容
	 */
	public BizException(String descr){
		super(descr);
		this.code=ResultVo.RESPONSE_CODE_EXCEPTION;
		this.descr = descr;
	}
	
	/**构造函数.
	 * 
	 * @param code  异常码
	 * @param descr  异常内容
	 */
	public BizException(Integer code, String descr){
		super(descr);
		this.code=code;
		this.descr = descr;
	}
	
	/**get set 方法.
	 * 
	 * @return  get set 方法
	 */
	public String getDescr() {
		return descr;
	}

	
	/**get set 方法.
	 * 
	 * @return  get set 方法
	 */
	public Integer getCode() {
		return code;
	}

	/**get set 方法.
	 * 
	 * @param code  get set 方法.
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	
	/**get set 方法.
	 * 
	 * @param descr get set 方法.
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	
}
