package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.dao.PartnerDao;
import org.dealoftheday.bl.entities.CityEntity;
import org.dealoftheday.bl.entities.PartnerEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerDaoImpl extends GenericDao implements PartnerDao {

	@Override
	public PartnerEntity insert(PartnerEntity partnerEntity) {
		entityManager.persist(partnerEntity);
		return partnerEntity;
	}

	@Override
	public PartnerEntity get(Integer id) {
		PartnerEntity partnerEntity = entityManager.find(PartnerEntity.class, id);
		return partnerEntity;
	}

	@Override
	public PartnerEntity update(PartnerEntity partnerEntity) {
		entityManager.merge(partnerEntity);
		return partnerEntity;
	}

	@Override
	public List<PartnerEntity> getAll() {
		List<PartnerEntity> partners = entityManager.createQuery("from PartnerEntity", PartnerEntity.class)
				.getResultList();
		return partners;
	}

	@Override
	public boolean delete(Integer id) {
		PartnerEntity partnerEntity = get(id);
		if (partnerEntity == null) {
			return false;
		}

		if (partnerEntity.getCityId() != null || !partnerEntity.getCityId().equals("")) {
			CityEntity cityEntity = entityManager.find(CityEntity.class, partnerEntity.getCityId());
			if (cityEntity.getPartners().contains(partnerEntity)) {
				cityEntity.removePartner(partnerEntity);
			}
		}
		entityManager.remove(partnerEntity);
		return true;
	}
}
