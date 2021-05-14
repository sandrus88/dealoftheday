package org.dealoftheday.admin.backingbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Category;
import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.service.CityService;
import org.dealoftheday.bl.service.PartnerService;

@ManagedBean
@ViewScoped
public class PartnerController {
	
	@ManagedProperty(value = "#{partnerService}")
	private PartnerService partnerService;
	
	@ManagedProperty(value = "#{cityService}")
	private CityService cityService;
	
	private static Logger logger = LogManager.getLogger(PartnerController.class);
	
	private String newName;
	private String newAddress;
	private String newTel;
	private String newCell;
	private String newEmail;
	private String newWebSite;
	private Category newCategory;
	private City newCity;
	
	private Integer searchId;
	private String searchName;
	private String searchEmail;
	private String searchCell;
	private Category searchCategory;
	private City searchCity;
	
	private List<City> allCities;
	private List<Partner> partnerList = new ArrayList<>();
	private Partner selectedPartner;
	
	@PostConstruct
	public void init() {
		allCities = cityService.getAll();
		selectedPartner = new Partner();
		searchPartner();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void searchPartner() {
		Partner searchDto = new Partner(searchId, searchName, null, null, searchCell, searchEmail, null, searchCategory, searchCity);
		partnerList = partnerService.searchPartner(searchDto);
	}

	public void cleanDialogForm() {
		newName = null;
		newAddress = null;
		newTel = null;
		newCell = null;
		newEmail = null;
		newWebSite = null;
		newCategory = null;
		newCity = null;
	}

	public void cleanSearchForm() {
		searchId = null;
		searchName = null;
		searchCell = null;
		searchEmail = null;
		searchCategory = null;
		searchCity = null;
	}

	public void addPartner() {
		Partner partner = new Partner();
		partner.setName(newName);
		partner.setAddress(newAddress);
		partner.setTel(newTel);
		partner.setCell(newCell);
		partner.setEmail(newEmail);
		partner.setWebSite(newWebSite);
		partner.setCategory(newCategory);
		partner.setCity(newCity);
		partnerService.insert(partner);
		cleanDialogForm();
		searchPartner();
	}

	public void updateSelectedPartner(Partner partner) {
		partnerService.update(partner);
		searchPartner();
	}

	public void deletePartner(Partner partner) {
		partnerService.delete(partner.getId());
		searchPartner();
	}
	
	public String showCategory(Category category) {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
		String label = "";
		if (category != null) {
			label = bundle.getString("partner.category." + category);
		}
		return label;
	}
	
	public Category[] getEnumValues() {
		Category[] values = Category.values();
		return values;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	public String getNewTel() {
		return newTel;
	}

	public void setNewTel(String newTel) {
		this.newTel = newTel;
	}

	public String getNewCell() {
		return newCell;
	}

	public void setNewCell(String newCell) {
		this.newCell = newCell;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getNewWebSite() {
		return newWebSite;
	}

	public void setNewWebSite(String newWebSite) {
		this.newWebSite = newWebSite;
	}

	public Category getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(Category newCategory) {
		this.newCategory = newCategory;
	}

	public City getNewCity() {
		return newCity;
	}

	public void setNewCity(City newCity) {
		this.newCity = newCity;
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
	
	public String getSearchEmail() {
		return searchEmail;
	}

	public void setSearchEmail(String searchEmail) {
		this.searchEmail = searchEmail;
	}

	public String getSearchCell() {
		return searchCell;
	}

	public void setSearchCell(String searchCell) {
		this.searchCell = searchCell;
	}

	public Category getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(Category searchCategory) {
		this.searchCategory = searchCategory;
	}

	public City getSearchCity() {
		return searchCity;
	}

	public void setSearchCity(City searchCity) {
		this.searchCity = searchCity;
	}

	public List<City> getAllCities() {
		return allCities;
	}

	public void setAllCities(List<City> allCities) {
		this.allCities = allCities;
	}

	public List<Partner> getPartnerList() {
		return partnerList;
	}

	public void setPartnerList(List<Partner> partnerList) {
		this.partnerList = partnerList;
	}

	public Partner getSelectedPartner() {
		return selectedPartner;
	}

	public void setSelectedPartner(Partner selectedPartner) {
		this.selectedPartner = selectedPartner;
	}

	public void setPartnerService(PartnerService partnerService) {
		this.partnerService = partnerService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
}
