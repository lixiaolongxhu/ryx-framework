package com.framework.core.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;


/**
 * 使用fastjson对响应jsonp对象处理封装
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午9:41:52
 */
public class FastJsonpHttpMessageConverterEx extends FastJsonHttpMessageConverter {

	private Charset charset = UTF8;

	private SerializerFeature[] features = new SerializerFeature[] {};

	
	private static final String JSONP_CALLBACK_FUNC = "jsonpCallback";
	
	public Charset getCharset() {
		return this.charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	public SerializerFeature[] getFeatures() {
		return features;
	}

	public void setFeatures(SerializerFeature... features) {
		this.features = features;
	}

	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		
//		OutputStream out = outputMessage.getBody();
//		byte[] bytes = null;
//		
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
//		String paramJsonp = request.getParameter("jsonp");
//		if(paramJsonp == null || paramJsonp.trim().equals("")){
//			paramJsonp = "callback";
//		}
//		
//		String jsonpCallback = request.getParameter(paramJsonp);
//		if(jsonpCallback == null || jsonpCallback.trim().equals("")){
//			jsonpCallback = JSONP_CALLBACK_FUNC;
//		}
//		
//		if(obj instanceof BizError || obj instanceof FieldErrorCompose){
////			String text = JSON.toJSONString(obj, features);
////			bytes = text.getBytes(charset);
//			
//			StringBuffer sBuffer = new StringBuffer();
//			sBuffer.append(jsonpCallback);
//			sBuffer.append("(");
//			sBuffer.append(FastJsonUtil.toJSONStringWithNull(obj, features));
//			sBuffer.append(")");
//			bytes = sBuffer.toString().getBytes(charset);
//		} else {
//			//jsonp support
////			String text = MessageFormat.format(JSONP_CALLBACK_FUNC, JSON.toJSONString(obj, features));
////			bytes = text.getBytes(charset);
//
//			if(obj instanceof PageDataTables){
//				
//				((PageDataTables) obj).setStatus(Const.ResponseStatusCode.OK);
//				((PageDataTables) obj).setMsg("");
//				
//				StringBuffer sBuffer = new StringBuffer();
//				sBuffer.append(jsonpCallback);
//				sBuffer.append("(");
//				sBuffer.append(FastJsonUtil.toJSONStringWithNull(obj, features));
//				sBuffer.append(")");
//				bytes = sBuffer.toString().getBytes(charset);
//			}else if(obj instanceof  ZTree){
//				String text = FastJsonUtil.toJSONStringWithNull(obj, features);
//				bytes = text.getBytes(charset);
//			} else if(obj instanceof Page){
//				((Page) obj).setStatus(Const.ResponseStatusCode.OK);
//				((Page) obj).setMsg("");
//				StringBuffer sBuffer = new StringBuffer();
//				sBuffer.append(jsonpCallback);
//				sBuffer.append("(");
//				sBuffer.append(FastJsonUtil.toJSONStringWithNull(obj, features));
//				sBuffer.append(")");
//				bytes = sBuffer.toString().getBytes(charset);
//			}else {
//				Map<String,Object> map = new HashMap<String,Object>();
//				
//				map.put(Const.ResponseFieldName.STATUS_CODE_NAME, Const.ResponseStatusCode.OK);
//				map.put(Const.ResponseFieldName.STATUS_RESULTSET_NAME, obj);
//				
//				if(obj instanceof String || obj instanceof Integer){
//					map.put(Const.ResponseFieldName.STATUS_MESSAGE_NAME, obj);
//				}else{
//					map.put(Const.ResponseFieldName.STATUS_MESSAGE_NAME, "");
//				}
//				
//				StringBuffer sBuffer = new StringBuffer();
//				sBuffer.append(jsonpCallback);
//				sBuffer.append("(");
//				sBuffer.append(FastJsonUtil.toJSONStringWithNull(map, features));
//				sBuffer.append(")");
//				bytes = sBuffer.toString().getBytes(charset);
//			}
//		}
//		out.write(bytes);
	}

}
