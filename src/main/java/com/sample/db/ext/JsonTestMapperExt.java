package com.sample.db.ext;

import com.sample.db.dao.JsonTestMapper;

public interface JsonTestMapperExt  extends JsonTestMapper{

	
	/**
	 * select json_extract(jsonStr, '$.loginName'),json_extract(jsonStr,'$.realName') from ryx.json_test 
		where json_extract(jsonStr, '$.loginName') = 'loginname';
	 */
}
