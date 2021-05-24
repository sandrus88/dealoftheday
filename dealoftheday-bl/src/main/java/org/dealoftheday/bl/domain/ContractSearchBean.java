package org.dealoftheday.bl.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ContractSearchBean {
	
	private Integer idSearch;
	private String clientFullNameSearch;
	private String brokerFullNameSearch;
//	private Date startDate;
//	private Date endDate;
	private Partner partnerSearch;
	private Date signedDateFrom;
	private Date signedDateTo;
	
	public ContractSearchBean() {

	}

	public ContractSearchBean(Integer idSearch, String clientFullNameSearch, String brokerFullNameSearch,
			Partner partnerSearch, Date signedDateFrom, Date signedDateTo) {
		super();
		this.idSearch = idSearch;
		this.clientFullNameSearch = clientFullNameSearch;
		this.brokerFullNameSearch = brokerFullNameSearch;
		this.partnerSearch = partnerSearch;
		this.signedDateFrom = signedDateFrom;
		this.signedDateTo = signedDateTo;
	}

	public Integer getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(Integer idSearch) {
		this.idSearch = idSearch;
	}

	public String getClientFullNameSearch() {
		return clientFullNameSearch;
	}

	public void setClientFullNameSearch(String clientFullNameSearch) {
		this.clientFullNameSearch = clientFullNameSearch;
	}

	public String getBrokerFullNameSearch() {
		return brokerFullNameSearch;
	}

	public void setBrokerFullNameSearch(String brokerFullNameSearch) {
		this.brokerFullNameSearch = brokerFullNameSearch;
	}

	public Partner getPartnerSearch() {
		return partnerSearch;
	}

	public void setPartnerSearch(Partner partnerSearch) {
		this.partnerSearch = partnerSearch;
	}

	public Date getSignedDateFrom() {
		return signedDateFrom;
	}

	public void setSignedDateFrom(Date signedDateFrom) {
		this.signedDateFrom = signedDateFrom;
	}

	public Date getSignedDateTo() {
		return signedDateTo;
	}

	public void setSignedDateTo(Date signedDateTo) {
		this.signedDateTo = signedDateTo;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ContractSearchBean)) {
			return false;
		}
		ContractSearchBean other = (ContractSearchBean) o;
		return new EqualsBuilder()
				.append(idSearch, other.idSearch)
				.append(clientFullNameSearch, other.clientFullNameSearch)
				.append(brokerFullNameSearch, other.brokerFullNameSearch)
				.append(partnerSearch, other.partnerSearch)
				.append(signedDateFrom, other.signedDateFrom)
				.append(signedDateTo, other.signedDateTo)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(idSearch)
				.append(clientFullNameSearch)
				.append(brokerFullNameSearch)
				.append(partnerSearch)
				.append(signedDateFrom)
				.append(signedDateTo)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(idSearch)
				.append(clientFullNameSearch)
				.append(brokerFullNameSearch)
				.append(partnerSearch)
				.append(signedDateFrom)
				.append(signedDateTo)
				.toString();
	}
}
