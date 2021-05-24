package org.dealoftheday.bl.test;

import static org.dealoftheday.bl.test.util.TestUtils.createContract;
import static org.dealoftheday.bl.test.util.TestUtils.updateContract;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.ContractSearchBean;
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
	
	@Test
	public void test_getContract_Partner() throws ParseException {
		// Given
		final Integer contractId = 1;

		// When
		Contract contract = contractService.get(contractId);

		// Then
		assertNotNull(contract);
		assertEquals("Client1", contract.getClientFullName());
		assertEquals("Cell Client1", contract.getClientCell());
		assertEquals("Broker1", contract.getBrokerFullName());
		assertEquals("Cell Broker1", contract.getBrokerCell());
		assertEquals(TestUtils.formatDate("01/01/2020"), contract.getSignedDate());
		assertEquals(TestUtils.formatDate("01/02/2020"), contract.getStartDate());
		assertEquals(TestUtils.formatDate("01/03/2020"), contract.getEndDate());
		assertEquals("IT0001", contract.getIban());
		assertEquals("Comment about Contract1", contract.getContractComment());
		assertEquals(new Integer(1), contract.getPartnerId());
	}

	@Test
	public void test_getAllContracts() {

		// When
		List<Contract> contracts = contractService.getAll();

		// Then
		assertNotNull(contracts);
		assertEquals(5, contracts.size());
		assertEquals(new Integer(5), contracts.get(4).getId());
		assertEquals("Client5", contracts.get(4).getClientFullName());
	}

	@Test
	public void test_getContract_notPresent() {
		// Given
		final Integer contractId = -1;

		// When
		Contract contract = contractService.get(contractId);

		// Then
		assertNull(contract);
	}

	@Test
	public void test_searchAllContracts() throws ParseException {
		// Given
		ContractSearchBean searchBean = new ContractSearchBean();

		// When
		List<Contract> contracts = contractService.searchContract(searchBean);

		// Then
		assertEquals(5, contracts.size());
		assertEquals("Client1", contracts.get(4).getClientFullName());
		assertEquals("Cell Client1", contracts.get(4).getClientCell());
		assertEquals("Broker1", contracts.get(4).getBrokerFullName());
		assertEquals("Cell Broker1", contracts.get(4).getBrokerCell());
		assertEquals(TestUtils.formatDate("01/01/2020"), contracts.get(4).getSignedDate());
		assertEquals(TestUtils.formatDate("01/02/2020"), contracts.get(4).getStartDate());
		assertEquals(TestUtils.formatDate("01/03/2020"), contracts.get(4).getEndDate());
		assertEquals("IT0001", contracts.get(4).getIban());
		assertEquals("Comment about Contract1", contracts.get(4).getContractComment());
		assertEquals(new Integer(1), contracts.get(4).getPartnerId());
	}

	@Test
	public void test_searchContracts_fullMatch() throws ParseException {
		// Given
		ContractSearchBean searchBean = new ContractSearchBean();
		searchBean.setIdSearch(5);
		searchBean.setClientFullNameSearch("Client5");
		searchBean.setBrokerFullNameSearch("Broker5");
		searchBean.setSignedDateFrom(TestUtils.formatDate("04/01/2020"));
		searchBean.setSignedDateTo(TestUtils.formatDate("06/01/2020"));

		// When
		List<Contract> list = contractService.searchContract(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchContracts_fullSearch_partialMatch() throws ParseException {
		//Given
		ContractSearchBean searchBean = new ContractSearchBean();
		searchBean.setIdSearch(5);
		searchBean.setClientFullNameSearch("CLienT5");
		searchBean.setBrokerFullNameSearch("BroKeR5");
		searchBean.setSignedDateFrom(TestUtils.formatDate("04/01/2020"));
		searchBean.setSignedDateTo(TestUtils.formatDate("06/01/2020"));

		// When
		List<Contract> list = contractService.searchContract(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
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
	
	@Test
	public void test_searchContracts_byClientFullName() {
		// Given
		ContractSearchBean searchBean = new ContractSearchBean();
		searchBean.setClientFullNameSearch("Client2");

		// When
		List<Contract> list = contractService.searchContract(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
	@Test
	public void test_searchContracts_byBrokerFullName() {
		// Given
		ContractSearchBean searchBean = new ContractSearchBean();
		searchBean.setBrokerFullNameSearch("Broker2");

		// When
		List<Contract> list = contractService.searchContract(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
	@Test
	public void test_searchContracts_byRangeDate() throws ParseException {
		// Given
		ContractSearchBean searchBean = new ContractSearchBean();
		searchBean.setSignedDateFrom(TestUtils.formatDate("01/01/2020"));
		searchBean.setSignedDateTo(TestUtils.formatDate("05/01/2020"));
		// When
		List<Contract> list = contractService.searchContract(searchBean);

		// Then
		assertEquals(5, list.size());
	}


	@Test
	public void test_insertContract() throws ParseException {
		// Given
		Contract contract = createContract();

		// When
		contract = contractService.insert(contract);
		Contract contractDb = contractService.get(contract.getId());

		// Then
		assertEquals(contractDb, contract);
	}

	@Test
	public void test_updateContract() throws ParseException {
		// Given
		final Integer contractId = 2;

		// When
		Contract contract = contractService.get(contractId);
		updateContract(contract);
		contract = contractService.update(contract);
		Contract contractDb = contractService.get(contractId);

		// Then
		assertEquals(contractDb, contract);
	}

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

	@Test
	public void test_contract_integrationTest_CRUD() throws ParseException {
		// 1. insert a new contract
		Contract contract = createContract();
		contract = contractService.insert(contract);
		assertNotNull(contract.getId());

		// 2. get the contract from DB
		Contract contractDb = contractService.get(contract.getId());
		assertNotNull(contractDb);
		assertEquals(contractDb, contract);

		// 3. Update the contract in DB, and Get to check if updated correctly
		updateContract(contract);
		contract = contractService.update(contract);
		contractDb = contractService.get(contract.getId());
		assertEquals(contractDb, contract);

		// 4. Delete the contract from DB, and Get to check if deleted correctly
		boolean isRemoved = contractService.delete(contract.getId());
		assertTrue(isRemoved);
		contractDb = contractService.get(contract.getId());
		assertNull(contractDb);
	}
}
