package com.framework.core.dto;

/**分页传参数.
 * @author lixiaolong
 * @version datetime：2015年10月8日  下午4:16:47
 */
public class PageDto {
	/**第一组  查询的第几页.
	 * 
	 */
	public Integer start;
	/**第一组 每页查询尺寸.
	 * 
	 */
	public Integer limit;

	/**第二组  查询的第几页.
	 * 
	 */
	public Integer page;
	/**第二组 每页查询尺寸.
	 * 
	 */
	public Integer rows;
	
  	
	/**get  set 方法.
	 * 
	 * @return 返回get set 对应属性
	 */
	public Integer getStart() {
		return start;
	}

	/**get  set 方法.
	 * @param  start  参数
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**get  set 方法.
	 * 
	 * @return 返回get set 对应属性
	 */
	public Integer getLimit() {
		return limit;
	}
	
	/**get  set 方法.
	 * @param  limit  参数
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**get  set 方法.
	 * 
	 * @return 返回get set 对应属性
	 */
	public Integer getPage() {
		return page;
	}

	/**get  set 方法.
	 * @param  page  参数
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**get  set 方法.
	 * 
	 * @return 返回get set 对应属性
	 */
	public Integer getRows() {
		return rows;
	}

	/**get  set 方法.
	 * @param  rows  参数 
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
