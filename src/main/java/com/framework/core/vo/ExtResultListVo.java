package com.framework.core.vo;

import java.util.ArrayList;
import java.util.List;

/**扩展通用controllers只返回结果列表.
 * 
 * @param <T> 泛型
 * @author lixiaolong 
 *
 */
public class ExtResultListVo<T> {
	
	/**返回结果列表的对象.
	 * 
	 */
	private List<T> obj;
	
	
	/**默认构造函数.
	 * 
	 */
	public ExtResultListVo(){
		this.obj=new ArrayList<T>();
	}
	
	
	/**构造函数.
	 * 
	 * @param obj 传入需要返回列表对象
	 */
	public ExtResultListVo(List<T> obj){
		this.obj=obj;
	}
	

	/**get ,set 方法.
	 * 
	 * @return  get 返回
	 */
	public List<T> getObj() {
		return obj;
	}

	/**get,set 返回.
	 * 
	 * @param obj set 方法
	 */
	public void setObj(List<T> obj) {
		this.obj = obj;
	}
	

}
