package com.sample.mvc.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.eclipse.jetty.util.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.util.*;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.framework.core.converter.JSONSerializerEx;
import com.framework.core.vo.ResultVo;
import com.sample.cometd.CometService;
import com.sample.db.dao.JsonTestMapper;
import com.sample.db.ext.JsonTestMapperExt;
import com.sample.db.model.JsonTestExample;
import com.sample.mvc.Entity.JsonTest;
import com.sample.mvc.Entity.User;
import com.sample.mvc.service.TestService;
import com.sample.util.ToolHelper;

@Controller
@ResponseBody
@RequestMapping(value="/test")
public class TestController {
	
	private static final Logger LOG=LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private JsonTestMapperExt jsonTestMapperExt;
	
	
	@Resource
	private TestService testService;
	
	// 向客户端推送告警消息
		@Autowired
		private CometService cometService;
		
	@RequestMapping(value="/result")
	public Integer result(User user){
		return  1;
	}
	
	@RequestMapping(value="exc")
	public Integer exception(){
		testService.exception();
		return 1; 
	}
	
	@RequestMapping(value="tran")
	public void transaction(){
		User user=new User();
		
		user.setLoginName("lxl"+ ToolHelper.getRandomNumber(4));
		user.setPassword("password");
		user.setCreateTime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		user.setToken(UUID.randomUUID().toString());
		testService.tran(user);
	}
	
	@RequestMapping(value="/insert")
	public ResultVo insert(User user){
		user.setLoginName("lxl"+ ToolHelper.getRandomNumber(4));
		user.setPassword("password");
		user.setCreateTime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		user.setToken(UUID.randomUUID().toString());
		Integer r=testService.insert(user);
		return  new ResultVo(r);
	}
//	//将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key
//	//通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值

	@RequestMapping(value="/cache")
	
	public ResultVo selectCache(String token){
		
		List<User> returnUser=testService.selectCache(token);
		return new ResultVo(returnUser);
	}
	@RequestMapping(value="/queryOne")
	public ResultVo queryOne(){
		User user=testService.queryOne();
		return new ResultVo(user);
	}
	
	@RequestMapping(value="/update")
	public ResultVo  update(){
		User user=testService.update();
		return new ResultVo(user);
	}
	@RequestMapping(value="/cometd")
	public void cometd(){
		cometService.clientNotify("发送信息");
	}
	
	@RequestMapping(value="/jsonS2")
	public ResultVo json(){
		
	   User user=new User();
	   user.setLoginName("登陆名");
	   user.setRealName("李小龙");
	   user.setCreateTime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
	   JsonTest  json=new JsonTest();
	   json.setJsonStr(JSONSerializerEx.toJSONStringWithNull(user, new SerializerFeature[] {}));
	   LOG.debug("输出jsonStr =" +json.getJsonStr());
	   testService.insert(json);
	   JsonTestExample example=new JsonTestExample();
	   return new ResultVo(jsonTestMapperExt.selectByExample(example));
	   
	}
	
	@RequestMapping(value="/jsonS")
	public ResultVo jsonS() throws SQLException{
	   User user=new User();
	   user.setLoginName("loginname");
	   user.setRealName("李小龙");
	   user.setCreateTime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
	   JsonTest  json=new JsonTest();
	   json.setJsonStr(JSONSerializerEx.toJSONStringWithNull(user, new SerializerFeature[] {}));
	   json.setName("jsonTest姓名");
	   testService.insert(json);
	   List<JsonTest >  j=testService.jsonS(json);
//	   LOG.debug("输出jsonStr =" +j.get(0).getJsonStr());
	   return new ResultVo(j);
	}
}
