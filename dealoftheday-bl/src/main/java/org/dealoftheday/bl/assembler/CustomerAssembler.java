package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.entities.CustomerEntity;

public class CustomerAssembler {
	
	public static Customer getDTO(CustomerEntity entity) {
		if (entity == null) {
			return null;
		}

		Customer dto = new Customer();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setBirthDate(entity.getBirthDate());
		dto.setEmail(entity.getEmail());
		dto.setPwd(entity.getPwd());
		dto.setTel(entity.getTel());
		return dto;
	}

	public static CustomerEntity getEntity(Customer dto) {
		if (dto == null) {
			return null;
		}
		
		CustomerEntity entity = new CustomerEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setBirthDate(dto.getBirthDate());
		entity.setEmail(dto.getEmail());
		entity.setPwd(dto.getPwd());
		entity.setTel(dto.getTel());
		return entity;
	}

	public static List<Customer> getDTOList(List<CustomerEntity> entityList) {
		List<Customer> list = new ArrayList<>();
		for (CustomerEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}
}
