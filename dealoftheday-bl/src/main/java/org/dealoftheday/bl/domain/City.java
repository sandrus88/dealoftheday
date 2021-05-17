package org.dealoftheday.bl.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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
		if (!(o instanceof City)) {
			return false;
		}
		City other = (City) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(name, other.name)
				.append(lat, other.lat)
				.append(lng, other.lng)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(lat)
				.append(lng)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(id)
				.append(name)
				.append(lat)
				.append(lng)
				.toString();
	}
}
