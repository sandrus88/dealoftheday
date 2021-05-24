package org.dealoftheday.bl.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Contract { 
	
	private Integer id;
	private String clientFullName;
	private String clientCell;
	private String brokerFullName;
	private String brokerCell;
	private Date signedDate;
	private Date startDate;
	private Date endDate;
	private String contractComment;
	private String iban;
	private Partner partner;
	private Deal deal;
	
	public Contract() {
		
	}
	
	public Contract(Integer id, String clientFullName, String clientCell, String brokerFullName, String brokerCell,
			Date signedDate, Date startDate, Date endDate, String contractComment, String iban, Partner partner,
			Deal deal) {
		this.id = id;
		this.clientFullName = clientFullName;
		this.clientCell = clientCell;
		this.brokerFullName = brokerFullName;
		this.brokerCell = brokerCell;
		this.signedDate = signedDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contractComment = contractComment;
		this.iban = iban;
		this.partner = partner;
		this.deal = deal;
	}

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

	public String getContractComment() {
		return contractComment;
	}

	public void setContractComment(String contractComment) {
		this.contractComment = contractComment;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Contract)) {
			return false;
		}
		Contract other = (Contract) o;
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
				.append(partner, other.partner)
				.append(deal, other.deal)
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
				.append(partner)
				.append(deal)
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
				.append(partner)
				.append(deal)
				.toString();
	}
}
