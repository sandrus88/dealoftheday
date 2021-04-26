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
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.service.CityService;
import org.dealoftheday.bl.service.PartnerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CityServiceTest extends AbstractSpringTest {
	
	@Autowired
	private CityService cityService;
	@Autowired
	private PartnerService partnerService;
	
	@Test
	public void test_getCity_withoutPartners() {
		// Given
		final String cityId = "NA";

		// When
		City city = cityService.get(cityId);

		// Then
		assertNotNull(city);
		assertEquals("Napoli", city.getName());
		assertEquals(new Double(40.85631), city.getLat());
		assertEquals(new Double(14.24641), city.getLng());
	}
	
	@Test
	public void test_getCity_withPartners() {
		// Given
		final String cityId = "MI";
		final Partner partner = new Partner(1, "Partner1", "Indirizzo Partner1", "Tel Partner1", "Cell Partner1", "partner1@hotmail.it", "Sito Partner1", cityId);

		// When
		City city = cityService.get(cityId);

		// Then
		assertNotNull(city);
		assertNotNull(city.getPartners());
		assertEquals(3, city.getPartners().size());

		assertNotNull(city.getPartners().get(0));
		assertEquals(partner, city.getPartners().get(0));
	}

	@Test
	public void test_getAllCities() {
		// When
		List<City> cities = cityService.getAll();

		// Then
		assertNotNull(cities);
		assertEquals(10, cities.size());
		assertEquals("AO", cities.get(9).getId());
		assertEquals("Aosta", cities.get(9).getName());
		assertEquals(new Double(45.73764), cities.get(9).getLat());
		assertEquals(new Double(7.31722), cities.get(9).getLng());
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
		final String cityId = "FI";

		// When
		City city = cityService.get(cityId);
		updateCity(city);
		city = cityService.update(city);
		City cityDb = cityService.get(city.getId());

		// Then
		assertEquals(cityDb, city);
		assertNotNull(cityDb.getPartners());
		assertEquals(3, cityDb.getPartners().size());
		assertEquals(new Integer(2), cityDb.getPartners().get(0).getId());
		assertEquals("Partner2", cityDb.getPartners().get(0).getName());
	}
	
	@Test
	public void test_updateCity_addPartners() {
		// Given
		final String cityId = "BA";
		Partner partner = new Partner(200, "Partner16", "Indirizzo Partner16", "Tel Partner16", "Cell Partner16", "partner16@hotmail.it", "Sito Partner16", null);
		Partner partner2 = new Partner(201, "Partner17", "Indirizzo Partner17", "Tel Partner17", "Cell Partner17", "partner17@hotmail.it", "Sito Partner17", null);
		Partner partner3 = new Partner(202, "Partner18", "Indirizzo Partner18", "Tel Partner18", "Cell Partner18", "partner18@hotmail.it", "Sito Partner18", null);

		// When
		City city = cityService.get(cityId);
		city.addPartner(partner);
		city.addPartner(partner2);
		city.addPartner(partner3);
		city = cityService.update(city);
		City cityDb = cityService.get(cityId);

		// Then
		assertEquals(cityDb, city);
		assertNotNull(cityDb.getPartners());
		assertEquals(3, cityDb.getPartners().size());
	}
	
	@Test
	public void test_updateCity_removePartners() {
		// Given
		final String cityId = "RM";
		Partner partner = new Partner(4, "Partner4", "Indirizzo Partner4", "Tel Partner4", "Cell Partner4", "partner4@hotmail.it", "Sito Partner4", cityId);

		// When
		City city = cityService.get(cityId);
		city.removePartner(partner);
		city = cityService.update(city);
		City cityDb = cityService.get(cityId);

		// Then
		assertEquals(cityDb, city);
		assertNotNull(cityDb.getPartners());
		assertEquals(2, cityDb.getPartners().size());
	}

	@Test
	public void test_deleteCity_withoutPartners() {
		// Given
		final String cityId = "GE";

		// When
		boolean deleting = cityService.delete(cityId);
		City city = cityService.get(cityId);

		// Then
		assertTrue(deleting);
		assertNull(city);
	}
	
	@Test
	public void test_deleteCity_withPartners_shouldRemoveCityButNotPartners() {
		// Given
		final String cityId = "PA";
		final Integer partnerId = 5;

		// When
		boolean deleting = cityService.delete(cityId);
		City city = cityService.get(cityId);
		Partner partner = partnerService.get(partnerId);

		// Then
		assertTrue(deleting);
		assertNull(city);
		assertNotNull(partner);
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
