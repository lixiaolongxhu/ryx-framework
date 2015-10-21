package com.framework.core.vo;

import java.util.ArrayList;
import java.util.List;
/**分页传出参数.
 * @author lixiaolong
 * @version datetime：2015年10月9日  下午2:19:20
 */
public class PageVo<T> {

	
	/**返回的结果集.
	 * 
	 */
	public List<T> rows = new ArrayList<T>();
	
	/**记录总条数.
	 * 
	 */
	public Integer total;
	
	/**默认构造函数.
	 * 
	 * @param rows  返回的结果集
	 * @param total  记录总条数
	 */
	public PageVo(List<T> rows, Integer total) {
		if (rows==null){
			this.rows=new ArrayList<T>();
		} else {
			this.rows = rows;
		}
		if (total==null){
		 	total=0;
		} else {
			this.total = total;
		}
		
	}

	/**结果集.
	 * 
	 * @return  返回结果集
	 */
	public List<T> getRows() {
		return rows;
	}

	/**设置返回结果集.
	 * 
	 * @param rows  设置返回结果集
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	/**总记录数.
	 * 
	 * @return 总记录数
	 */
	public Integer getTotal() {
		return total;
	}

	/**设置记录总数.
	 * 
	 * @param total  设置记录总数
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
	
	
}
