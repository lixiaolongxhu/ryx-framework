package com.framework.core.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.http.HttpOutputMessage;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.framework.core.vo.ExtResultListVo;
import com.framework.core.vo.ExtResultVo;
import com.framework.core.vo.ResultVo;



/**spring mvc 将返回的message 转换为json字符串.
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午9:41:06
 */
public class FastJsonHttpMessageConverterEx extends FastJsonHttpMessageConverter {

	/**重写输出信息转换为json字符串的方法.
	 * 
	 */
	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException {
		Charset charset=UTF8;
		SerializerFeature[] features = new SerializerFeature[] {};
		OutputStream out = outputMessage.getBody();
		byte[] bytes = null;
		if (obj instanceof ResultVo ) {
			bytes = JSONSerializerEx.toJSONStringWithNull(obj, features).getBytes(charset);
		} else if ( obj instanceof ExtResultListVo ) {
			@SuppressWarnings("unchecked")
			List<Object> extResultListVo =((ExtResultListVo<Object>) obj).getObj();
			bytes = JSONSerializerEx.toJSONStringWithNull(extResultListVo, features).getBytes(charset);
		} else if ( obj instanceof ExtResultVo ) {
			@SuppressWarnings("unchecked")
			Object extResultVo =((ExtResultVo<Object>) obj).getObj();
			bytes = JSONSerializerEx.toJSONStringWithNull(extResultVo, features).getBytes(charset);
		} else {
			String msg="响应返回信息必须是框架定义的对象或其子类";
			ResultVo  result=new ResultVo(new Object(), ResultVo.RESPONSE_CODE_EXCEPTION, msg);
			bytes =JSONSerializerEx.toJSONStringWithNull(result, features).getBytes(charset);
		}
		out.write(bytes);
	}
	
}
