package org.dealoftheday.bl.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.CustomerAssembler;
import org.dealoftheday.bl.assembler.UserAssembler;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.dao.UserDao;
import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.entities.UserEntity;
import org.dealoftheday.bl.util.SGUtil;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDao implements UserDao {

	private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

	@Override
	public UserEntity insert(UserEntity userEntity) {
		userEntity.setLastUpdate(new Date());
		entityManager.persist(userEntity);
		return userEntity;
	}

	@Override
	public UserEntity get(String id) {
		UserEntity userEntity = entityManager.find(UserEntity.class, id);
		return userEntity;
	}

	@Override
	public UserEntity update(UserEntity userEntity) {
		userEntity.setLastUpdate(new Date());
		entityManager.merge(userEntity);
		return userEntity;
	}

	@Override
	public List<UserEntity> getAll() {
		List<UserEntity> users = entityManager.createQuery("from UserEntity", UserEntity.class).getResultList();
		return users;
	}

	@Override
	public boolean delete(String id) {
		UserEntity userEntity = get(id);
		if (userEntity != null) {
			entityManager.remove(userEntity);
			return true;
		}
		return false;
	}

	@Override
	public List<UserEntity> searchUser(User searchDto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select u from UserEntity u");
		sql.append(" where 1=1");
		if (!SGUtil.isEmpty(searchDto.getUserName())) {
			sql.append(" and upper(u.userName) like upper(:username)");
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql.append(" and upper(u.name) like upper(:name)");
		}
		if (!SGUtil.isEmpty(searchDto.getSurname())) {
			sql.append(" and upper(u.surname) like upper(:surname)");
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			sql.append(" and upper(u.email) like upper(:email)");
		}
		if (searchDto.getRoles() != null) {
			sql.replace(27, 36, " join u.roles r where")
			.append(" r.id = :roleId");
			logger.debug("Roles to filter by in the query: " + searchDto.getRoles());
		}
		if(searchDto.getEnabled() != null) {
			sql.append(" and u.enabled = :enabled");
		}
		if(searchDto.getLocked() != null) {
			sql.append(" and u.locked = :locked");
		}
		sql.append(" order by u.lastUpdate desc");

		logger.info("Sql query to be executed: " + sql);
		Query query = entityManager.createQuery(sql.toString());
		
		if (!SGUtil.isEmpty(searchDto.getUserName())) {
			query = query.setParameter("username", "%" + searchDto.getUserName() + "%");
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			query = query.setParameter("name", "%" + searchDto.getName() + "%");
		}
		if (!SGUtil.isEmpty(searchDto.getSurname())) {
			query = query.setParameter("surname", "%" + searchDto.getSurname() + "%");
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			query = query.setParameter("email", "%" + searchDto.getEmail() + "%");
		}
		if (searchDto.getRoles() != null) {
			for (int i = 0; i < searchDto.getRoles().size(); i++) {
				query = query.setParameter("roleId", searchDto.getRoles().get(i).getId());
			}
		}
		if (searchDto.getEnabled() != null) {
			query = query.setParameter("enabled", UserAssembler.getIntFromBoolean(searchDto.getEnabled()));
		}
		if (searchDto.getLocked() != null) {
			query = query.setParameter("locked", UserAssembler.getIntFromBoolean(searchDto.getLocked()));
		}

		@SuppressWarnings("unchecked")
		List<UserEntity> users = query.getResultList();
		return users;
	}

}
