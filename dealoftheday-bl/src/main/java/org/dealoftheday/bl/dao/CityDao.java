package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.entities.CityEntity;

public interface CityDao {
	CityEntity insert(CityEntity cityEntity);

	CityEntity get(String id);

	CityEntity update(CityEntity cityEntity);

	List<CityEntity> getAll();

	boolean delete(String id);

	List<CityEntity> searchCity(City searchDto);
}
