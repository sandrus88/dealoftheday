package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.entities.RoleEntity;
import org.dealoftheday.bl.entities.UserEntity;
import org.dealoftheday.bl.service.impl.UserServiceImpl;

public class UserAssembler {
	
	public static final int FINAL_1 = 1;
	public static final int FINAL_0 = 0;
	private static Logger logger = LogManager.getLogger(UserAssembler.class);

	public static User getDTO(UserEntity entity) {
		if (entity == null) {
			return null;
		}

		User dto = new User();
		dto.setUserName(entity.getUserName());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setEmail(entity.getEmail());
		dto.setPwd(entity.getPwd());
		dto.setEnabled(getBooleanFromInt(entity.getEnabled()));
		dto.setLocked(getBooleanFromInt(entity.getLocked()));
		dto.setFailedLoginCount(entity.getFailedLoginCount());
		
		 for (RoleEntity roleEntity : entity.getRoles()) {
	            Role role  = RoleAssembler.getDTO(roleEntity);
	            dto.addRole(role);
	        }
		return dto;
	}

	public static UserEntity getEntity(User dto) {
		if (dto == null) {
			return null;
		}

		UserEntity entity = new UserEntity();
		entity.setUserName(dto.getUserName());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setEmail(dto.getEmail());
		entity.setPwd(dto.getPwd());
		entity.setEnabled(getIntFromBoolean(dto.getEnabled()));
		entity.setLocked(getIntFromBoolean(dto.getLocked()));
		entity.setFailedLoginCount(dto.getFailedLoginCount());
		
		 for (Role role : dto.getRoles()) {
	            RoleEntity roleEntity  = RoleAssembler.getEntity(role);
	            entity.addRole(roleEntity);
	        }
		return entity;
	}

	public static boolean getBooleanFromInt(int i) {
		if (i == FINAL_1) {
			return true;
		}
		return false;
	}

	public static int getIntFromBoolean(Boolean b) {
		if (b != null && b) {
			return FINAL_1;
		}
		return FINAL_0;
	}

	public static List<User> getDTOList(List<UserEntity> entityList) {
		List<User> list = new ArrayList<>();
		for (UserEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}
}
