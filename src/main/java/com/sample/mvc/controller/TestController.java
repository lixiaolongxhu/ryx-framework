package com.sample.mvc.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.util.*;
import com.framework.core.vo.ResultVo;
import com.sample.mvc.Entity.User;
import com.sample.mvc.service.TestService;
import com.sample.util.ToolHelper;

@Controller
@ResponseBody
@RequestMapping(value="/test")
public class TestController {
	
	@Resource
	private TestService testService;
	
	
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
		user.setUuid(UUID.randomUUID().toString());
		user.setLoginName("lxl"+ ToolHelper.getRandomNumber(4));
		user.setPassword("password");
		user.setCreateTime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		user.setToken(UUID.randomUUID().toString());
		testService.tran(user);
	}
	
	@RequestMapping(value="/insert")
	public ResultVo insert(User user){
		user.setUuid(UUID.randomUUID().toString());
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
}
