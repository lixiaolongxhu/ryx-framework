package com.sample.mvc.controller;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.framework.core.vo.ResultVo;
import com.framework.ext.util.DateUtil;
import com.framework.ext.util.ToolHelper;
import com.sample.mvc.Entity.User;
import com.sample.mvc.service.TestService;

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
	
	@RequestMapping(value="/insert")
	public ResultVo insert(User user){
		user.setUuid(UUID.randomUUID().toString());
		user.setLoginName("lxl"+ ToolHelper.getRandomNumber(4));
		user.setPassword("password");
		user.setCreateTime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		Integer r=testService.insert(user);
		return  new ResultVo(r);
	}
}
