package org.dealoftheday.bl.test;

import static org.dealoftheday.bl.test.util.TestUtils.createDeal;
import static org.dealoftheday.bl.test.util.TestUtils.updateDeal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.Deal;
import org.dealoftheday.bl.domain.DealSearchBean;
import org.dealoftheday.bl.domain.Status;
import org.dealoftheday.bl.service.ContractService;
import org.dealoftheday.bl.service.DealService;
import org.dealoftheday.bl.service.PartnerService;
import org.dealoftheday.bl.test.util.TestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DealServiceTest extends AbstractSpringTest {
	
	@Autowired
	private DealService dealService;
	
	@Autowired
	private ContractService contractService;
	
	@Test
	public void test_getDeal() throws ParseException {
		// Given
		final Integer dealId = 1;
		
		// When
		Deal deal = dealService.get(dealId);

		// Then
		assertNotNull(deal);
		assertEquals("Hotel Santa Lucia 4 stelle", deal.getTitle());
		assertEquals("Newsletter Hotel Santa Lucia", deal.getTitleNewsletter());
		assertEquals("Img Hotel Santa Lucia", deal.getMainImgName());
		assertEquals("Synthesis deal 1", deal.getSynthesis());
		assertEquals("Conditions deal 1", deal.getConditions());
		assertEquals("Description deal 1", deal.getDescription());
		assertEquals(Status.DEAL_INSERTED, deal.getStatus());
		assertEquals("Comment about deal 1", deal.getContractComment());
		assertEquals(TestUtils.formatDate("02/01/2021"), deal.getApprovedDate());
		assertEquals(new Integer(1), deal.getContract().getId());
		assertEquals("Client1", deal.getContract().getClientFullName());
	}

	@Test
	public void test_getAllDeals() {

		// When
		List<Deal> deals = dealService.getAll();

		// Then
		assertNotNull(deals);
		assertEquals(5, deals.size());
		assertEquals(new Integer(5), deals.get(4).getId());
		assertEquals("Percorso Benessere per 2", deals.get(4).getTitle());
	}

	@Test
	public void test_getDeal_notPresent() {
		// Given
		final Integer dealId = -1;

		// When
		Deal deal = dealService.get(dealId);

		// Then
		assertNull(deal);
	}

	@Test
	public void test_searchAllDeals() throws ParseException {
		// Given
		DealSearchBean searchBean = new DealSearchBean();

		// When
		List<Deal> deals = dealService.searchDeal(searchBean);

		// Then
		assertEquals(5, deals.size());
		assertEquals("Hotel Santa Lucia 4 stelle", deals.get(4).getTitle());
		assertEquals("Newsletter Hotel Santa Lucia", deals.get(4).getTitleNewsletter());
		assertEquals("Img Hotel Santa Lucia", deals.get(4).getMainImgName());
		assertEquals("Synthesis deal 1", deals.get(4).getSynthesis());
		assertEquals("Conditions deal 1", deals.get(4).getConditions());
		assertEquals("Description deal 1", deals.get(4).getDescription());
		assertEquals(Status.DEAL_INSERTED, deals.get(4).getStatus());
		assertEquals("Comment about deal 1", deals.get(4).getContractComment());
		assertEquals(TestUtils.formatDate("02/01/2021"), deals.get(4).getApprovedDate());
		assertEquals(new Integer(1), deals.get(4).getContract().getId());
		assertEquals("Client1", deals.get(4).getContract().getClientFullName());
	}

	@Test
	public void test_searchDeals_fullMatch() throws ParseException {
		// Given
		final Integer contractId = 1;
		DealSearchBean searchBean = new DealSearchBean();
		Contract contract = contractService.get(contractId);
		searchBean.setIdSearch(1);
		searchBean.setTitleSearch("Hotel Santa Lucia 4 stelle");
		searchBean.setApprovedDateFrom(TestUtils.formatDate("01/01/2021"));
		searchBean.setApprovedDateTo(TestUtils.formatDate("03/01/2021"));
		searchBean.setStatusSearch(Status.DEAL_INSERTED);
		searchBean.setContractSearch(contract);

		// When
		List<Deal> list = dealService.searchDeal(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchDeals_fullSearch_partialMatch() throws ParseException {
		//Given
		final Integer contractId = 1;
		DealSearchBean searchBean = new DealSearchBean();
		Contract contract = contractService.get(contractId);
		searchBean.setIdSearch(1);
		searchBean.setTitleSearch("HoteL saNta LUcia 4 StElle");
		searchBean.setStatusSearch(Status.DEAL_INSERTED);
		searchBean.setContractSearch(contract);

		// When
		List<Deal> list = dealService.searchDeal(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
	@Test
	public void test_searchDeals_byId() {
		// Given
		DealSearchBean searchBean = new DealSearchBean();
		searchBean.setIdSearch(2);

		// When
		List<Deal> list = dealService.searchDeal(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
	@Test
	public void test_searchDeals_byTitle() {
		// Given
		DealSearchBean searchBean = new DealSearchBean();
		searchBean.setTitleSearch("Cena per 2");

		// When
		List<Deal> list = dealService.searchDeal(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
	@Test
	public void test_searchDeals_byRangeDate() throws ParseException {
		// Given
		DealSearchBean searchBean = new DealSearchBean();
		searchBean.setApprovedDateFrom(TestUtils.formatDate("01/01/2021"));
		searchBean.setApprovedDateTo(TestUtils.formatDate("10/05/2021"));
		// When
		List<Deal> list = dealService.searchDeal(searchBean);

		// Then
		assertEquals(5, list.size());
	}
	
	@Test
	public void test_searchDeals_byStatus() {
		// Given
		DealSearchBean searchBean = new DealSearchBean();
		searchBean.setStatusSearch(Status.DEAL_INSERTED);

		// When
		List<Deal> list = dealService.searchDeal(searchBean);

		// Then
		assertEquals(2, list.size());
		
		searchBean.setStatusSearch(Status.DEAL_APPROVED);
		list = dealService.searchDeal(searchBean);
		assertEquals(2, list.size());
		
		searchBean.setStatusSearch(Status.DEAL_EDITED);
		list = dealService.searchDeal(searchBean);
		assertEquals(1, list.size());
		
		searchBean.setStatusSearch(Status.DEAL_PUBLISHED);
		list = dealService.searchDeal(searchBean);
		assertEquals(0, list.size());
		
		searchBean.setStatusSearch(Status.CONTRACT_INSERTED);
		list = dealService.searchDeal(searchBean);
		assertEquals(0, list.size());
	}
	
//	@Test
//	public void test_searchDeals_byContract() {
//		// Given
//		DealSearchBean searchBean = new DealSearchBean();
//		searchBean.setClientFullNameSearch("Client2");
//
//		// When
//		List<Deal> list = dealService.searchDeal(searchBean);
//
//		// Then
//		assertEquals(1, list.size());
//	}

	@Test
	public void test_insertDeal() throws ParseException {
		// Given
		Deal deal = createDeal();

		// When
		deal = dealService.insert(deal);
		Deal dealDb = dealService.get(deal.getId());

		// Then
		assertEquals(dealDb, deal);
	}

	@Test
	public void test_updateDeal() throws ParseException {
		// Given
		final Integer dealId = 2;

		// When
		Deal deal = dealService.get(dealId);
		updateDeal(deal);
		deal = dealService.update(deal);
		Deal dealDb = dealService.get(dealId);

		// Then
		assertEquals(dealDb, deal);
	}

	@Test
	public void test_deleteDeal() {
		// Given
		final Integer dealId = 3;

		// When
		boolean deleting = dealService.delete(dealId);
		Deal deal = dealService.get(dealId);

		// Then
		assertTrue(deleting);
		assertNull(deal);
	}

	@Test
	public void test_deleteDeal_notPresent() {
		// Given
		final Integer dealId = -1;

		// When
		boolean deleting = dealService.delete(dealId);

		// Then
		assertFalse(deleting);
	}

	@Test
	public void test_deal_integrationTest_CRUD() throws ParseException {
		// 1. insert a new deal
		Deal deal = createDeal();
		deal = dealService.insert(deal);
		assertNotNull(deal.getId());

		// 2. get the deal from DB
		Deal dealDb = dealService.get(deal.getId());
		assertNotNull(dealDb);
		assertEquals(dealDb, deal);

		// 3. Update the deal in DB, and Get to check if updated correctly
		updateDeal(deal);
		deal = dealService.update(deal);
		dealDb = dealService.get(deal.getId());
		assertEquals(dealDb, deal);

		// 4. Delete the deal from DB, and Get to check if deleted correctly
		boolean isRemoved = dealService.delete(deal.getId());
		assertTrue(isRemoved);
		dealDb = dealService.get(deal.getId());
		assertNull(dealDb);
	}

}
