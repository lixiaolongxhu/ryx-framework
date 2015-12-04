package com.framework.core.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpOutputMessage;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.framework.core.vo.ExtResultListVo;
import com.framework.core.vo.ExtResultVo;
import com.framework.core.vo.ResultVo;


/**spring mvc 将返回的message 转换为jsonp字符串.
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午9:41:52
 */
public class FastJsonpHttpMessageConverterEx extends FastJsonHttpMessageConverter {

	
	/**重写输出信息转换为json字符串的方法.
	 * 
	 */
	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException {
		Charset charset = UTF8;
		SerializerFeature[] features = new SerializerFeature[] {};
		String  jsonpCallBackFunc  = "jsonpCallback";
		OutputStream out = outputMessage.getBody();
		byte[] bytes = null;
		ServletRequestAttributes  reqAttr=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = reqAttr.getRequest();  
		String paramJsonp = request.getParameter("jsonp");
		if (paramJsonp == null || "".equals(paramJsonp.trim())) {
			paramJsonp = "callback";
		}
		
		String jsonpCallback = request.getParameter(paramJsonp);
		if (jsonpCallback == null || "".equals(jsonpCallback.trim())) {
			jsonpCallback = jsonpCallBackFunc;
		}
		if ( obj instanceof ExtResultListVo ) {
			@SuppressWarnings("unchecked")
			List<Object> extResultListVo =((ExtResultListVo<Object>) obj).getObj();
			obj=extResultListVo;
		} else if ( obj instanceof ExtResultVo ) {
			@SuppressWarnings("unchecked")
			Object extResultVo =((ExtResultVo<Object>) obj).getObj();
			obj=extResultVo;
		}  else {
			String msg="响应返回信息必须是框架定义的对象或其子类";
			ResultVo  result=new ResultVo(new Object(), ResultVo.RESPONSE_CODE_EXCEPTION, msg);
			obj=result;
		}
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(jsonpCallback);
		sBuffer.append("(");
		sBuffer.append(JSONSerializerEx.toJSONStringWithNull(obj, features));
		sBuffer.append(")");
		bytes = sBuffer.toString().getBytes(charset);
		out.write(bytes);
	}

}
