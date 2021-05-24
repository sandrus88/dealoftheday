package org.dealoftheday.bl.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "DEAL")
public class DealEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDeal")
	@SequenceGenerator(name = "seqDeal", sequenceName = "SEQ_DEAL", initialValue = 200, allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "TITLE_NEWSLETTER")
	private String titleNewsletter;
	@Column(name = "MAIN_IMG")
	private String mainImgName;
	@Column(name = "SYNTHESIS")
	private String synthesis;
	@Column(name = "CONDITIONS")
	private String conditions;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "CONTRACT_COMMENT")
	private String contractComment;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	@Column(name = "LAST_UPDATE_USER")
	private Date lastUpdateUser;
	@Column(name = "APPROVED_DATE")
	private Date approvedDate;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CONTRACT_ID")
	private ContractEntity contractEntity;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "DEAL_ID")
	private List<DealItemEntity> dealItems;
	
	public DealEntity(){
		dealItems = new ArrayList<>();
	}
	
	public void addDealItem(DealItemEntity dealItemEntity) {
		dealItems.add(dealItemEntity);
	}
	
	public void removeDealItem(DealItemEntity dealItemEntity) {
		dealItems.remove(dealItemEntity);
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	public ContractEntity getContractEntity() {
		return contractEntity;
	}

	public void setContractEntity(ContractEntity contractEntity) {
		this.contractEntity = contractEntity;
	}

	public List<DealItemEntity> getDealItems() {
		return dealItems;
	}

	public void setDealItems(List<DealItemEntity> dealItems) {
		this.dealItems = dealItems;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof DealEntity)) {
			return false;
		}
		DealEntity other = (DealEntity) o;
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
				.append(contractEntity, other.contractEntity)
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
				.append(contractEntity)
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
				.append(contractEntity)
				.append(dealItems)
				.toString();
	}
}
