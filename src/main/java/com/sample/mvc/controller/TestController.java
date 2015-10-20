package com.sample.mvc.controller;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Resource;
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
	
	@RequestMapping(value="/cache")
	public ResultVo selectCache(){
		User user=new User();
		user.setUuid(UUID.randomUUID().toString());
		user.setLoginName("lxl"+ ToolHelper.getRandomNumber(4));
		user.setPassword("password");
		user.setCreateTime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		user.setToken(UUID.randomUUID().toString());
		User returnUser=testService.selectCache();
		return new ResultVo(returnUser);
	}
}
