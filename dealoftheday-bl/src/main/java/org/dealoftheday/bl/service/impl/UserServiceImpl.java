package org.dealoftheday.bl.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.RoleAssembler;
import org.dealoftheday.bl.assembler.UserAssembler;
import org.dealoftheday.bl.dao.RoleDao;
import org.dealoftheday.bl.dao.UserDao;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.entities.RoleEntity;
import org.dealoftheday.bl.entities.UserEntity;
import org.dealoftheday.bl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	final private UserDao userDao;
	final private RoleDao roleDao;
	private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	@Override
	public User insert(User user) {
		UserEntity userEntity = UserAssembler.getEntity(user);
		userEntity = userDao.insert(userEntity);
		user = UserAssembler.getDTO(userEntity);
		logger.info("User inserted on db: " + user);
		return user;
	}

	@Override
	public User get(String id) {
		logger.info("Get user by id: " + id);
		UserEntity userEntity = userDao.get(id);
		User user = UserAssembler.getDTO(userEntity);
		logger.info("Returned from db user: " + user);
		return user;
	}

	@Override
	public User update(User user) {
		logger.info("Get user by id: " + user.getUserName());
		UserEntity userEntity = UserAssembler.getEntity(user);
		UserEntity customerEntityUp = userDao.update(userEntity);
		user = UserAssembler.getDTO(customerEntityUp);
		logger.info("Returned from db user: " + user);
		return user;
	}

	@Override
	public List<User> getAll() {
		List<UserEntity> entityList = userDao.getAll();
		List<User> dtoList = UserAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public boolean delete(String id) {
		return userDao.delete(id);
	}

	@Override
	public List<User> searchUser(User searchDto) {
		List<UserEntity> listEntities = userDao.searchUser(searchDto);
		List<User> list = UserAssembler.getDTOList(listEntities);
		return list;
	}

	@Override
	public List<Role> getAllRoles() {
		List<RoleEntity> entityList = roleDao.getAll();
		List<Role> dtoList = RoleAssembler.getDTOList(entityList);
		return dtoList;
	}

}
