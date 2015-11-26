//package com.sample.httpClient;
//
//import java.io.IOException;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//
//
//
//public class SendHttp {
//
//	public SendHttp() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	/**新浪天气api 
//	 * http://blog.csdn.net/jackrex/article/details/8741608
//	 */
//	public static void xinLangWeatherApi(){
//		HttpClient httpclient = new HttpClient();
//		PostMethod post = new PostMethod("http://php.weather.sina.com.cn/xml.php");
//		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
//		post.addParameter("city", "成都");
//		post.addParameter("dpc", "1");
//		post.addParameter("password","DJOYnieT8234jlsK");
//		
//	
//		
//		
//		String info=null;
//		try {
//			httpclient.executeMethod(post);
//			System.out.println("输出返回响应的结果 ：" + post.getResponseBodyAsString());
//			info = new String(post.getResponseBody(), "gb2312");
//		} catch (IOException e) {
//			e.printStackTrace();
//			
//		}
//		
//	}
//	
//	public static void main(String[] args){
//		xinLangWeatherApi();
//	
//	}
//
//}
