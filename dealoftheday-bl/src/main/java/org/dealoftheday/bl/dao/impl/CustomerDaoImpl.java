package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.dao.CustomerDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.entities.CustomerEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends GenericDao implements CustomerDao {

	@Override
	public CustomerEntity insert(CustomerEntity customerEntity) {
		entityManager.persist(customerEntity);
		return customerEntity;
	}

	@Override
	public CustomerEntity get(Integer id) {
		CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, id);
		return customerEntity;
	}

	@Override
	public CustomerEntity update(CustomerEntity customerEntity) {
		entityManager.merge(customerEntity);
		return customerEntity;
	}

	@Override
	public List<CustomerEntity> getAll() {
		List<CustomerEntity> customers = entityManager.createQuery("from CustomerEntity", CustomerEntity.class)
				.getResultList();
		return customers;
	}

	@Override
	public boolean delete(Integer id) {
		CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, id);
		if (customerEntity != null) {
			entityManager.remove(customerEntity);
			return true;
		}
		return false;
	}
}
