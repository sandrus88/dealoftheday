package org.dealoftheday.bl.test.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dealoftheday.bl.domain.Category;
import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.domain.User;

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
		city.setId("FI");
		city.setName("New City");
		city.setLat(0.1f);
		city.setLng(0.1f);
		return city;
	}

	public static City getDefaultCity() {
		City city = new City();
		city.setId("FI");
		city.setName("Firenze");
		city.setLat(new Float(43.77925));
		city.setLng(new Float(11.24626));
		return city;
	}

	public static City updateCity(City city) {
		city.setId("MI");
		city.setName("Updated City");
		city.setLat(1.1f);
		city.setLng(1.1f);
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
		partner.setCategory(Category.ADVENTURE);
		partner.setCity(getDefaultCity());
		return partner;
	}

	public static Partner updatePartner(Partner partner) {
		partner.setName("Updated Partner");
		partner.setAddress("Indirizzo Updated Partner");
		partner.setTel("Tel Updated Partner");
		partner.setCell("Cell Updated Partner");
		partner.setEmail("updated_partner@hotmail.it");
		partner.setWebSite("Sito Updated Partner");
		partner.setCategory(Category.BAR_AND_DRINKS);
		return partner;
	}
	
	public static Partner getDefaultPartner() {
		Partner partner = new Partner();
		partner.setId(1);
		partner.setName("Ristorante la Padellaccia");
		partner.setAddress("Via San Antonino 19/r");
		partner.setTel("055");
		partner.setCell("+39329");
		partner.setEmail("padellaccia@hotmail.it");
		partner.setWebSite("www.lapadellaccia.com");
		partner.setCategory(Category.FOOD_AND_RESTAURANTS);
		partner.setCity(getDefaultCity());
		return partner;
	}

	public static Date formatDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(str);
		return date;
	}

	public static User createUser(String username) {
		User user = new User();
		user.setUserName(username);
		user.setName(username + "Name");
		user.setSurname(username + "Surname");
		user.setEmail(username + "@gmail.com");
		user.setPwd(username);
		user.setEnabled(true);
		user.setLocked(false);
		return user;
	}

	public static User updateUser(User user) {
		user.setName("updatedName");
		user.setSurname("updatedSurname");
		user.setEmail("updatedName_updatedSurname@gmail.com");
		user.setPwd("updatedPwd");
		user.setEnabled(false);
		user.setLocked(true);
		return user;
	}
	
	public static Contract createContract() throws ParseException {
		Contract contract = new Contract();
		contract.setTitle("New Contract");
		contract.setDescription("Description New Contract");
		contract.setPrice(new Float(9.99));
		contract.setDayOfSignature(formatDate("31/12/2020"));
		contract.setPartner(getDefaultPartner());
		return contract;
	}

	public static Contract updateContract(Contract contract) throws ParseException {
		contract.setTitle("Updated Contract");
		contract.setDescription("Description Updated Contract");
		contract.setPrice(new Float(19.99));
		contract.setDayOfSignature(formatDate("01/12/2020"));
		contract.setPartner(getDefaultPartner());
		return contract;
	}
}
