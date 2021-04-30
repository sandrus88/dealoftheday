package org.dealoftheday.bl.test;

import static org.dealoftheday.bl.test.util.TestUtils.createCustomer;
import static org.dealoftheday.bl.test.util.TestUtils.updateCustomer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.service.CustomerService;
import org.dealoftheday.bl.test.util.TestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceTest extends AbstractSpringTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void test_getCustomer() throws ParseException {
		// Given
		final Integer customerId = 1;

		// When
		Customer customer = customerService.get(customerId);

		// Then
		assertNotNull(customer);
		assertEquals("Sandro", customer.getName());
		assertEquals("Gargano", customer.getSurname());
		assertEquals(TestUtils.formatDate("03/05/1988"), customer.getBirthDate());
		assertEquals("sandrus88@hotmail.it", customer.getEmail());
		assertEquals("pwd1", customer.getPwd());
		assertEquals("0601", customer.getTel());
	}

	@Test
	public void test_getAllCustomers() throws ParseException {

		// When
		List<Customer> customers = customerService.getAll();

		// Then
		assertNotNull(customers);
		assertEquals(5, customers.size());
		assertEquals(new Integer(5), customers.get(4).getId());
		assertEquals("Mario", customers.get(4).getName());
		assertEquals("Rossi", customers.get(4).getSurname());
		assertEquals(TestUtils.formatDate("04/10/1975"), customers.get(4).getBirthDate());
		assertEquals("mariorossi@hotmail.it", customers.get(4).getEmail());
		assertEquals("pwd5", customers.get(4).getPwd());
		assertEquals("0605", customers.get(4).getTel());
	}

	@Test
	public void test_getCustomer_notPresent() {
		// Given
		final Integer customerId = -1;

		// When
		Customer customer = customerService.get(customerId);

		// Then
		assertNull(customer);
	}
	
	@Test
	public void test_searchAllCustomers() throws ParseException {
		// Given
		Customer searchBean = new Customer();

		// When
		List<Customer> customers = customerService.searchCustomer(searchBean);

		// Then
		assertEquals(5, customers.size());
		assertEquals(new Integer(5), customers.get(4).getId());
		assertEquals("Mario", customers.get(4).getName());
		assertEquals("Rossi", customers.get(4).getSurname());
		assertEquals("mariorossi@hotmail.it", customers.get(4).getEmail());
		assertEquals("0605", customers.get(4).getTel());
	}

	@Test
	public void test_searchCustomers_fullMatch() throws ParseException {
		// Given
		Customer searchBean = new Customer();
		searchBean.setName("Sandro");
		searchBean.setSurname("Gargano");
		searchBean.setEmail("sandrus88@hotmail.it");
		searchBean.setTel("0601");

		// When
		List<Customer> list = customerService.searchCustomer(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchCustomers_fullSearch_partialMatch() throws ParseException {
		// Given
		Customer searchBean = new Customer();
		searchBean.setName("Sand");
		searchBean.setSurname("GargaNO");
		searchBean.setEmail("sandrUS88@hotmail.it");
		searchBean.setTel("0601");

		// When
		List<Customer> list = customerService.searchCustomer(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchCustomers_byName() {
		// Given
		Customer searchBean = new Customer();
		searchBean.setName("Sandro");

		// When
		List<Customer> list = customerService.searchCustomer(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchCustomers_bySurname() {
		// Given
		Customer searchBean = new Customer();
		searchBean.setSurname("Gargano");
		
		// When
		List<Customer> list = customerService.searchCustomer(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchCustomers_byEmail() {
		// Given
		Customer searchBean = new Customer();
		searchBean.setEmail("sandrus88@hotmail.it");

		// When
		List<Customer> list = customerService.searchCustomer(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchCustomers_byTel() {
		// Given
		Customer searchBean = new Customer();
		searchBean.setTel("0601");;
		
		// When
		List<Customer> list = customerService.searchCustomer(searchBean);
		
		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_insertCustomer() throws ParseException {
		// Given
		Customer customer = createCustomer();

		// When
		customer = customerService.insert(customer);
		Customer customerDb = customerService.get(customer.getId());

		// Then
		assertEquals(customerDb, customer);
	}

	@Test
	public void test_updateCustomer() throws ParseException {
		// Given
		final Integer customerId = 2;

		// When
		Customer customer = customerService.get(customerId);
		updateCustomer(customer);
		customer = customerService.update(customer);
		Customer customerDb = customerService.get(customerId);

		// Then
		assertEquals(customerDb, customer);
	}

	@Test
	public void test_deleteCustomer() {
		// Given
		final Integer customerId = 3;

		// When
		boolean deleting = customerService.delete(customerId);
		Customer customer = customerService.get(customerId);

		// Then
		assertTrue(deleting);
		assertNull(customer);
	}

	@Test
	public void test_deleteCustomer_notPresent() {
		// Given
		final Integer customerId = -1;

		// When
		boolean deleting = customerService.delete(customerId);

		// Then
		assertFalse(deleting);
	}

	@Test
	public void test_customer_integrationTest_CRUD() throws ParseException {
		// 1. insert a new customerEntity in DB
		Customer customer = createCustomer();
		customer = customerService.insert(customer);
		assertNotNull(customer.getId());

		// 2. get the customerEntity from DB
		Customer customerDb = customerService.get(customer.getId());
		assertNotNull(customerDb);
		assertEquals(customerDb, customer);

		// 3. Update the customerEntity in DB, and Get to check if updated correctly
		updateCustomer(customer);
		customer = customerService.update(customer);
		customerDb = customerService.get(customer.getId());
		assertEquals(customerDb, customer);

		// 4. Delete the customerEntity from DB, and Get to check if deleted correctly
		boolean isRemoved = customerService.delete(customer.getId());
		assertTrue(isRemoved);
		customerDb = customerService.get(customer.getId());
		assertNull(customerDb);
	}

}
