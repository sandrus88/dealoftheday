package org.dealoftheday.bl.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class CityEntity {
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LAT")
	private Double lat;
	@Column(name = "LNG")
	private Double lng;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CITY_ID")
	private List<PartnerEntity> partners;

	public CityEntity() {
		partners = new ArrayList<>();
	}

	public void addPartner(PartnerEntity partnerEntity) {
		partners.add(partnerEntity);
	}

	public void removePartner(PartnerEntity partnerEntity) {
		partners.remove(partnerEntity);
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
	public List<PartnerEntity> getPartners() {
		return partners;
	}

	public void setPartners(List<PartnerEntity> partners) {
		this.partners = partners;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof CityEntity)) {
			return false;
		}
		CityEntity other = (CityEntity) o;
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
