package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.dao.PartnerDao;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.entities.PartnerEntity;
import org.dealoftheday.bl.util.SGUtil;
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
		entityManager.remove(partnerEntity);
		return true;
	}
	
	@Override
	public List<PartnerEntity> searchPartner(Partner searchDto) {
		String sql = "select p from PartnerEntity p ";
		sql += "where 1=1";
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql += "and upper(p.name) like upper('%" + searchDto.getName() + "%')";
		}
		if (searchDto.getCategory() != null) {
			sql += "and p.category = '" + searchDto.getCategory() + "'";
		}
		if (searchDto.getCity() != null) {
			sql += "and city_id = '" + searchDto.getCity().getId() + "'";
		}
		List<PartnerEntity> partners = entityManager.createQuery(sql, PartnerEntity.class).getResultList();
		return partners;
	}
}
