package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.dao.RoleDao;
import org.dealoftheday.bl.entities.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends GenericDao implements RoleDao{

	@Override
	public List<RoleEntity> getAll() {
		List<RoleEntity> roles = entityManager.createQuery("from RoleEntity", RoleEntity.class).getResultList();
		return roles;
	}
}

