package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.entities.RoleEntity;

public class RoleAssembler {
	
	private static Logger logger = LogManager.getLogger(RoleAssembler.class);
	
	public static Role getDTO(RoleEntity entity) {
		if (entity == null) {
			return null;
		}

		Role dto = new Role();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		return dto;
	}

	public static RoleEntity getEntity(Role dto) {
		if (dto == null) {
			return null;
		}
		
		RoleEntity entity = new RoleEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		return entity;
	}

	public static List<Role> getDTOList(List<RoleEntity> entityList) {
		List<Role> list = new ArrayList<>();
		for (RoleEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}
}
