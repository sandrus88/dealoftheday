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
import javax.persistence.OneToOne;
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
	@Column(name = "CLIENT_FULLNAME")
	private String clientFullName;
	@Column(name = "CLIENT_CELL")
	private String clientCell;
	@Column(name = "BROKER_FULLNAME")
	private String brokerFullName;
	@Column(name = "BROKER_CELL")
	private String brokerCell;
	@Column(name = "SIGNED_DATE")
	private Date signedDate;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	@Column(name = "IBAN")
	private String iban;
	@Column(name = "CONTRACT_COMMENT")
	private String contractComment;
	@Column(name = "PARTNER_ID")
	private Integer partnerId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientFullName() {
		return clientFullName;
	}

	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}

	public String getClientCell() {
		return clientCell;
	}

	public void setClientCell(String clientCel) {
		this.clientCell = clientCel;
	}

	public String getBrokerFullName() {
		return brokerFullName;
	}

	public void setBrokerFullName(String brokerFullName) {
		this.brokerFullName = brokerFullName;
	}

	public String getBrokerCell() {
		return brokerCell;
	}

	public void setBrokerCell(String brokerCel) {
		this.brokerCell = brokerCel;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSignedDate() {
		return signedDate;
	}

	public void setSignedDate(Date signedDate) {
		this.signedDate = signedDate;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getContractComment() {
		return contractComment;
	}

	public void setContractComment(String contractComment) {
		this.contractComment = contractComment;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ContractEntity)) {
			return false;
		}
		ContractEntity other = (ContractEntity) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(clientFullName, other.clientFullName)
				.append(clientCell, other.clientCell)
				.append(brokerFullName, other.brokerFullName)
				.append(brokerCell, other.brokerCell)
				.append(signedDate, other.signedDate)
				.append(startDate, other.startDate)
				.append(endDate, other.endDate)
				.append(iban, other.iban)
				.append(contractComment, other.contractComment)
				.append(partnerId, other.partnerId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(clientFullName)
				.append(clientCell)
				.append(brokerFullName)
				.append(brokerCell)
				.append(signedDate)
				.append(startDate)
				.append(endDate)
				.append(iban)
				.append(contractComment)
				.append(partnerId)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(id)
				.append(clientFullName)
				.append(clientCell)
				.append(brokerFullName)
				.append(brokerCell)
				.append(signedDate)
				.append(startDate)
				.append(endDate)
				.append(iban)
				.append(contractComment)
				.append(partnerId)
				.toString();
	}
}
