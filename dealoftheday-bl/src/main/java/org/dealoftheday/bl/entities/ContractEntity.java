package org.dealoftheday.bl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "CONTRACT")
public class ContractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqContract")
	@SequenceGenerator(name = "seqContract", sequenceName = "SEQ_CONTRACT", initialValue = 200, allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PRICE")
	private Float price;
	@Column(name = "DAY_OF_SIGNATURE")
	private Date dayOfSignature;
	@Column(name = "INSERTION_DATE")
	private Date insertionDate;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARTNER_ID")
	private PartnerEntity partnerEntity;

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

	public PartnerEntity getPartnerEntity() {
		return partnerEntity;
	}

	public void setPartnerEntity(PartnerEntity partnerEntity) {
		this.partnerEntity = partnerEntity;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ContractEntity)) {
			return false;
		}
		ContractEntity other = (ContractEntity) o;
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
				.append(partnerEntity.getName())
				.toString();
	}
}
