package com.sample.mvc.service.manage;

import java.util.List;

import com.sample.mvc.Entity.Permission;
import com.sample.mvc.vo.manage.TreeVo;

public interface UserService {



	List<TreeVo> getPermissionMenu(TreeVo vo);

}
