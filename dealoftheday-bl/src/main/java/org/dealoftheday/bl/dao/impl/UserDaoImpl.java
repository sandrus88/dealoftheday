package org.dealoftheday.bl.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.dao.UserDao;
import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.entities.UserEntity;
import org.dealoftheday.bl.util.SGUtil;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDao implements UserDao {

	@Override
	public UserEntity insert(UserEntity userEntity) {
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
		entityManager.merge(userEntity);
		return userEntity;
	}

	@Override
	public List<UserEntity> getAll() {
		List<UserEntity> users = entityManager.createQuery("from UserEntity", UserEntity.class)
				.getResultList();
		return users;
	}

	@Override
	public boolean delete(String id) {
		UserEntity userEntity = get(id);
		if (userEntity != null) {
//			userEntity.setRoles(null);
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
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql.append(" and upper(u.name) like upper(:name)");
		}
		if (!SGUtil.isEmpty(searchDto.getSurname())) {
			sql.append(" and upper(u.surname) like upper(:surname)");
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			sql.append(" and upper(u.email) like upper(:email)");
		}
		sql.append(" order by u.name desc");
		
		Query query = entityManager.createQuery(sql.toString());
		
		if (!SGUtil.isEmpty(searchDto.getName())) {
			query = query.setParameter("name", "%"+searchDto.getName()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getSurname())) {
			query = query.setParameter("surname", "%"+searchDto.getSurname()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			query = query.setParameter("email", "%"+searchDto.getEmail()+"%");
		}
		
		@SuppressWarnings("unchecked")
		List<UserEntity> users = query.getResultList();
		return users;
	}

}
