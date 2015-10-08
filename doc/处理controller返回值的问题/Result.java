package test;

/**统一Controller返回对象.
 * @author lixiaolong
 * @version datetime：2015年9月25日  上午10:01:59
 */
public class Result {

	/**返回业务数据.
	 * 
	 */
	public  Object r;
	
	/**返回信息注解.
	 * 
	 */
	public  String msg;
	
	/**返回的状态码.
	 * 
	 */
	public  String status;

	/**默认构造函数，返回空.
	 * 
	 */
	public   Result(){
		this.status = "200";
		this.r = new Object();
		this.msg = "请求成功，返回空数据!";
	}
	
	/**返回业务数据构造函数，其他状态默认.
	 * 
	 * @param r 业务数据
	 */
	public Result(Object r){
		this.status = "200";
		this.msg = "请求成功，返回业务数据!";
		this.r = r;
	}
	
	/**返回业务数据以及信息备注的构造函数；其他默认.
	 * 
	 * @param r  业务数据
	 * @param msg  业务数据的备注信息
	 */
	public Result(Object r, String msg){
		this.status = "200";
		this.msg = msg;
		this.r = r;
	}
	
	/**全信息构造函数返回.
	 * 
	 * @param r    业务数据
	 * @param msg   业务数据备注
	 * @param status  返回的状态值
	 */
	public  Result(Object r, String msg, String status){
		this.status = status;
		this.msg = msg;
		this.r = r;
	}
	
	
}
