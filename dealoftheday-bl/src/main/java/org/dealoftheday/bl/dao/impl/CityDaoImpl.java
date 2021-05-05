package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.dao.CityDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.entities.CityEntity;
import org.dealoftheday.bl.entities.CustomerEntity;
import org.dealoftheday.bl.util.SGUtil;
import org.springframework.stereotype.Repository;

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
		CityEntity cityEntity = entityManager.find(CityEntity.class, id);
		if (cityEntity != null) {
			cityEntity.setPartners(null);
			entityManager.remove(cityEntity);
			return true;
		}
		return false;
	}

	@Override
	public List<CityEntity> searchCity(City searchDto) {
		String sql = "select c from CityEntity c ";
		sql += "where 1=1";
		if (!SGUtil.isEmpty(searchDto.getId())) {
			sql += "and c.id = '" + searchDto.getId() + "'";
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql += "and upper(c.name) like upper('%" + searchDto.getName() + "%')";
		}
		List<CityEntity> cities = entityManager.createQuery(sql, CityEntity.class).getResultList();
		return cities;
	}
}
