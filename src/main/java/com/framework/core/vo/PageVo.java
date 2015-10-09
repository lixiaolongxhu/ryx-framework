package com.framework.core.vo;

import java.util.ArrayList;
import java.util.List;
/**分页传出参数.
 * @author lixiaolong
 * @version datetime：2015年10月9日  下午2:19:20
 */
public class PageVo {

	
	/**返回的结果集.
	 * 
	 */
	public List<Object> rows = new ArrayList<Object>();
	
	/**记录总条数.
	 * 
	 */
	public Integer total;
	
	/**默认构造函数.
	 * 
	 * @param rows  返回的结果集
	 * @param total  记录总条数
	 */
	public PageVo(List<Object> rows, Integer total) {
		if (rows==null){
			this.rows=new ArrayList<Object>();
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
	public List<Object> getRows() {
		return rows;
	}

	/**设置返回结果集.
	 * 
	 * @param rows  设置返回结果集
	 */
	public void setRows(List<Object> rows) {
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
