package com.sample.mvc.controller.manage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.core.vo.ResultVo;
import com.sample.mvc.Entity.Permission;
import com.sample.mvc.service.manage.UserService;
import com.sample.mvc.vo.manage.TreeListVo;
import com.sample.mvc.vo.manage.TreeVo;

@Controller
@RequestMapping("/manage/user")
public class UserController {

	@Resource
	private UserService    userService;
	
	@RequestMapping(value="/permissionMenu")
	public @ResponseBody TreeListVo getPermissionMenu(TreeVo tree){
//		return  new ModelAndView("web-extjs/common-jsp/Login");
		List<TreeVo> menu=userService.getPermissionMenu(tree);
//		List<TreeVo> t=new ArrayList<TreeVo>();
//		for (Permission per : menu) {
//			TreeVo vo=new TreeVo();
//			vo.setId(per.getId());
//			vo.setName(per.getName());
//			vo.setParentId(per.getParentId());
//			vo.setText(per.getName());
//			vo.setLeaf(true);
//			t.add(vo);
//		}
		TreeListVo treeList=new TreeListVo();
		treeList.setTreeVoList(menu);
		return  treeList;
	}
}
