package org.dealoftheday.admin.backingbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.service.CustomerService;

@ManagedBean
@ViewScoped
public class CustomerController {

	@ManagedProperty(value = "#{customerService}")
	private CustomerService customerService;
	
	private static Logger logger = LogManager.getLogger(CustomerController.class);

	private String newName;
	private String newSurname;
	private Date newBirthDate;
	private String newEmail;
	private String newPwd;
	private String newTel;
	private String newSex;
	private Boolean newActive;
	
	private Integer searchId;
	private String searchName;
	private String searchSurname;
	private String searchEmail;
	private String searchTel;
	private String searchSex;
	private Boolean searchActive;

	private List<Customer> customerList = new ArrayList<>();
	private Customer selectedCustomer;

	@PostConstruct
	public void init() {
		searchCustomer();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void searchCustomer() {
		Customer searchDto = new Customer(searchId, searchName, searchSurname, null, searchEmail, null, searchTel, searchSex, searchActive);
		customerList = customerService.searchCustomer(searchDto);
	}

	public void cleanDialogForm() {
		newName = null;
		newSurname = null;
		newBirthDate = null;
		newEmail = null;
		newPwd = null;
		newTel = null;
		newSex = null;
		newActive = null;
	}

	public void cleanSearchForm() {
		searchId = null;
		searchName = null;
		searchSurname = null;
		searchEmail = null;
		searchTel = null;
		searchSex = null;
		searchActive = null;
	}

	public void addCustomer() {
		Customer customer = new Customer();
		customer.setName(newName);
		customer.setSurname(newSurname);
		customer.setBirthDate(newBirthDate);
		customer.setEmail(newEmail);
		customer.setPwd(newPwd);
		customer.setTel(newTel);
		customer.setSex(newSex);
		customer.setActive(newActive);
		customerService.insert(customer);
		cleanDialogForm();
		searchCustomer();
	}

	public void updateSelectedCustomer(Customer customer) {
		customerService.update(customer);
		searchCustomer();
	}

	public void deleteCustomer(Customer customer) {
		customerService.delete(customer.getId());
		searchCustomer();
	}
	
	public String getGenderMale() {
		return Customer.SEX_M;
	}

	public String getGenderFemale() {
		return Customer.SEX_F;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewSurname() {
		return newSurname;
	}

	public void setNewSurname(String newSurname) {
		this.newSurname = newSurname;
	}

	public Date getNewBirthDate() {
		return newBirthDate;
	}

	public void setNewBirthDate(Date newBirthDate) {
		this.newBirthDate = newBirthDate;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getNewTel() {
		return newTel;
	}

	public void setNewTel(String newTel) {
		this.newTel = newTel;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchSurname() {
		return searchSurname;
	}

	public void setSearchSurname(String searchSurname) {
		this.searchSurname = searchSurname;
	}

	public String getSearchEmail() {
		return searchEmail;
	}

	public void setSearchEmail(String searchEmail) {
		this.searchEmail = searchEmail;
	}

	public String getSearchTel() {
		return searchTel;
	}

	public void setSearchTel(String searchTel) {
		this.searchTel = searchTel;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String getNewSex() {
		return newSex;
	}

	public void setNewSex(String newSex) {
		this.newSex = newSex;
	}

	public String getSearchSex() {
		return searchSex;
	}

	public void setSearchSex(String searchSex) {
		this.searchSex = searchSex;
	}

	public Boolean getNewActive() {
		return newActive;
	}

	public void setNewActive(Boolean newActive) {
		this.newActive = newActive;
	}

	public Boolean getSearchActive() {
		return searchActive;
	}

	public void setSearchActive(Boolean searchActive) {
		this.searchActive = searchActive;
	}
}
