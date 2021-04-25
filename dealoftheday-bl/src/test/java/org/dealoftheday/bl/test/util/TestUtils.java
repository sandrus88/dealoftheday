package org.dealoftheday.bl.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.domain.Customer;

public class TestUtils {

	public static Customer createCustomer() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse("01/01/2000");
		Customer customer = new Customer();
		customer.setName("newName");
		customer.setSurname("newSurname");
		customer.setBirthDate(date);
		customer.setEmail("newName_newSurname@gmail.com");
		customer.setPwd("newPwd");
		customer.setTel("0000000");
		return customer;
	}

	public static Customer updateCustomer(Customer customer) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse("31/12/2000");
		customer.setName("updatedName");
		customer.setSurname("updatedSurname");
		customer.setBirthDate(date);
		customer.setEmail("updatedName_updatedSurname@gmail.com");
		customer.setPwd("updatedPwd");
		customer.setTel("9999999");
		return customer;
	}
	
	public static City createCity() {
		City city = new City();
		city.setId("NC");
		city.setName("New City");
		city.setLate(0.1);
		city.setLng(0.1);
		return city;
	}
	
	public static City updateCity(City city) {
		city.setId("UC");
		city.setName("Updated City");
		city.setLate(1.1);
		city.setLng(1.1);
		return city;
	}
}
