package org.dealoftheday.bl.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class DealItem {
	
	private Integer id;
	private String dealItemTitle;
	private Float fullPrice;
	private Float discountedPrice;
	private Float commissionPercentage;
	private Integer minCustomers;
	private Integer maxCustomers;
	private Float totPurchases;
	private Integer dealId;

	public DealItem() {
		
	}

	public DealItem(Integer id, String dealItemTitle, Float fullPrice, Float discountedPrice,
			Float commissionPercentage, Integer minCustomers, Integer maxCustomers, Float totPurchases, Integer dealId) {
		this.id = id;
		this.dealItemTitle = dealItemTitle;
		this.fullPrice = fullPrice;
		this.discountedPrice = discountedPrice;
		this.commissionPercentage = commissionPercentage;
		this.minCustomers = minCustomers;
		this.maxCustomers = maxCustomers;
		this.totPurchases = totPurchases;
		this.dealId= dealId;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChoiceTitle() {
		return dealItemTitle;
	}

	public void setChoiceTitle(String choiceTitle) {
		this.dealItemTitle = choiceTitle;
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
		if (!(o instanceof DealItem)) {
			return false;
		}
		DealItem other = (DealItem) o;
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
