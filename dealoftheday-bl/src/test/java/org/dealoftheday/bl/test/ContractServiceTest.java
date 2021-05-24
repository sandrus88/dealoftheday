package org.dealoftheday.bl.test;

//import static org.dealoftheday.bl.test.util.TestUtils.createContract;
//import static org.dealoftheday.bl.test.util.TestUtils.updateContract;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.ContractSearchBean;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.service.ContractService;
import org.dealoftheday.bl.service.PartnerService;
import org.dealoftheday.bl.test.util.TestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ContractServiceTest extends AbstractSpringTest {
	
	@Autowired
	private PartnerService partnerService;

	@Autowired
	private ContractService contractService;
	
//	@Test
//	public void test_getContract_Partner() throws ParseException {
//		// Given
//		final Integer contractId = 1;
//
//		// When
//		Contract contract = contractService.get(contractId);
//
//		// Then
//		assertNotNull(contract);
//		assertEquals("Contract n 1", contract.getTitle());
//		assertEquals("Description of Contract n 1", contract.getDescription());
//		assertEquals(new Float(49), contract.getPrice());
//		assertEquals(TestUtils.formatDate("30/05/2020"), contract.getDayOfSignature());
//		assertEquals(new Integer(1), contract.getPartner().getId());
//		assertEquals("Ristorante la Padellaccia", contract.getPartner().getName());
//	}
//
//	@Test
//	public void test_getAllContracts() {
//
//		// When
//		List<Contract> contracts = contractService.getAll();
//
//		// Then
//		assertNotNull(contracts);
//		assertEquals(5, contracts.size());
//		assertEquals(new Integer(5), contracts.get(4).getId());
//		assertEquals("Contract n 5", contracts.get(4).getTitle());
//	}

	@Test
	public void test_getContract_notPresent() {
		// Given
		final Integer contractId = -1;

		// When
		Contract contract = contractService.get(contractId);

		// Then
		assertNull(contract);
	}

//	@Test
//	public void test_searchAllContracts() throws ParseException {
//		// Given
//		Contract searchBean = new Contract();
//
//		// When
//		List<Contract> contracts = contractService.searchContract(searchBean);
//
//		// Then
//		assertEquals(5, contracts.size());
//		assertEquals("Contract n 5", contracts.get(0).getTitle());
//		assertEquals("Description of Contract n 5", contracts.get(0).getDescription());
//		assertEquals(new Float(120.79), contracts.get(0).getPrice());
//		assertEquals(TestUtils.formatDate("20/10/2020"), contracts.get(0).getDayOfSignature());
//		assertEquals(new Integer(4), contracts.get(0).getPartner().getId());
//		assertEquals("Viaggiando viaggiando di Lucrezia Rossi", contracts.get(0).getPartner().getName());
//	}
//
//	@Test
//	public void test_searchContracts_fullMatch() throws ParseException {
//		// Given
//		final Integer partnerId = 4;
//		Contract searchBean = new Contract();
//		Partner partner = partnerService.get(partnerId);
//		searchBean.setTitle("Contract n 5");
//		searchBean.setDescription("Description of Contract n 5");
//		searchBean.setPrice(new Float(120.79));
//		searchBean.setDayOfSignature(TestUtils.formatDate("20/10/2020"));
//		searchBean.setPartner(partner);
//
//		// When
//		List<Contract> list = contractService.searchContract(searchBean);
//
//		// Then
//		assertEquals(1, list.size());
//	}
//
//	@Test
//	public void test_searchContracts_fullSearch_partialMatch() throws ParseException {
//		//Given
//		final Integer partnerId = 4;
//		Contract searchBean = new Contract();
//		Partner partner = partnerService.get(partnerId);
//		searchBean.setTitle("contrAcT n 5");
//		searchBean.setDescription("descRiptOon of ConTraCt n 5");
//		searchBean.setPrice(new Float(120.79));
//		searchBean.setDayOfSignature(TestUtils.formatDate("20/10/2020"));
//		searchBean.setPartner(partner);
//
//		// When
//		List<Contract> list = contractService.searchContract(searchBean);
//
//		// Then
//		assertEquals(1, list.size());
//	}
	
	@Test
	public void test_searchContracts_byId() {
		// Given
		ContractSearchBean searchBean = new ContractSearchBean();
		searchBean.setIdSearch(2);

		// When
		List<Contract> list = contractService.searchContract(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
//	@Test
//	public void test_searchContracts_byTitle() {
//		// Given
//		Contract searchBean = new Contract();
//		searchBean.setTitle("Contract n 1");
//
//		// When
//		List<Contract> list = contractService.searchContract(searchBean);
//
//		// Then
//		assertEquals(1, list.size());
//	}
	
	@Test
	public void test_searchContracts_bySignedDate() throws ParseException {
		// Given
		ContractSearchBean searchBean = new ContractSearchBean();
		searchBean.setSignedDateFrom(TestUtils.formatDate("01/01/2020"));
		searchBean.setSignedDateTo(TestUtils.formatDate("03/01/2020"));
		// When
		List<Contract> list = contractService.searchContract(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchContracts_byPartner() {
		// Given
		final Integer partnerId = 1;
		ContractSearchBean searchBean = new ContractSearchBean();
		Partner partner = partnerService.get(partnerId);
		searchBean.setPartnerSearch(partner);
		// When
		List<Contract> list = contractService.searchContract(searchBean);
		// Then
		assertEquals(2, list.size());
	}
//
//	@Test
//	public void test_insertContract() throws ParseException {
//		// Given
//		Contract contract = createContract();
//
//		// When
//		contract = contractService.insert(contract);
//		Contract contractDb = contractService.get(contract.getId());
//
//		// Then
//		assertEquals(contractDb, contract);
//	}

//	@Test
//	public void test_updateContract() throws ParseException {
//		// Given
//		final Integer contractId = 2;
//
//		// When
//		Contract contract = contractService.get(contractId);
//		updateContract(contract);
//		contract = contractService.update(contract);
//		Contract contractDb = contractService.get(contractId);
//
//		// Then
//		assertEquals(contractDb, contract);
//	}

	@Test
	public void test_deleteContract() {
		// Given
		final Integer contractId = 3;

		// When
		boolean deleting = contractService.delete(contractId);
		Contract contract = contractService.get(contractId);

		// Then
		assertTrue(deleting);
		assertNull(contract);
	}

	@Test
	public void test_deleteContract_notPresent() {
		// Given
		final Integer contractId = -1;

		// When
		boolean deleting = contractService.delete(contractId);

		// Then
		assertFalse(deleting);
	}

//	@Test
//	public void test_contract_integrationTest_CRUD() throws ParseException {
//		// 1. insert a new contract
//		Contract contract = createContract();
//		contract = contractService.insert(contract);
//		assertNotNull(contract.getId());
//
//		// 2. get the contract from DB
//		Contract contractDb = contractService.get(contract.getId());
//		assertNotNull(contractDb);
//		assertEquals(contractDb, contract);
//
//		// 3. Update the contract in DB, and Get to check if updated correctly
//		updateContract(contract);
//		contract = contractService.update(contract);
//		contractDb = contractService.get(contract.getId());
//		assertEquals(contractDb, contract);
//
//		// 4. Delete the contract from DB, and Get to check if deleted correctly
//		boolean isRemoved = contractService.delete(contract.getId());
//		assertTrue(isRemoved);
//		contractDb = contractService.get(contract.getId());
//		assertNull(contractDb);
//	}
}
