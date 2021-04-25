package org.dealoftheday.bl.test;

import static org.dealoftheday.bl.test.util.TestUtils.createCity;
import static org.dealoftheday.bl.test.util.TestUtils.updateCity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.service.CityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CityServiceTest extends AbstractSpringTest {
	
	@Autowired
	private CityService cityService;
	
	@Test
	public void test_getCity() {
		// Given
		final String cityId = "MI";

		// When
		City city = cityService.get(cityId);

		// Then
		assertNotNull(city);
		assertEquals("Milano", city.getName());
		assertEquals(new Double(45.46427), city.getLate());
		assertEquals(new Double(9.18951), city.getLng());
	}

	@Test
	public void test_getAllCities() {
		// When
		List<City> cities = cityService.getAll();

		// Then
		assertNotNull(cities);
		assertEquals(5, cities.size());
		assertEquals("BR", cities.get(4).getId());
		assertEquals("Berlino", cities.get(4).getName());
		assertEquals(new Double(52.52437), cities.get(4).getLate());
		assertEquals(new Double(13.41053), cities.get(4).getLng());
	}

	@Test
	public void test_getCity_notPresent() {
		// Given
		final String cityId = "";

		// When
		City city = cityService.get(cityId);

		// Then
		assertNull(city);
	}

	@Test
	public void test_insertCity() {
		// Given
		City city = createCity();

		// When
		city = cityService.insert(city);
		City cityDb = cityService.get(city.getId());

		// Then
		assertEquals(cityDb, city);
	}

	@Test
	public void test_updateCity() {
		// Given
		final String cityId = "bx";

		// When
		City city = cityService.get(cityId);
		updateCity(city);
		city = cityService.update(city);
		City cityDb = cityService.get(city.getId());

		// Then
		assertEquals(cityDb, city);
	}

	@Test
	public void test_deleteCity() {
		// Given
		final String cityId = "pa";

		// When
		boolean deleting = cityService.delete(cityId);
		City city = cityService.get(cityId);

		// Then
		assertTrue(deleting);
		assertNull(city);
	}

	@Test
	public void test_deleteCity_notPresent() {
		// Given
		final String cityId = "";

		// When
		boolean deleting = cityService.delete(cityId);

		// Then
		assertFalse(deleting);
	}

	@Test
	public void test_city_integrationTest_CRUD() {
		// 1. insert a new city in DB
		City city = createCity();
		city = cityService.insert(city);
		assertNotNull(city.getId());

		// 2. get the city from DB
		City cityDb = cityService.get(city.getId());
		assertNotNull(cityDb);
		assertEquals(cityDb, city);

		// 3. Update the city in DB, and Get to check if updated correctly
		updateCity(city);
		city = cityService.update(city);
		cityDb = cityService.get(city.getId());
		assertEquals(cityDb, city);

		// 4. Delete the city from DB, and Get to check if deleted correctly
		boolean isRemoved = cityService.delete(city.getId());
		assertTrue(isRemoved);
		cityDb = cityService.get(city.getId());
		assertNull(cityDb);
	}
}
