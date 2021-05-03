package org.dealoftheday.bl.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.domain.Partner;

public class TestUtils {

	public static Customer createCustomer() throws ParseException {
		Customer customer = new Customer();
		customer.setName("newName");
		customer.setSurname("newSurname");
		customer.setBirthDate(formatDate("01/01/2000"));
		customer.setEmail("newName_newSurname@gmail.com");
		customer.setPwd("newPwd");
		customer.setTel("0000000");
		customer.setSex("F");
		customer.setActive(false);
		return customer;
	}

	public static Customer updateCustomer(Customer customer) throws ParseException {
		customer.setName("updatedName");
		customer.setSurname("updatedSurname");
		customer.setBirthDate(formatDate("31/12/2000"));
		customer.setEmail("updatedName_updatedSurname@gmail.com");
		customer.setPwd("updatedPwd");
		customer.setTel("9999999");
		customer.setSex("M");
		customer.setActive(true);
		return customer;
	}

	public static City createCity() {
		City city = new City();
		city.setId("NC");
		city.setName("New City");
		city.setLat(0.1);
		city.setLng(0.1);
		return city;
	}

	public static City updateCity(City city) {
		city.setId("UC");
		city.setName("Updated City");
		city.setLat(1.1);
		city.setLng(1.1);
		return city;
	}

	public static Partner createPartner() {
		Partner partner = new Partner();
		partner.setName("New Partner");
		partner.setAddress("Indirizzo New Partner");
		partner.setTel("Tel New Partner");
		partner.setCell("Cell New Partner");
		partner.setEmail("new_partner@hotmail.it");
		partner.setWebSite("Sito New Partner");
		partner.setCityId("MI");
		return partner;
	}

	public static Partner updatePartner(Partner partner) {
		partner.setName("Updated Partner");
		partner.setAddress("Indirizzo Updated Partner");
		partner.setTel("Tel Updated Partner");
		partner.setCell("Cell Updated Partner");
		partner.setEmail("updated_partner@hotmail.it");
		partner.setWebSite("Sito Updated Partner");
		return partner;
	}
	
	public static Date formatDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(str);
		return date;
	}
}
