package com.sample.mvc.service.manage;

import java.util.List;

import com.sample.mvc.Entity.Equipment;
import com.sample.mvc.Entity.EqpCha;

public interface EquipmentService {

	List<Equipment> findEquipMentByType(Equipment em);

	List<EqpCha> findEquipmentChannelByEid(EqpCha ec);

	void insertEquipment(Equipment equipment);

	void insertEquipmentChannel(EqpCha equipmentChannel);

	int updateByPrimaryKey(Equipment equipment);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKey(EqpCha equipmentChannel);

	int deleteEquipMentChannlByPrimaryKey(Integer id);

}
