package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.DealItem;
import org.dealoftheday.bl.entities.DealItemEntity;

public class DealItemAssembler {
	
	private static Logger logger = LogManager.getLogger(DealItemAssembler.class);

	public static DealItem getDTO(DealItemEntity entity) {
		if (entity == null) {
			return null;
		}

		DealItem dto = new DealItem();
		dto.setId(entity.getId());
		dto.setDealItemTitle(entity.getDealItemTitle());
		dto.setDiscountedPrice(entity.getDiscountedPrice());
		dto.setFullPrice(entity.getFullPrice());
		dto.setCommissionPercentage(entity.getCommissionPercentage());
		dto.setMinCustomers(entity.getMinCustomers());
		dto.setMaxCustomers(entity.getMaxCustomers());
		dto.setTotPurchases(entity.getTotPurchases());
		dto.setDealId(entity.getDealId());
		return dto;
	}

	public static DealItemEntity getEntity(DealItem dto) {
		if (dto == null) {
			return null;
		}

		DealItemEntity entity = new DealItemEntity();
		entity.setId(dto.getId());
		entity.setDealItemTitle(dto.getDealItemTitle());
		entity.setDiscountedPrice(dto.getDiscountedPrice());
		entity.setFullPrice(dto.getFullPrice());
		entity.setCommissionPercentage(dto.getCommissionPercentage());
		entity.setMinCustomers(dto.getMinCustomers());
		entity.setMaxCustomers(dto.getMaxCustomers());
		entity.setTotPurchases(dto.getTotPurchases());
		entity.setDealId(dto.getDealId());
		return entity;
	}

	public static List<DealItem> getDTOList(List<DealItemEntity> entityList) {
		List<DealItem> list = new ArrayList<>();
		for (DealItemEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}
}
