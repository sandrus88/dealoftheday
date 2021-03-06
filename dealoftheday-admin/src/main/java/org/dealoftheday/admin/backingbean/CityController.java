package org.dealoftheday.admin.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.service.CityService;

@ManagedBean
@ViewScoped
public class CityController {
	
	@ManagedProperty(value = "#{cityService}")
	private CityService cityService;
	
	private static Logger logger = LogManager.getLogger(CityController.class);

	private String newId;
	private String newName;
	private Float newLat;
	private Float newLng;
	
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
		City searchDto = new City(searchId, searchName, null, null);
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

	public Float getNewLat() {
		return newLat;
	}

	public void setNewLat(Float newLat) {
		this.newLat = newLat;
	}

	public Float getNewLng() {
		return newLng;
	}

	public void setNewLng(Float newLng) {
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
}
