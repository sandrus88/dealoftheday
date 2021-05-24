package org.dealoftheday.bl.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.ContractAssembler;
import org.dealoftheday.bl.assembler.StatusAssembler;
import org.dealoftheday.bl.dao.DealDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.domain.DealSearchBean;
import org.dealoftheday.bl.entities.DealEntity;
import org.dealoftheday.bl.util.SGUtil;
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

	@Override
	public List<DealEntity> searchDeal(DealSearchBean searchDto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select d from DealEntity d");
		sql.append(" where 1=1");
		if (searchDto.getIdSearch() != null) {
			sql.append(" and d.id = :id");
		}
		if (!SGUtil.isEmpty(searchDto.getTitleSearch())) {
			sql.append(" and upper(d.title) like upper(:title)");
		}
		if (searchDto.getApprovedDateFrom() != null && searchDto.getApprovedDateTo() != null) {
			sql.append(" and d.approvedDate between :approvedDateFrom and :approvedDateTo");
		}
		if (searchDto.getStatusSearch() != null) {
			sql.append(" and d.status = :status");
		}
		if (searchDto.getContractSearch() != null) {
			sql.append(" and d.contractEntity = :contractEntity");
		}
		sql.append(" order by d.id desc");
		
		logger.info("Sql query to be executed: " + sql);
		Query query = entityManager.createQuery(sql.toString());
		
		if (searchDto.getIdSearch() != null) {
			query = query.setParameter("id", searchDto.getIdSearch());
		}
		if (!SGUtil.isEmpty(searchDto.getTitleSearch())) {
			query = query.setParameter("title", "%"+searchDto.getTitleSearch()+"%");
		}
		if (searchDto.getApprovedDateFrom() != null && searchDto.getApprovedDateTo() != null) {
			query = query.setParameter("approvedDateFrom", searchDto.getApprovedDateFrom()).setParameter("approvedDateTo", searchDto.getApprovedDateTo());
		}
		if (searchDto.getStatusSearch() != null) {
			query = query.setParameter("status", StatusAssembler.getString(searchDto.getStatusSearch()));
		}
		if (searchDto.getContractSearch() != null) {
			query = query.setParameter("contractEntity", ContractAssembler.getEntity(searchDto.getContractSearch()));
		}
		
		@SuppressWarnings("unchecked")
		List<DealEntity> deals = query.getResultList();
		return deals;
	}

}
