package com.sample.mvc.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.mvc.Entity.ResType;
import com.sample.mvc.service.ResTypeService;

/**通用controller
 * 
 * @author user
 *
 */
@Controller
@RequestMapping(value="/common")
public class CommonController {

	@Resource
	private ResTypeService resTypeService;
	
	
	/**跳转到登陆页面,若用户以登陆,就跳转到登陆后的界面
	 * 
	 * @return
	 */
	@RequestMapping(value="/goLogin")
	public ModelAndView    goLogin(){
//		return  new ModelAndView("web-extjs/common-jsp/Login");
		return new ModelAndView("web-extjs/common-jsp/Admin");
	}
	
	/**
	 * 获取DB const 变量-- 即数据库基础数据
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/global")
	public ModelAndView getGlobalConfig() {
		//res_type 获取资源类型
	
		List<ResType> resTypeList = resTypeService.findAllResType();		
		ModelAndView   model=new ModelAndView("web-extjs/common-jsp/DBConst");
		model.addObject("resType", resTypeList);
		//ctlCharResType //过滤掉摄像机，人员定位和文件夹类型
		List<ResType> resCharTypeList = new ArrayList<ResType>();
		for(ResType res : resTypeList)  {
			//过滤掉摄像机，人员定位和文件夹类型
			if((res.getId() == 0) || (res.getId() == 1) || (res.getId() == 9)) {
				continue;
			}
			resCharTypeList.add(res);
		}
		model.addObject("ctlCharResType", resCharTypeList);
		return  model;
	}
}
