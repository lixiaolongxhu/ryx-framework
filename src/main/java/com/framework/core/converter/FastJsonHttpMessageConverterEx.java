package com.framework.core.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;


/**
 * 使用fastjson对响应json对象处理封装
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午9:41:06
 */
public class FastJsonHttpMessageConverterEx extends FastJsonHttpMessageConverter {
	private Charset charset = UTF8;

	private SerializerFeature[] features = new SerializerFeature[] {};

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
		
		OutputStream out = outputMessage.getBody();
		byte[] bytes = null;
		bytes = JSON.toJSONString(obj).getBytes(charset);
//		if(obj instanceof BizError || obj instanceof FieldErrorCompose){
//			String text = FastJsonUtil.toJSONStringWithNull(obj, features);
//			bytes = text.getBytes(charset);
//		} else {
//
//			if(obj instanceof PageDataTables){
//				((PageDataTables) obj).setStatus(Const.ResponseStatusCode.OK);
//				((PageDataTables) obj).setMsg("");
//				String text = FastJsonUtil.toJSONStringWithNull(obj, features);
//				bytes = text.getBytes(charset);
//			} else if(obj instanceof  ZTreeList){
//				List<ZTree> ztreeList=new ArrayList<ZTree>();
//				ztreeList.addAll(((ZTreeList) obj).getZtreelist());
//				String text = FastJsonUtil.toJSONStringWithNull(ztreeList, features);
//				bytes = text.getBytes(charset);
//			}else if(obj instanceof Page){
//				((Page) obj).setStatus(Const.ResponseStatusCode.OK);
//				((Page) obj).setMsg("");
//				String text = FastJsonUtil.toJSONStringWithNull(obj, features);
//				bytes = text.getBytes(charset);
//			}else {
//				Map<String,Object> map = new HashMap<String,Object>();
//				map.put(Const.ResponseFieldName.STATUS_CODE_NAME, Const.ResponseStatusCode.OK);
//				map.put(Const.ResponseFieldName.STATUS_RESULTSET_NAME, obj);
//				if(obj instanceof String || obj instanceof Integer){
//					map.put(Const.ResponseFieldName.STATUS_MESSAGE_NAME, obj);
//				}else{
//					map.put(Const.ResponseFieldName.STATUS_MESSAGE_NAME, "");
//				}
//				String text = FastJsonUtil.toJSONStringWithNull(map, features);
//				bytes = text.getBytes(charset);
//			}
//		}
		out.write(bytes);
	}

}
