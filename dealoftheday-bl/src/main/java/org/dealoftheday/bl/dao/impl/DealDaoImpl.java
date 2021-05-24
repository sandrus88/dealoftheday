package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.dao.DealDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.entities.DealEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DealDaoImpl extends GenericDao implements DealDao {
	
	private static Logger logger = LogManager.getLogger(DealDaoImpl.class);

	@Override
	public DealEntity insert(DealEntity dealEntity) {
		entityManager.persist(dealEntity);
		return dealEntity;
	}

	@Override
	public DealEntity get(Integer id) {
		DealEntity dealEntity = entityManager.find(DealEntity.class, id);
		return dealEntity;
	}

	@Override
	public DealEntity update(DealEntity dealEntity) {
		entityManager.merge(dealEntity);
		return dealEntity;
	}

	@Override
	public List<DealEntity> getAll() {
		List<DealEntity> deals = entityManager.createQuery("from DealEntity", DealEntity.class).getResultList();
		return deals;
	}

	@Override
	public boolean delete(Integer id) {
		DealEntity dealEntity = get(id);
		if (dealEntity != null) {
			entityManager.remove(dealEntity);
			return true;
		}
		return false;
	}

}
