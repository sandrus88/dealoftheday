package org.dealoftheday.bl.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.ContractAssembler;
import org.dealoftheday.bl.assembler.PartnerAssembler;
import org.dealoftheday.bl.dao.ContractDao;
import org.dealoftheday.bl.dao.PartnerDao;
import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.ContractSearchBean;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.entities.ContractEntity;
import org.dealoftheday.bl.entities.PartnerEntity;
import org.dealoftheday.bl.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "contractService")
@Transactional
public class ContractServiceImpl implements ContractService {
	
	final private ContractDao contractDao;
	private static Logger logger = LogManager.getLogger(ContractServiceImpl.class);

	@Autowired
	public ContractServiceImpl(ContractDao contractDao) {
		this.contractDao = contractDao;
	}

	@Override
	public Contract insert(Contract contract) {
		ContractEntity entity = ContractAssembler.getEntity(contract);
		entity = contractDao.insert(entity);
		contract = ContractAssembler.getDTO(entity);
		return contract;
	}

	@Override
	public Contract get(Integer id) {
		ContractEntity entity = contractDao.get(id);
		Contract contract = ContractAssembler.getDTO(entity);
		return contract;
	}

	@Override
	public Contract update(Contract contract) {
		ContractEntity entity = ContractAssembler.getEntity(contract);
		ContractEntity entityUp = contractDao.update(entity);
		contract = ContractAssembler.getDTO(entityUp);
		return contract;
	}

	@Override
	public List<Contract> getAll() {
		List<ContractEntity> entityList = contractDao.getAll();
		List<Contract> dtoList = ContractAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public boolean delete(Integer id) {
		return contractDao.delete(id);
	}

	@Override
	public List<Contract> searchContract(ContractSearchBean searchBean) {
		List<ContractEntity> listEntities = contractDao.searchContract(searchBean);
		List<Contract> list = ContractAssembler.getDTOList(listEntities);
		return list;
	}
}
