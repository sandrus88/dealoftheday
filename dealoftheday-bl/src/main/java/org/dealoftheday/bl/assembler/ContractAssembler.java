package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.entities.ContractEntity;
import org.dealoftheday.bl.entities.RoleEntity;

public class ContractAssembler {
	
	private static Logger logger = LogManager.getLogger(ContractAssembler.class);

	public static Contract getDTO(ContractEntity entity) {
		if (entity == null) {
			return null;
		}

		Contract dto = new Contract();
		dto.setId(entity.getId());
		dto.setClientFullName(entity.getClientFullName());
		dto.setClientCell(entity.getClientCell());
		dto.setBrokerFullName(entity.getBrokerFullName());
		dto.setBrokerCell(entity.getBrokerCell());
		dto.setSignedDate(entity.getSignedDate());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		dto.setIban(entity.getIban());
		dto.setContractComment(entity.getContractComment());
		dto.setPartner(PartnerAssembler.getDTO(entity.getPartnerEntity()));
		dto.setDeal(DealAssembler.getDTO(entity.getDealEntity()));
		return dto;
	}

	public static ContractEntity getEntity(Contract dto) {
		if (dto == null) {
			return null;
		}

		ContractEntity entity = new ContractEntity();
		entity.setId(dto.getId());
		entity.setClientFullName(dto.getClientFullName());
		entity.setClientCell(dto.getClientCell());
		entity.setBrokerFullName(dto.getBrokerFullName());
		entity.setBrokerCell(dto.getBrokerCell());
		entity.setSignedDate(dto.getSignedDate());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setIban(dto.getIban());
		entity.setContractComment(dto.getContractComment());
		entity.setPartnerEntity(PartnerAssembler.getEntity(dto.getPartner()));
		entity.setDealEntity(DealAssembler.getEntity(dto.getDeal()));
		return entity;
	}

	public static List<Contract> getDTOList(List<ContractEntity> entityList) {
		List<Contract> list = new ArrayList<>();
		for (ContractEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}
}
