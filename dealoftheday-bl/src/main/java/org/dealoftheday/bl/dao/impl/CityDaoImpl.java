package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.dao.CityDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.entities.CityEntity;
import org.dealoftheday.bl.entities.CustomerEntity;
import org.dealoftheday.bl.util.SGUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class CityDaoImpl extends GenericDao implements CityDao {

	@Override
	public CityEntity insert(CityEntity cityEntity) {
		entityManager.persist(cityEntity);
		return cityEntity;
	}

	@Override
	public CityEntity get(String id) {
		CityEntity cityEntity = entityManager.find(CityEntity.class, id);
		return cityEntity;
	}

	@Override
	public CityEntity update(CityEntity cityEntity) {
		entityManager.merge(cityEntity);
		return cityEntity;
	}

	@Override
	public List<CityEntity> getAll() {
		List<CityEntity> cities = entityManager.createQuery("from CityEntity", CityEntity.class).getResultList();
		return cities;
	}

	@Override
	public boolean delete(String id) {
		CityEntity cityEntity = get(id);
		if (cityEntity != null) {
			entityManager.remove(cityEntity);
			return true;
		}
		return false;
	}

	@Override
	public List<CityEntity> searchCity(City searchDto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select c from CityEntity c");
		sql.append(" where 1=1");

		if (!SGUtil.isEmpty(searchDto.getId())) {
			sql.append(" and c.id = ':id'");
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql.append(" and upper(c.name) like upper('%:name%')");
		}
		
		Query query = entityManager.createQuery(sql.toString());
		
		if (!SGUtil.isEmpty(searchDto.getId())) {
			query = query.setParameter("id", searchDto.getId());
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			query = query.setParameter("name", searchDto.getName());
		}
		
		List<CityEntity> cities = query.getResultList();
		return cities;
	}
}
