package com.sample.mvc.service.manage.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDao;
import com.framework.core.dao.DslSql;
import com.sample.mvc.Entity.Equipment;
import com.sample.mvc.Entity.EqpCha;
import com.sample.mvc.service.manage.EquipmentService;

@Service
public class EquipmentServiceImp implements EquipmentService {

	@Resource
	private BasicDao basicdao;
	
	@Override
	public List<Equipment> findEquipMentByType(Equipment em) {
		DslSql dslSql=new DslSql(em).select("*").from("equipment").where();
		return basicdao.query(dslSql, Equipment.class);
	}

	@Override
	public List<EqpCha> findEquipmentChannelByEid(EqpCha ec) {
		DslSql dslSql=new DslSql(ec).select("*").from("eqp_cha").where("eid");
		return basicdao.query(dslSql, EqpCha.class);
	}

	@Override
	public void insertEquipment(Equipment equipment) {
		basicdao.insert(equipment);
		
	}

	@Override
	public void insertEquipmentChannel(EqpCha equipmentChannel) {
		basicdao.insert(equipmentChannel);
		
	}

	@Override
	public int updateByPrimaryKey(Equipment equipment) {
		// TODO Auto-generated method stub
		return basicdao.update(equipment, "id");
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return basicdao.delete("equipment", "id");
	}

	@Override
	public int updateByPrimaryKey(EqpCha equipmentChannel) {
		// TODO Auto-generated method stub
		return basicdao.update(equipmentChannel, "id");
	}

	@Override
	public int deleteEquipMentChannlByPrimaryKey(Integer id) {
		
		return basicdao.delete("eqp_cha", "id");
	}

}
