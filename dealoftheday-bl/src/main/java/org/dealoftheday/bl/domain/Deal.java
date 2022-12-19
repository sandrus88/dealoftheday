package org.dealoftheday.bl.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Deal {
	
	private Integer id;
	private String title;
	private String titleNewsletter;
	private String mainImgName;
	private String synthesis;
	private String conditions;
	private String description;
	
	private Status status;
	private String contractComment;
	private Date lastUpdate;
	private Date lastUpdateUser;
	private Date approvedDate;
	private Contract contract;
	private List<DealItem> dealItems; 
	
	public Deal() {
		dealItems = new ArrayList<>();
	}
	
	public Deal(Integer id, String title, String titleNewsletter, String mainImgName, String synthesis,
			String conditions, String description, Status status, String contractComment, Date lastUpdate,
			Date lastUpdateUser, Date approvedDate, Contract contract, List<DealItem> dealItems) {
		this.id = id;
		this.title = title;
		this.titleNewsletter = titleNewsletter;
		this.mainImgName = mainImgName;
		this.synthesis = synthesis;
		this.conditions = conditions;
		this.description = description;
		this.status = status;
		this.contractComment = contractComment;
		this.lastUpdate = lastUpdate;
		this.lastUpdateUser = lastUpdateUser;
		this.approvedDate = approvedDate;
		this.contract = contract;
		this.dealItems = dealItems;
	}

	public void addDealItem(DealItem dealItem) {
		dealItems.add(dealItem);
	}
	
	public void removeDealItem(DealItem dealItem) {
		for (int i = 0; i < dealItems.size(); i++) {
			if (dealItems.get(i).getId().equals(dealItem.getId())) {
				dealItems.remove(i);
			}
		}
	}
	
	public void removeAllDealItems() {
		dealItems.clear();
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

	public String getTitleNewsletter() {
		return titleNewsletter;
	}

	public void setTitleNewsletter(String titleNewsletter) {
		this.titleNewsletter = titleNewsletter;
	}

	public String getMainImgName() {
		return mainImgName;
	}

	public void setMainImgName(String mainImgName) {
		this.mainImgName = mainImgName;
	}

	public String getSynthesis() {
		return synthesis;
	}

	public void setSynthesis(String synthesis) {
		this.synthesis = synthesis;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getContractComment() {
		return contractComment;
	}

	public void setContractComment(String contractComment) {
		this.contractComment = contractComment;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(Date lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<DealItem> getDealItems() {
		return dealItems;
	}

	public void setDealItems(List<DealItem> dealItems) {
		this.dealItems = dealItems;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Deal)) {
			return false;
		}
		Deal other = (Deal) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(title, other.title)
				.append(titleNewsletter, other.titleNewsletter)
				.append(mainImgName, other.mainImgName)
				.append(synthesis, other.synthesis)
				.append(conditions, other.conditions)
				.append(description, other.description)
				.append(approvedDate, other.approvedDate)
				.append(status, other.status)
				.append(contractComment, other.contractComment)
				.append(lastUpdate, other.lastUpdate)
				.append(lastUpdateUser, other.lastUpdateUser)
				.append(contract, other.contract)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(title)
				.append(titleNewsletter)
				.append(mainImgName)
				.append(synthesis)
				.append(conditions)
				.append(description)
				.append(approvedDate)
				.append(status)
				.append(contract)
				.append(contractComment)
				.append(lastUpdate)
				.append(lastUpdateUser)
				.append(dealItems)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(id)
				.append(title)
				.append(titleNewsletter)
				.append(mainImgName)
				.append(synthesis)
				.append(conditions)
				.append(description)
				.append(approvedDate)
				.append(status)
				.append(contractComment)
				.append(lastUpdate)
				.append(lastUpdateUser)
				.append(contract)
				.append(dealItems)
				.toString();
	}
}
