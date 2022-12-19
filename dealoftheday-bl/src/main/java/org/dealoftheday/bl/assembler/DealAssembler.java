package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Deal;
import org.dealoftheday.bl.domain.DealItem;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.entities.DealEntity;
import org.dealoftheday.bl.entities.DealItemEntity;
import org.dealoftheday.bl.entities.RoleEntity;

public class DealAssembler {
	
	private static Logger logger = LogManager.getLogger(DealAssembler.class);

	public static Deal getDTO(DealEntity entity) {
		if (entity == null) {
			return null;
		}

		Deal dto = new Deal();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setTitleNewsletter(entity.getTitleNewsletter());
		dto.setMainImgName(entity.getMainImgName());
		dto.setSynthesis(entity.getSynthesis());
		dto.setConditions(entity.getConditions());
		dto.setDescription(entity.getDescription());
		dto.setApprovedDate(entity.getApprovedDate());
		dto.setStatus(StatusAssembler.getEnum(entity.getStatus()));
		dto.setContractComment(entity.getContractComment());
		dto.setLastUpdate(entity.getLastUpdate());
		dto.setLastUpdateUser(entity.getLastUpdateUser());
		dto.setContract(ContractAssembler.getDTO(entity.getContractEntity()));
	
		for (DealItemEntity dealItemEntity : entity.getDealItems()) {
			DealItem dealItem  = DealItemAssembler.getDTO(dealItemEntity);
            dto.addDealItem(dealItem);
        }
		return dto;
	}

	public static DealEntity getEntity(Deal dto) {
		if (dto == null) {
			return null;
		}

		DealEntity entity = new DealEntity();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setTitleNewsletter(dto.getTitleNewsletter());
		entity.setMainImgName(dto.getMainImgName());
		entity.setSynthesis(dto.getSynthesis());
		entity.setConditions(dto.getConditions());
		entity.setDescription(dto.getDescription());
		entity.setApprovedDate(dto.getApprovedDate());
		entity.setStatus(StatusAssembler.getString(dto.getStatus()));
		entity.setContractComment(dto.getContractComment());
		entity.setLastUpdate(dto.getLastUpdate());
		entity.setLastUpdateUser(dto.getLastUpdateUser());
		entity.setContractEntity(ContractAssembler.getEntity(dto.getContract()));
		
		 for (DealItem dealItem : dto.getDealItems()) {
			 DealItemEntity dealItemEntity  = DealItemAssembler.getEntity(dealItem);
	            entity.addDealItem(dealItemEntity);
	        }
		return entity;
	}

	public static List<Deal> getDTOList(List<DealEntity> entityList) {
		List<Deal> list = new ArrayList<>();
		for (DealEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}

}
