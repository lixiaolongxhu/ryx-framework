package com.sample.mvc.service.manage.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.dao.BasicDao;
import com.framework.core.dao.DslSql;
import com.sample.mvc.Entity.Equipment;
import com.sample.mvc.Entity.EquipmentChannel;
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
	public List<EquipmentChannel> findEquipmentChannelByEid(EquipmentChannel ec) {
		DslSql dslSql=new DslSql(ec).select("*").from("eqp_cha").where();
		return basicdao.query(dslSql, EquipmentChannel.class);
	}

	@Override
	public void insertEquipment(Equipment equipment) {
		basicdao.insert(equipment);
		
	}

	@Override
	public void insertEquipmentChannel(EquipmentChannel equipmentChannel) {
		basicdao.insert(equipmentChannel);
		
	}

}
