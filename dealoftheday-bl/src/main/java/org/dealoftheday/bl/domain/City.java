package org.dealoftheday.bl.domain;

import java.util.ArrayList;
import java.util.List;

public class City {
	
	private String id;
	private String name;
	private Double lat;
	private Double lng;
	private List<Partner> partners = new ArrayList<>();
		
	public City() {
		
	}

	public City(String id, String name, Double late, Double lng, List<Partner> partners) {
		this.id = id;
		this.name = name;
		this.lat = late;
		this.lng = lng;
		this.partners = partners;
	}

	public void addPartner(Partner partner) {
		partners.add(partner);
	}

	public void removePartner(Partner partner) {
		partners.remove(partner);
	}

	public void removeAllPartners() {
		partners.clear();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double late) {
		this.lat = late;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	public List<Partner> getPartners() {
		return partners;
	}

	public void setPartners(List<Partner> partners) {
		this.partners = partners;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof City)) {
			return false;
		}
		City other = (City) o;
		if (id != null && !id.equals(other.id)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (lat != null && !lat.equals(other.lat)) {
			return false;
		}
		if (lng != null && !lng.equals(other.lng)) {
			return false;
		}
		if (partners != null && !partners.equals(other.partners)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		result = prime * result + ((partners == null) ? 0 : partners.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", latitude: " + lat
				+ ", longitude: " + lng + ", partners: " + partners + "]";
	}
}
