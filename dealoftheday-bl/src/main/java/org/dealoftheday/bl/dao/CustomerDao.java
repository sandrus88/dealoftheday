package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.entities.CustomerEntity;


public interface CustomerDao {
	CustomerEntity insert(CustomerEntity customerEntity);

	CustomerEntity get(Integer id);

	CustomerEntity update(CustomerEntity customerEntity);

    List<CustomerEntity> getAll();

    boolean delete(Integer id);

}
