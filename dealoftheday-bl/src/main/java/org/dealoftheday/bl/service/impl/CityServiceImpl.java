package org.dealoftheday.bl.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.CityAssembler;
import org.dealoftheday.bl.dao.CityDao;
import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.entities.CityEntity;
import org.dealoftheday.bl.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "cityService")
@Transactional
public class CityServiceImpl implements CityService {

	final private CityDao cityDao;
	private static Logger logger = LogManager.getLogger(CityServiceImpl.class);

	@Autowired
	public CityServiceImpl(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public City insert(City city) {
		CityEntity cityEntity = CityAssembler.getEntity(city);
		cityEntity = cityDao.insert(cityEntity);
		city = CityAssembler.getDTO(cityEntity);
		return city;
	}

	@Override
	public City get(String id) {
		CityEntity cityEntity = cityDao.get(id);
		City city = CityAssembler.getDTO(cityEntity);
		return city;
	}

	@Override
	public City update(City city) {
		CityEntity cityEntity = CityAssembler.getEntity(city);
		CityEntity cityEntityUp = cityDao.update(cityEntity);
		city = CityAssembler.getDTO(cityEntityUp);
		return city;
	}

	@Override
	public List<City> getAll() {
		List<CityEntity> entityList = cityDao.getAll();
		List<City> dtoList = CityAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public boolean delete(String id) {
		return cityDao.delete(id);
	}

	@Override
	public List<City> searchCity(City searchDto) {
		List<CityEntity> listEntities = cityDao.searchCity(searchDto);
		List<City> list = CityAssembler.getDTOList(listEntities);
		return list;
	}
}
