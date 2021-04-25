package org.dealoftheday.bl.service;

import java.util.List;

import org.dealoftheday.bl.domain.City;

public interface CityService {

	City insert(City city);

	City get(String id);

	City update(City city);

	List<City> getAll();

	boolean delete(String id);

}
