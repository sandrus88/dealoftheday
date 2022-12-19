package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.DealItem;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.entities.ContractEntity;
import org.dealoftheday.bl.entities.DealItemEntity;
import org.dealoftheday.bl.entities.PartnerEntity;

public class PartnerAssembler {

	private static Logger logger = LogManager.getLogger(PartnerAssembler.class);

	public static Partner getDTO(PartnerEntity entity) {
		if (entity == null) {
			return null;
		}

		Partner dto = new Partner();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());
		dto.setTel(entity.getTel());
		dto.setCell(entity.getCell());
		dto.setEmail(entity.getEmail());
		dto.setWebSite(entity.getWebSite());
		dto.setCategory(CategoryAssembler.getEnum(entity.getCategory()));
		dto.setCity(CityAssembler.getDTO(entity.getCityEntity()));

		for (ContractEntity contractEntity : entity.getContracts()) {
			Contract contract = ContractAssembler.getDTO(contractEntity);
			dto.addContract(contract);
		}
		return dto;
	}

	public static PartnerEntity getEntity(Partner dto) {
		if (dto == null) {
			return null;
		}

		PartnerEntity entity = new PartnerEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setTel(dto.getTel());
		entity.setCell(dto.getCell());
		entity.setEmail(dto.getEmail());
		entity.setWebSite(dto.getWebSite());
		entity.setCategory(CategoryAssembler.getString(dto.getCategory()));
		entity.setCityEntity(CityAssembler.getEntity(dto.getCity()));

		for (Contract contract : dto.getContracts()) {
			ContractEntity contractEntity = ContractAssembler.getEntity(contract);
			entity.addContract(contractEntity);
		}
		return entity;
	}

	public static List<Partner> getDTOList(List<PartnerEntity> entityList) {
		List<Partner> list = new ArrayList<>();
		for (PartnerEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}

}
