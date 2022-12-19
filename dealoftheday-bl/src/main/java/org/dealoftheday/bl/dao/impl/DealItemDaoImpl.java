package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.dao.DealItemDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.entities.DealItemEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DealItemDaoImpl extends GenericDao implements DealItemDao {
	
	private static Logger logger = LogManager.getLogger(DealItemDaoImpl.class);

	@Override
	public DealItemEntity insert(DealItemEntity dealItemEntity) {
		entityManager.persist(dealItemEntity);
		return dealItemEntity;
	}

	@Override
	public DealItemEntity get(Integer id) {
		DealItemEntity dealItemEntity = entityManager.find(DealItemEntity.class, id);
		return dealItemEntity;
	}

	@Override
	public DealItemEntity update(DealItemEntity dealItemEntity) {
		entityManager.merge(dealItemEntity);
		return dealItemEntity;
	}

	@Override
	public List<DealItemEntity> getAll() {
		List<DealItemEntity> dealItems = entityManager.createQuery("from DealItemEntity", DealItemEntity.class).getResultList();
		return dealItems;
	}

	@Override
	public boolean delete(Integer id) {
		DealItemEntity dealItemEntity = get(id);
		if (dealItemEntity != null) {
			entityManager.remove(dealItemEntity);
			return true;
		}
		return false;
	}
}
