package org.dealoftheday.bl.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.CategoryAssembler;
import org.dealoftheday.bl.assembler.CityAssembler;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.dao.PartnerDao;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.entities.PartnerEntity;
import org.dealoftheday.bl.util.SGUtil;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerDaoImpl extends GenericDao implements PartnerDao {
	
	private static Logger logger = LogManager.getLogger(PartnerDaoImpl.class);

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
		StringBuilder sql = new StringBuilder();
		sql.append("select p from PartnerEntity p");
		sql.append(" where 1=1");
		if (searchDto.getId() != null) {
			sql.append(" and p.id = :id");
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql.append(" and upper(p.name) like upper(:name)");
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			sql.append(" and upper(p.email) like upper(:email)");
		}
		if (!SGUtil.isEmpty(searchDto.getCell())) {
			sql.append(" and p.cell like :cell");
		}
		if (searchDto.getCategory() != null) {
			sql.append(" and p.category = :category");
		}
		if (searchDto.getCity() != null) {
			sql.append(" and p.cityEntity = :city_id");
		}
		sql.append(" order by p.id desc");
		
		Query query = entityManager.createQuery(sql.toString());
		
		if (searchDto.getId() != null) {
			query = query.setParameter("id", searchDto.getId());
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			query = query.setParameter("name", "%"+searchDto.getName()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			query = query.setParameter("email", "%"+searchDto.getEmail()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getCell())) {
			query = query.setParameter("cell", "%"+searchDto.getCell()+"%");
		}
		if (searchDto.getCategory() != null) {
			query = query.setParameter("category", CategoryAssembler.getString(searchDto.getCategory()));
		}
		if (searchDto.getCity() != null) {
			query = query.setParameter("city_id", CityAssembler.getEntity(searchDto.getCity()));
		}
		
		@SuppressWarnings("unchecked")
		List<PartnerEntity> partners = query.getResultList();
		return partners;
	}
}
