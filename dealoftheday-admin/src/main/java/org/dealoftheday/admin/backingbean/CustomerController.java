package org.dealoftheday.admin.backingbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.dealoftheday.admin.appbean.ApplicationBean;
import org.dealoftheday.bl.domain.Customer;
import org.dealoftheday.bl.service.CustomerService;

@ManagedBean
@SessionScoped
public class CustomerController {
	
	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;

	@ManagedProperty(value = "#{customerService}")
	private CustomerService customerService;

	private String newName;
	private String newSurname;
	private Date newBirthDate;
	private String newEmail;
	private String newPwd;
	private String newTel;
	
	private Integer searchId;
	private String searchName;
	private String searchSurname;
	private String searchEmail;
	private String searchTel;

	private List<Customer> customerList = new ArrayList<>();
	private Customer selectedCustomer;

	@PostConstruct
	public void init() {
		searchCustomer();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void searchCustomer() {
		Customer searchDto = new Customer(searchId, searchName, searchSurname, null, searchEmail, null, searchTel);
		customerList = customerService.searchCustomer(searchDto);
	}

	public void cleanDialogForm() {
		newName = null;
		newSurname = null;
		newBirthDate = null;
		newEmail = null;
		newPwd = null;
		newTel = null;
	}

	public void cleanSearchForm() {
		searchId = null;
		searchName = null;
		searchSurname = null;
		searchEmail = null;
		searchTel = null;
	}

	public void addCustomer() {
		Customer customer = new Customer();
		customer.setId(applicationBean.getNextInt());
		customer.setName(newName);
		customer.setSurname(newSurname);
		customer.setBirthDate(newBirthDate);
		customer.setEmail(newEmail);
		customer.setPwd(newPwd);
		customer.setTel(newTel);
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

	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}

	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
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
}
