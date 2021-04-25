package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.dao.CityDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.entities.CityEntity;
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
		try {
			CityEntity cityEntity = entityManager.createQuery("select c from CityEntity c where upper(c.id) = upper('" + id + "')", CityEntity.class)
					.getSingleResult();
			return cityEntity;
		} catch (Exception e) {
			return null;
		}
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
		try {
			CityEntity cityEntity = entityManager.createQuery("select c from CityEntity c where upper(c.id) = upper('" + id + "')", CityEntity.class)
					.getSingleResult();
			if (cityEntity != null) {
				entityManager.remove(cityEntity);
				return true;
			}
		} catch (Exception e) {
			id = null;
		}
		return false;
	}
}
