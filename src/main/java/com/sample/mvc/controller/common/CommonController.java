package com.sample.mvc.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**通用controller
 * 
 * @author user
 *
 */
@Controller
@RequestMapping(value="/common")
public class CommonController {

	/**跳转到登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(value="/goLogin")
	public ModelAndView    goLogin(){
		return  new ModelAndView("web-extjs/common-jsp/login");
	}
}
