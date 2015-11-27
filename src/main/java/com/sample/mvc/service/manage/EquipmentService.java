package com.sample.mvc.service.manage;

import java.util.List;

import com.sample.mvc.Entity.Equipment;
import com.sample.mvc.Entity.EquipmentChannel;

public interface EquipmentService {

	List<Equipment> findEquipMentByType(Equipment em);

	List<EquipmentChannel> findEquipmentChannelByEid(EquipmentChannel ec);

	void insertEquipment(Equipment equipment);

	void insertEquipmentChannel(EquipmentChannel equipmentChannel);

}
