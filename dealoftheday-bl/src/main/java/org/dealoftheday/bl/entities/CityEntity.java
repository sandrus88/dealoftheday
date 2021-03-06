package org.dealoftheday.bl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dealoftheday.bl.domain.City;

@Entity
@Table(name = "CITY")
public class CityEntity {
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LAT")
	private Float lat;
	@Column(name = "LNG")
	private Float lng;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
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
		if (!(o instanceof CityEntity)) {
			return false;
		}
		CityEntity other = (CityEntity) o;
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
