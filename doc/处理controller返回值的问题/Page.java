package cn.riyouxi.mvc.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**分页参数父类.
 * @author lixiaolong
 * @param <T>
 * @version datetime：2015年8月10日  下午2:06:59
 */
public class Page<T> implements Serializable {
	public static final long serialVersionUID = -5904499691324692927L;
	public List<T> rows = new ArrayList<T>();
	public int total;
	public String status;
	public String msg;
	
	public Page(List<T> rows, int total) {
		this.rows = rows;
		this.total = total;
	}
	
	public final String getStatus() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
