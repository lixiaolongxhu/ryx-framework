package com.framework.core.converter;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

/**将object进行json序列化，并转换为json字符串.
 * @author lixiaolong
 * @version datetime：2015年10月10日  下午3:04:46
 */
public final class JSONSerializerEx {
	
	/**私有构造函数.
	 * 
	 */
	private JSONSerializerEx(){
		
	}
	

	/**将object 对象转换为json字符串.
	 * 
	 * @param object 需要转换为json字符串的对象
	 * @param features 序列属性
	 * @return 返回转换为json的字符串
	 */
	public static final   String toJSONStringWithNull(Object object, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();

        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (com.alibaba.fastjson.serializer.SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            
            serializer.getValueFilters().add(new ValueFilter() {
    			public Object process(Object obj, String s, Object value) {
    				if (null != value) {
    					return value;
    				} else {
    					return "";
    				}
    			}
    		});
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }
}
