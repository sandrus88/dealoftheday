package org.dealoftheday.bl.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dealoftheday.bl.entities.PartnerEntity;

public class Contract {
	
	private Integer id;
	private String title;
	private String description;
	private Float price;
	private Date dayOfSignature;
	private Date insertionDate;
	private Date lastUpdate;
	private Partner partner;
	
	public Contract() {

	}

	public Contract(Integer id, String title, String description, Float price, Date dayOfSignature, Date insertionDate,
			Date lastUpdate, Partner partner) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.dayOfSignature = dayOfSignature;
		this.insertionDate = insertionDate;
		this.lastUpdate = lastUpdate;
		this.partner = partner;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getDayOfSignature() {
		return dayOfSignature;
	}

	public void setDayOfSignature(Date dayOfSignature) {
		this.dayOfSignature = dayOfSignature;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Contract)) {
			return false;
		}
		Contract other = (Contract) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(title, other.title)
				.append(description, other.description)
				.append(price, other.price)
				.append(dayOfSignature, other.dayOfSignature)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(title)
				.append(description)
				.append(price)
				.append(dayOfSignature)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(id)
				.append(title)
				.append(description)
				.append(price)
				.append(dayOfSignature)
				.append(partner.getName())
				.toString();
	}

}
