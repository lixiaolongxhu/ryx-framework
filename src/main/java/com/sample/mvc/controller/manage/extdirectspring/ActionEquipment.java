/*
 * 对所有需要接入的设备进行集中描述
 * 不再需要5个表进行描述
 * 精简到2个表进行描述
 */
package com.sample.mvc.controller.manage.extdirectspring;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mvc.Entity.Equipment;
import com.sample.mvc.Entity.EquipmentChannel;
import com.sample.mvc.service.manage.EquipmentService;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;



@Service
public class ActionEquipment {

	/*
	 * 1000以下的是视频的类型 1000以上的是控制器类型
	 */

	@Resource
	private EquipmentService equipmentService;

	// ------------编码器--------------------------

	// 设备列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<Equipment> readEqp(ExtDirectStoreReadRequest request) {

		// 得到需要查询的设备类型
		// 1: 视频设备
		// 2: 前端控制器
		// 3: 定位设备
		// 4: goose设备
		int type = Integer.parseInt(request.getParams().get("type").toString());
		Equipment em=new Equipment();

		switch (type) {
		case 1: // 视频设备
			em.setType(1000);
			break;
		case 2: // 前端控制器
			em.setType(1001);
			break;
		case 3: // 定位设备
			em.setType(1002);
			break;
		case 4: // goose设备
			em.setType(1003);
			
			break;
		}
		
		List<Equipment> list=equipmentService.findEquipMentByType(em);
		return new ExtDirectStoreReadResult<Equipment>(list);
	}

	// 设备插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<Equipment> createEqp(List<Equipment> equipments) {
		equipmentService.insertEquipment(equipments.get(0));
		return new ExtDirectStoreReadResult<Equipment>(equipments.get(0));
	}
//
//	// 设备修改
//	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
//	public int updateEqp(List<Equipment> equipments) {
//		return equipmentMapper.updateByPrimaryKey(equipments.get(0));
//	}
//
//	// 设备删除
//	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
//	public int destroyEqp(List<Equipment> equipments) {
//		// 删除设备
//		return equipmentMapper.deleteByPrimaryKey(equipments.get(0).getId());
//	}

	// ------------设备通道--------------------------

	// 设备通道列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EquipmentChannel> readEqpCha(ExtDirectStoreReadRequest request) {

		// 得到主表的ID
		int masterId = Integer.parseInt(request.getParams().get("masterId").toString());
		EquipmentChannel ec=new EquipmentChannel();
		ec.setEid(masterId);
		List<EquipmentChannel> list=equipmentService.findEquipmentChannelByEid(ec);

		return new ExtDirectStoreReadResult<EquipmentChannel>(list);
	}

	// 设备通道插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EquipmentChannel> createEqpCha(List<EquipmentChannel> equipmentChannels) {
		equipmentService.insertEquipmentChannel(equipmentChannels.get(0));
		return new ExtDirectStoreReadResult<EquipmentChannel>(equipmentChannels.get(0));
	}
//
//	// 设备通道修改
//	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
//	public int updateEqpCha(List<EquipmentChannel> equipmentChannels) {
//		return equipmentChannelMapper.updateByPrimaryKey(equipmentChannels.get(0));
//	}
//
//	// 设备通道删除
//	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
//	public int destroyEqpCha(List<EquipmentChannel> equipmentChannels) {
//		return equipmentChannelMapper.deleteByPrimaryKey(equipmentChannels.get(0).getId());
//	}

}
