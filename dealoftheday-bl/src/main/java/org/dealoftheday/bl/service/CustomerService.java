package org.dealoftheday.bl.service;

import java.util.List;

import org.dealoftheday.bl.domain.Customer;

public interface CustomerService {
	Customer insert(Customer customer);

	Customer get(Integer id);

	Customer update(Customer customer);

    List<Customer> getAll();

    boolean delete(Integer id);
}
