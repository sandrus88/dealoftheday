package org.dealoftheday.bl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.dealoftheday.bl.test.util.TestUtils.createPartner;
import static org.dealoftheday.bl.test.util.TestUtils.updatePartner;

import java.util.List;

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
        // Given 1, 
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
    }
    
    @Test
    public void test_getAllPartners() {

        // When
        List<Partner> partners = partnerService.getAll();

        // Then
        assertNotNull(partners);
        assertEquals(15, partners.size());
        assertEquals(new Integer(15), partners.get(14).getId());
        assertEquals("Partner15", partners.get(14).getName());
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
        final String cityId = "TO";
        
        // When
        boolean deleting = partnerService.delete(partnerId);
        Partner partner = partnerService.get(partnerId);
        City city  = cityService.get(cityId);
        
        // Then
        assertTrue(deleting);
        assertNull(partner);
        assertEquals(4, city.getPartners().size());
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
