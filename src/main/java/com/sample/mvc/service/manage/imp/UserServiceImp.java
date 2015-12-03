package com.sample.mvc.service.manage.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDao;
import com.framework.core.dao.DslSql;
import com.sample.mvc.Entity.Permission;
import com.sample.mvc.service.manage.UserService;
import com.sample.mvc.vo.manage.TreeVo;



@Service
@SuppressWarnings("rawtypes")
public class UserServiceImp  implements UserService{
	
	@Resource
	private BasicDao basicdao;

	@Override
	public List<TreeVo> getPermissionMenu(TreeVo vo) {
		Permission per=new Permission();
		per.setType(2);
		per.setParentId(vo.getParentId());
		DslSql dslSql=new DslSql(per).select(" id , name as text,parentId,url").from("permission").where("type","parentId");
		
		List<TreeVo> tv= basicdao.query(dslSql, TreeVo.class);
		
		if(!tv.isEmpty()){
			for (TreeVo treeVo : tv) {
				Permission perchild=new Permission();
				perchild.setParentId(treeVo.getId());
				DslSql childDslSql=new DslSql(perchild).select("count(id)").from("permission").where("parentId");
				Integer count=basicdao.queryCount(childDslSql);
				if(count>0){
					treeVo.setLeaf(false);
				}else{
					treeVo.setLeaf(true);
				}
			}
			
		}
		
		return tv;
	}

	

	

	

}
