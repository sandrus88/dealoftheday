package org.dealoftheday.bl.test;

import static org.dealoftheday.bl.test.util.TestUtils.createPartner;
import static org.dealoftheday.bl.test.util.TestUtils.updatePartner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.dealoftheday.bl.domain.Category;
import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.service.CityService;
import org.dealoftheday.bl.service.PartnerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PartnerServiceTest extends AbstractSpringTest {
	
	@Autowired
    private PartnerService partnerService;
    
    @Autowired
    private CityService cityService;
    
    @Test
    public void test_getPartner() {
        // Given 
        final Integer partnerId = 1;
        
        // When
        Partner partner = partnerService.get(partnerId);
        
        // Then
        assertNotNull(partner);
        assertEquals("Partner1", partner.getName());
        assertEquals("Indirizzo Partner1", partner.getAddress());
        assertEquals("Tel Partner1", partner.getTel());
        assertEquals("Cell Partner1", partner.getCell());
        assertEquals("partner1@hotmail.it", partner.getEmail());
        assertEquals("Sito Partner1", partner.getWebSite());
        assertEquals(Category.FOOD_AND_RESTAURANTS, partner.getCategory());
        assertEquals("MI", partner.getCity().getId());
    }
    
    @Test
    public void test_getAllPartners() {

        // When
        List<Partner> partners = partnerService.getAll();

        // Then
        assertNotNull(partners);
        assertEquals(30, partners.size());
        assertEquals(new Integer(30), partners.get(29).getId());
        assertEquals("Partner30", partners.get(29).getName());
    }

    @Test
    public void test_getPartner_notPresent() {
        // Given
        final Integer partnerId = -1;
        
        // When
        Partner partner = partnerService.get(partnerId);
        
        // Then
        assertNull(partner);
    }
    
    @Test
	public void test_searchAllPartners() {
		// Given
		Partner searchBean = new Partner();

		// When
		List<Partner> partners = partnerService.searchPartner(searchBean);

		// Then
		assertEquals(30, partners.size());
		assertEquals(new Integer(1), partners.get(0).getId());
		assertEquals("Partner1", partners.get(0).getName());
		assertEquals("Indirizzo Partner1", partners.get(0).getAddress());
		assertEquals("Tel Partner1", partners.get(0).getTel());
		assertEquals("Cell Partner1", partners.get(0).getCell());
		assertEquals("partner1@hotmail.it", partners.get(0).getEmail());
		assertEquals("Sito Partner1", partners.get(0).getWebSite());
		assertEquals(Category.FOOD_AND_RESTAURANTS, partners.get(0).getCategory());
		assertEquals("MI", partners.get(0).getCity().getId());
	}

	@Test
	public void test_searchPartners_fullMatch() {
		// Given
		String cityId = "MI";
		Partner searchBean = new Partner();
		City city = cityService.get(cityId);
		searchBean.setName("Partner1");
		searchBean.setCategory(Category.FOOD_AND_RESTAURANTS);
		searchBean.setCity(city);

		// When
		List<Partner> list = partnerService.searchPartner(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchPartners_fullSearch_partialMatch() {
		// Given
		String cityId = "MI";
		Partner searchBean = new Partner();
		City city = cityService.get(cityId);
		searchBean.setName("pArtnEr1");
		searchBean.setCategory(Category.FOOD_AND_RESTAURANTS);
		searchBean.setCity(city);

		// When
		List<Partner> list = partnerService.searchPartner(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchPartners_byName() {
		// Given
		Partner searchBean = new Partner();
		searchBean.setName("Partner30");

		// When
		List<Partner> list = partnerService.searchPartner(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchPartners_byCategory() {
		// Given
		Partner searchBean = new Partner();
		searchBean.setCategory(Category.ADVENTURE);
		// When
		List<Partner> list = partnerService.searchPartner(searchBean);
		// Then
		assertEquals(2, list.size());

		searchBean.setCategory(Category.BAR_AND_DRINKS);
		list = partnerService.searchPartner(searchBean);
		assertEquals(5, list.size());
		
		searchBean.setCategory(Category.BEAUTY_CARE);
		list = partnerService.searchPartner(searchBean);
		assertEquals(2, list.size());
		
		searchBean.setCategory(Category.CINEMA_THEATER_CONCERT);
		list = partnerService.searchPartner(searchBean);
		assertEquals(3, list.size());
		
		searchBean.setCategory(Category.FOOD_AND_RESTAURANTS);
		list = partnerService.searchPartner(searchBean);
		assertEquals(11, list.size());
		
		searchBean.setCategory(Category.HEALTH_CARE);
		list = partnerService.searchPartner(searchBean);
		assertEquals(3, list.size());
		
		searchBean.setCategory(Category.VISIT_TOURS);
		list = partnerService.searchPartner(searchBean);
		assertEquals(4, list.size());
	}

	@Test
	public void test_searchPartners_byCity() {
		// Given
		String cityId = "PA";
		Partner searchBean = new Partner();
		City city = cityService.get(cityId);
		searchBean.setCity(city);
		// When
		List<Partner> list = partnerService.searchPartner(searchBean);
		// Then
		assertEquals(2, list.size());
	}

    
    @Test
    public void test_insertPartner() {
        // Given
        Partner partner = createPartner();
        
        // When
        partner = partnerService.insert(partner);
        Partner partnerDb = partnerService.get(partner.getId());
        
        // Then
        assertEquals(partnerDb, partner);
    }
    
    @Test
    public void test_updatePartner() {
        //Given
        final Integer partnerId = 2;
        
        //When
        Partner partner = partnerService.get(partnerId);
        updatePartner(partner);
        partner = partnerService.update(partner);
        Partner partnerDb = partnerService.get(partnerId);
        
        //Then
        assertEquals(partnerDb, partner);
    }

    @Test
    public void test_deletePartner() {
    	 // Given
        final Integer partnerId = 3;
        
        // When
        boolean deleting = partnerService.delete(partnerId);
        Partner partner = partnerService.get(partnerId);
        
        // Then
        assertTrue(deleting);
        assertNull(partner);
    }
    
    @Test
    public void test_deletePartner_notPresent() {
        // Given
        final Integer partnerId = -1;
        
        // When
        boolean deleting = partnerService.delete(partnerId);
        
        // Then
        assertFalse(deleting);
    }
    
    @Test
    public void test_partner_integrationTest_CRUD() {
        // 1. insert a new partner
        Partner partner = createPartner();
        partner = partnerService.insert(partner);
        assertNotNull(partner.getId());
        
        // 2. get the partner from DB
        Partner partnerDb = partnerService.get(partner.getId());
        assertNotNull(partnerDb);
        assertEquals(partnerDb, partner);
        
        // 3. Update the partner in DB, and Get to check if updated correctly
        updatePartner(partner);
        partner = partnerService.update(partner);
        partnerDb = partnerService.get(partner.getId());
        assertEquals(partnerDb, partner);
        
        // 4. Delete the partner from DB, and Get to check if deleted correctly
        boolean isRemoved = partnerService.delete(partner.getId());
        assertTrue(isRemoved);
        partnerDb = partnerService.get(partner.getId());
        assertNull(partnerDb);
    }
}
