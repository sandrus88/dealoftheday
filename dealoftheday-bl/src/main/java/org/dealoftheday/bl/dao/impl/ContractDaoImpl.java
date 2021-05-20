package org.dealoftheday.bl.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.ContractAssembler;
import org.dealoftheday.bl.assembler.PartnerAssembler;
import org.dealoftheday.bl.dao.ContractDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.entities.ContractEntity;
import org.dealoftheday.bl.util.SGUtil;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDaoImpl extends GenericDao implements ContractDao {
	
	private static Logger logger = LogManager.getLogger(ContractDaoImpl.class);

	@Override
	public ContractEntity insert(ContractEntity contractEntity) {
		contractEntity.setInsertionDate(new Date());
		entityManager.persist(contractEntity);
		return contractEntity;
	}

	@Override
	public ContractEntity get(Integer id) {
		ContractEntity contractEntity = entityManager.find(ContractEntity.class, id);
		return contractEntity;
	}

	@Override
	public ContractEntity update(ContractEntity contractEntity) {
		contractEntity.setLastUpdate(new Date());
		entityManager.merge(contractEntity);
		return contractEntity;
	}

	@Override
	public List<ContractEntity> getAll() {
		List<ContractEntity> contracts = entityManager.createQuery("from ContractEntity", ContractEntity.class).getResultList();
		return contracts;
	}

	@Override
	public boolean delete(Integer id) {
		ContractEntity contractEntity = get(id);
		if (contractEntity != null) {
			entityManager.remove(contractEntity);
			return true;
		}
		return false;
	}

	@Override
	public List<ContractEntity> searchContract(Contract searchDto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select c from ContractEntity c");
		sql.append(" where 1=1");
		if (searchDto.getId() != null) {
			sql.append(" and c.id = :id");
		}
		if (!SGUtil.isEmpty(searchDto.getTitle())) {
			sql.append(" and upper(c.title) like upper(:title)");
		}
		if (searchDto.getDayOfSignature() != null) {
			sql.append(" and c.dayOfSignature = :dayOfSignature");
		}
		if (searchDto.getPartner() != null) {
			sql.append(" and c.partnerEntity = :partner_id");
		}
		sql.append(" order by c.lastUpdate desc");
		
		Query query = entityManager.createQuery(sql.toString());
		
		if (searchDto.getId() != null) {
			query = query.setParameter("id", searchDto.getId());
		}
		if (!SGUtil.isEmpty(searchDto.getTitle())) {
			query = query.setParameter("title", "%"+searchDto.getTitle()+"%");
		}
		if (searchDto.getDayOfSignature() != null) {
			query = query.setParameter("dayOfSignature", searchDto.getDayOfSignature());
		}
		if (searchDto.getPartner() != null) {
			query = query.setParameter("partner_id", PartnerAssembler.getEntity(searchDto.getPartner()));
		}
		
		@SuppressWarnings("unchecked")
		List<ContractEntity> contracts = query.getResultList();
		return contracts;
	}
}
