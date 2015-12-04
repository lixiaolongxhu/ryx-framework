package com.framework.core.vo;

/**统一返回controllers对象扩展只返回对象.
 * 
 * @param <T> 泛型
 * @author lixiaolong
 *
 */
public class ExtResultVo<T> {
	
	/**待返回的对象.
	 * 
	 */
	private T  obj;
	
	/**默认构造函数.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ExtResultVo(){
		this.obj=(T) new Object();
	}
	
	
	/**构造函数.
	 * 
	 * @param obj 传入需要返回对象
	 */
	public  ExtResultVo(T obj){
		this.obj=obj;
	}
	

	/**get ,set 返回.
	 * 
	 * @return get返回
	 */
	public T getObj() {
		return obj;
	}

	/**get,set 方法.
	 * 
	 * @param obj set 方法
	 */ 
	public void setObj(T obj) {
		this.obj = obj;
	}

	
}
