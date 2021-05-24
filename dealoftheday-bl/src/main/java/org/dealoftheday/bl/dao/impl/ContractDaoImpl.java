package org.dealoftheday.bl.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.DealAssembler;
import org.dealoftheday.bl.assembler.PartnerAssembler;
import org.dealoftheday.bl.dao.ContractDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.domain.ContractSearchBean;
import org.dealoftheday.bl.entities.ContractEntity;
import org.dealoftheday.bl.util.SGUtil;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDaoImpl extends GenericDao implements ContractDao {
	
	private static Logger logger = LogManager.getLogger(ContractDaoImpl.class);

	@Override
	public ContractEntity insert(ContractEntity contractEntity) {
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
	public List<ContractEntity> searchContract(ContractSearchBean searchDto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select c from ContractEntity c");
		sql.append(" where 1=1");
		if (searchDto.getIdSearch() != null) {
			sql.append(" and c.id = :id");
		}
		if (!SGUtil.isEmpty(searchDto.getClientFullNameSearch())) {
			sql.append(" and upper(c.clientFullName) like upper(:clientFullName)");
		}
		if (!SGUtil.isEmpty(searchDto.getBrokerFullNameSearch())) {
			sql.append(" and upper(c.brokerFullName) like upper(:brokerFullName)");
		}
		if (searchDto.getSignedDateFrom() != null && searchDto.getSignedDateTo() != null) {
			sql.append(" and c.signedDate between :signedDateFrom and :signedDateTo");
		}
		if (searchDto.getPartnerSearch() != null) {
			sql.append(" and c.partnerEntity = :partner_id");
		}
		sql.append(" order by c.id desc");
		
		logger.info("Sql query to be executed: " + sql);
		Query query = entityManager.createQuery(sql.toString());
		
		if (searchDto.getIdSearch() != null) {
			query = query.setParameter("id", searchDto.getIdSearch());
		}
		if (!SGUtil.isEmpty(searchDto.getClientFullNameSearch())) {
			query = query.setParameter("clientFullName", "%"+searchDto.getClientFullNameSearch()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getBrokerFullNameSearch())) {
			query = query.setParameter("brokerFullName", "%"+searchDto.getBrokerFullNameSearch()+"%");
		}
		if (searchDto.getSignedDateFrom() != null && searchDto.getSignedDateTo() != null) {
			query = query.setParameter("signedDateFrom", searchDto.getSignedDateFrom()).setParameter("signedDateTo", searchDto.getSignedDateTo());
		}
		
		@SuppressWarnings("unchecked")
		List<ContractEntity> contracts = query.getResultList();
		return contracts;
	}
}
