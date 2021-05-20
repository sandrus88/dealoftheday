package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.entities.ContractEntity;

public class ContractAssembler {
	
	private static Logger logger = LogManager.getLogger(ContractAssembler.class);

	public static Contract getDTO(ContractEntity entity) {
		if (entity == null) {
			return null;
		}

		Contract dto = new Contract();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setPrice(entity.getPrice());
		dto.setDayOfSignature(entity.getDayOfSignature());
		dto.setInsertionDate(entity.getInsertionDate());
		dto.setLastUpdate(entity.getLastUpdate());
		dto.setPartner(PartnerAssembler.getDTO(entity.getPartnerEntity()));
		return dto;
	}

	public static ContractEntity getEntity(Contract dto) {
		if (dto == null) {
			return null;
		}

		ContractEntity entity = new ContractEntity();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setDayOfSignature(dto.getDayOfSignature());
		entity.setInsertionDate(dto.getInsertionDate());
		entity.setLastUpdate(dto.getLastUpdate());
		entity.setPartnerEntity(PartnerAssembler.getEntity(dto.getPartner()));
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
