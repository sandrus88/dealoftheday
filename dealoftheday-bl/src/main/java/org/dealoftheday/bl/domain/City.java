package org.dealoftheday.bl.domain;

public class City {
	
	private String id;
	private String name;
	private Double lat;
	private Double lng;
		
	public City() {
		
	}

	public City(String id, String name, Double late, Double lng) {
		this.id = id;
		this.name = name;
		this.lat = late;
		this.lng = lng;
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
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", latitude: " + lat
				+ ", longitude: " + lng + "]";
	}
}
