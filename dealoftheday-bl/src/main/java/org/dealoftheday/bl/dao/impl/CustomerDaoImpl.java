package org.dealoftheday.bl.dao.impl;

import java.util.List;

import javax.persistence.Query;

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
		StringBuilder sql = new StringBuilder();
		sql.append("select c from CustomerEntity c");
		sql.append(" where 1=1");
		if (searchDto.getId() != null) {
			sql.append(" and c.id = :id");
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql.append(" and upper(c.name) like upper(:name)");
		}
		if (!SGUtil.isEmpty(searchDto.getSurname())) {
			sql.append(" and upper(c.surname) like upper(:surname)");
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			sql.append(" and upper(c.email) like upper(:email)");
		}
		if (!SGUtil.isEmpty(searchDto.getTel())) {
			sql.append(" and c.tel like :tel");
		}
		if (!SGUtil.isEmpty(searchDto.getSex())) {
			sql.append(" and c.sex = :sex");
		}
		if(searchDto.getActive() != null) {
			sql.append(" and c.active = :active");
		}
		sql.append(" order by c.id desc");
		
		Query query = entityManager.createQuery(sql.toString());
		
		if (searchDto.getId() != null) {
			query = query.setParameter("id", searchDto.getId());
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			query = query.setParameter("name", "%"+searchDto.getName()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getSurname())) {
			query = query.setParameter("surname", "%"+searchDto.getSurname()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getEmail())) {
			query = query.setParameter("email", "%"+searchDto.getEmail()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getTel())) {
			query = query.setParameter("tel", "%"+searchDto.getTel()+"%");
		}
		if (!SGUtil.isEmpty(searchDto.getSex())) {
			query = query.setParameter("sex", searchDto.getSex());
		}
		if (searchDto.getActive() != null) {
			query = query.setParameter("active", CustomerAssembler.getIntFromBoolean(searchDto.getActive()));
		}
		
		@SuppressWarnings("unchecked")
		List<CustomerEntity> customers = query.getResultList();
		return customers;
	}
}
