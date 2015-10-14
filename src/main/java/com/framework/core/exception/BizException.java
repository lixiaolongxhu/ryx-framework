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
	private String descr;
	private Integer code;
	
	public BizException(String descr){
		super(descr);
		this.code=ResultVo.RESPONSE_CODE_EXCEPTION;
		this.descr = descr;
	}
	
	public BizException(Integer code,String descr){
		super(descr);
		this.code=code;
		this.descr = descr;
	}
	
	public String getDescr() {
		return descr;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	
}
