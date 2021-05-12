package org.dealoftheday.bl.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.RoleAssembler;
import org.dealoftheday.bl.dao.RoleDao;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.entities.RoleEntity;
import org.dealoftheday.bl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	final private RoleDao roleDao;
	private static Logger logger = LogManager.getLogger(RoleServiceImpl.class);

	@Autowired
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public Role insert(Role role) {
		RoleEntity roleEntity = RoleAssembler.getEntity(role);
		roleEntity = roleDao.insert(roleEntity);
		role = RoleAssembler.getDTO(roleEntity);
		return role;
	}

	@Override
	public Role get(Integer id) {
		RoleEntity roleEntity = roleDao.get(id);
		Role role = RoleAssembler.getDTO(roleEntity);
		return role;
	}

	@Override
	public Role update(Role role) {
		RoleEntity roleEntity = RoleAssembler.getEntity(role);
		RoleEntity customerEntityUp = roleDao.update(roleEntity);
		role = RoleAssembler.getDTO(customerEntityUp);
		return role;
	}

	@Override
	public List<Role> getAll() {
		List<RoleEntity> entityList = roleDao.getAll();
		List<Role> dtoList = RoleAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public boolean delete(Integer id) {
		return roleDao.delete(id);
	}

}
