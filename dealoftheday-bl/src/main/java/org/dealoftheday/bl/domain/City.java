package org.dealoftheday.bl.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class City {
	
	private Date lastUpdate;
	private String id;
	private String name;
	private Float lat;
	private Float lng;
		
	public City() {
		
	}

	public City(String id, String name, Float late, Float lng) {
		this.id = id;
		this.name = name;
		this.lat = late;
		this.lng = lng;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
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
