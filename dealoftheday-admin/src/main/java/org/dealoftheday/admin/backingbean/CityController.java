package org.dealoftheday.admin.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.service.CityService;
import org.dealoftheday.bl.service.PartnerService;

@ManagedBean
@ViewScoped
public class CityController {
	
	@ManagedProperty(value = "#{cityService}")
	private CityService cityService;
	
	@ManagedProperty(value = "#{partnerService}")
	private PartnerService partnerService;

	private String newId;
	private String newName;
	private Double newLat;
	private Double newLng;
	
	private String searchId;
	private String searchName;
	
	private List<Partner> allPartners = new ArrayList<>();
	private List<City> cityList = new ArrayList<>();
	private City selectedCity;

	@PostConstruct
	public void init() {
		searchCity();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void searchCity() {
		City searchDto = new City(searchId, searchName, null, null, null);
		cityList = cityService.searchCity(searchDto);
	}

	public void cleanDialogForm() {
		newId = null;
		newName = null;
		newLat = null;
		newLng = null;
	}

	public void cleanSearchForm() {
		searchId = null;
		searchName = null;
	}

	public void addCity() {
		City city = new City();
		city.setId(newId);
		city.setName(newName);
		city.setLat(newLat);
		city.setLng(newLng);
		cityService.insert(city);
		cleanDialogForm();
		searchCity();
	}

	public void updateSelectedCity(City city) {
		cityService.update(city);
		searchCity();
	}

	public void deleteCity(City city) {
		cityService.delete(city.getId());
		searchCity();
	}
	
	public void viewPartners(City city) {
		selectedCity = city;
		allPartners = partnerService.getAll();
		List<Partner> selectedCityPartners = city.getPartners();

		for (int i = 0; i < allPartners.size(); i++) {
			Partner partner = allPartners.get(i);
			if (selectedCityPartners.contains(partner)) {
				partner.setChecked(true);
				partner.isDisabled(selectedCity);
			}
		}
		searchCity();
	}

	public void updateCityPartners(City city) {
		for (int i = 0; i < allPartners.size(); i++) {
			final Partner partner = allPartners.get(i);
			if (partner.isChecked()) {
				city.addPartner(partner);
			} else {
				city.removePartner(partner);
			}
		}
		city = cityService.update(city);
		searchCity();
	}
	
	public int partnersNumber(City city) {
		int partners = city.getPartners().size();
		return partners;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public Double getNewLat() {
		return newLat;
	}

	public void setNewLat(Double newLat) {
		this.newLat = newLat;
	}

	public Double getNewLng() {
		return newLng;
	}

	public void setNewLng(Double newLng) {
		this.newLng = newLng;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public List<Partner> getAllPartners() {
		return allPartners;
	}

	public void setAllPartners(List<Partner> allPartners) {
		this.allPartners = allPartners;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public City getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(City selectedCity) {
		this.selectedCity = selectedCity;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public void setPartnerService(PartnerService partnerService) {
		this.partnerService = partnerService;
	}
}
