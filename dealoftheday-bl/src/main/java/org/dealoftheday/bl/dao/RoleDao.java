package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.entities.RoleEntity;

public interface RoleDao {
	
	RoleEntity insert(RoleEntity roleEntity);

	RoleEntity get(Integer id);

	RoleEntity update(RoleEntity roleEntity);

    List<RoleEntity> getAll();

    boolean delete(Integer id);
}
