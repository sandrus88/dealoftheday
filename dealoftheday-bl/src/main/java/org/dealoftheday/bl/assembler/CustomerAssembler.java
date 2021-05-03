package org.dealoftheday.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.entities.CustomerEntity;

public class CustomerAssembler {

	public static final int ENABLE_1 = 1;
	public static final int ENABLE_0 = 0;

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
		dto.setSex(entity.getSex());
		dto.setActive(getBooleanFromInt(entity.getActive()));
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
		entity.setSex(dto.getSex());
		entity.setActive(getIntFromBoolean(dto.getActive()));
		return entity;
	}

	public static boolean getBooleanFromInt(int i) {
		if (i == ENABLE_1) {
			return true;
		}
		return false;
	}

	public static int getIntFromBoolean(Boolean b) {
		if (b != null && b) {
			return ENABLE_1;
		}
		return ENABLE_0;
	}

	public static List<Customer> getDTOList(List<CustomerEntity> entityList) {
		List<Customer> list = new ArrayList<>();
		for (CustomerEntity entity : entityList) {
			list.add(getDTO(entity));
		}
		return list;
	}
}
