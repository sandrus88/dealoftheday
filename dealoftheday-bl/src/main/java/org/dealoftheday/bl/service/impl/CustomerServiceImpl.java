package org.dealoftheday.bl.service.impl;

import java.util.List;

import org.dealoftheday.bl.assembler.CustomerAssembler;
import org.dealoftheday.bl.dao.CustomerDao;
import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.entities.CustomerEntity;
import org.dealoftheday.bl.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	final private CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer insert(Customer customer) {
		CustomerEntity customerEntity = CustomerAssembler.getEntity(customer);
		customerEntity = customerDao.insert(customerEntity);
		customer = CustomerAssembler.getDTO(customerEntity);
		return customer;
	}

	@Override
	public Customer get(Integer id) {
		CustomerEntity customerEntity = customerDao.get(id);
		Customer customer = CustomerAssembler.getDTO(customerEntity);
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		CustomerEntity customerEntity = CustomerAssembler.getEntity(customer);
		CustomerEntity customerEntityUp = customerDao.update(customerEntity);
		customer = CustomerAssembler.getDTO(customerEntityUp);
		return customer;
	}

	@Override
	public List<Customer> getAll() {
		List<CustomerEntity> entityList = customerDao.getAll();
		List<Customer> dtoList = CustomerAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public boolean delete(Integer id) {
		return customerDao.delete(id);
	}
}
