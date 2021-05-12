package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.dao.RoleDao;
import org.dealoftheday.bl.entities.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends GenericDao implements RoleDao{

	@Override
	public RoleEntity insert(RoleEntity roleEntity) {
		entityManager.persist(roleEntity);
		return roleEntity;
	}

	@Override
	public RoleEntity get(Integer id) {
		RoleEntity roleEntity = entityManager.find(RoleEntity.class, id);
		return roleEntity;
	}

	@Override
	public RoleEntity update(RoleEntity roleEntity) {
		entityManager.merge(roleEntity);
		return roleEntity;
	}

	@Override
	public List<RoleEntity> getAll() {
		List<RoleEntity> roles = entityManager.createQuery("from RoleEntity", RoleEntity.class).getResultList();
		return roles;
	}

	@Override
	public boolean delete(Integer id) {
		RoleEntity roleEntity = get(id);
		if (roleEntity != null) {
			entityManager.remove(roleEntity);
			return true;
		}
		return false;
	}

}
