package org.dealoftheday.bl.dao.impl;

import java.util.List;

import org.dealoftheday.bl.assembler.CustomerAssembler;
import org.dealoftheday.bl.dao.CustomerDao;
import org.dealoftheday.bl.dao.GenericDao;
import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.entities.CustomerEntity;
import org.dealoftheday.bl.util.SGUtil;
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
		CustomerEntity customerEntity = get(id);
		if (customerEntity != null) {
			entityManager.remove(customerEntity);
			return true;
		}
		return false;
	}
	
	@Override
	public List<CustomerEntity> searchCustomer(Customer searchDto) {
		String sql = "select c from CustomerEntity c ";
		sql += "where 1=1";
		if (searchDto.getId() != null) {
			sql += "and c.id = '" + searchDto.getId() + "'";
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql += "and upper(c.name) like upper('%" + searchDto.getName() + "%')";
		}
		if (!SGUtil.isEmpty(searchDto.getSurname())) {
			sql += "and upper(c.surname) like upper('%" + searchDto.getSurname() + "%')";
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			sql += "and upper(c.email) like upper('%" + searchDto.getEmail() + "%')";
		}
		if (!SGUtil.isEmpty(searchDto.getTel())) {
			sql += "and upper(c.tel) like upper('%" + searchDto.getTel() + "%')";
		}
		if (!SGUtil.isEmpty(searchDto.getSex())) {
			sql += "and c.sex = '" + searchDto.getSex() + "'";
		}
		if(searchDto.getActive() != null) {
			sql += "and c.active = " + CustomerAssembler.getIntFromBoolean(searchDto.getActive());
		}
		List<CustomerEntity> customers = entityManager.createQuery(sql, CustomerEntity.class).getResultList();
		return customers;
	}
}
