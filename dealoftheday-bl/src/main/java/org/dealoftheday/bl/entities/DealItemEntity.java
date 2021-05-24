package org.dealoftheday.bl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "DEAL_ITEM")
public class DealItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDealItem")
	@SequenceGenerator(name = "seqDealItem", sequenceName = "SEQ_DEAL_ITEM", initialValue = 200, allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TITLE_ITEM")
	private String dealItemTitle;
	@Column(name = "DISCOUNTED_PRICE")
	private Float discountedPrice;
	@Column(name = "FULL_PRICE")
	private Float fullPrice;
	@Column(name = "COMMISSION_PERCENTAGE")
	private Float commissionPercentage;
	@Column(name = "NR_MIN_CUSTOMERS")
	private Integer minCustomers;
	@Column(name = "NR_MAX_CUSTOMERS")
	private Integer maxCustomers;
	@Column(name = "TOT_PURCHASE")
	private Float totPurchases;
	@Column(name = "DEAL_ID")
	private Integer dealId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDealItemTitle() {
		return dealItemTitle;
	}

	public void setDealItemTitle(String dealItemTitle) {
		this.dealItemTitle = dealItemTitle;
	}

	public Float getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Float discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Float getCommissionPercentage() {
		return commissionPercentage;
	}

	public void setCommissionPercentage(Float commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}

	public Float getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(Float fullPrice) {
		this.fullPrice = fullPrice;
	}

	public Integer getMinCustomers() {
		return minCustomers;
	}

	public void setMinCustomers(Integer minCustomers) {
		this.minCustomers = minCustomers;
	}

	public Integer getMaxCustomers() {
		return maxCustomers;
	}

	public void setMaxCustomers(Integer maxCustomers) {
		this.maxCustomers = maxCustomers;
	}

	public Float getTotPurchases() {
		return totPurchases;
	}

	public void setTotPurchases(Float totPurchases) {
		this.totPurchases = totPurchases;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof DealItemEntity)) {
			return false;
		}
		DealItemEntity other = (DealItemEntity) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(dealItemTitle, other.dealItemTitle)
				.append(discountedPrice, other.discountedPrice)
				.append(fullPrice, other.fullPrice)
				.append(commissionPercentage, other.commissionPercentage)
				.append(minCustomers, other.minCustomers)
				.append(maxCustomers, other.maxCustomers)
				.append(totPurchases, other.totPurchases)
				.append(dealId, other.dealId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(dealItemTitle)
				.append(discountedPrice)
				.append(fullPrice)
				.append(commissionPercentage)
				.append(minCustomers)
				.append(maxCustomers)
				.append(totPurchases)
				.append(dealId)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(id)
				.append(dealItemTitle)
				.append(discountedPrice)
				.append(fullPrice)
				.append(commissionPercentage)
				.append(minCustomers)
				.append(maxCustomers)
				.append(totPurchases)
				.append(dealId)
				.toString();
	}
}
