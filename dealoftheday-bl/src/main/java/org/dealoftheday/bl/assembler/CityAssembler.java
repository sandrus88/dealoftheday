package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.entities.CityEntity;
import org.dealoftheday.bl.entities.PartnerEntity;

public class CityAssembler {
	
	public static City getDTO(CityEntity entity) {
		if (entity == null) {
			return null;
		}

		City dto = new City();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setLat(entity.getLat());
		dto.setLng(entity.getLng());
		return dto;
	}

	public static CityEntity getEntity(City dto) {
		if (dto == null) {
			return null;
		}
		
		CityEntity entity = new CityEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setLat(dto.getLat());
		entity.setLng(dto.getLng());
		return entity;
	}

	public static List<City> getDTOList(List<CityEntity> entityList) {
		List<City> list = new ArrayList<>();
		for (CityEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}
}
