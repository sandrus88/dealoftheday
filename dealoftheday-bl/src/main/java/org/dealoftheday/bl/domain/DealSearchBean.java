package org.dealoftheday.bl.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class DealSearchBean {
	
	private Integer idSearch;
	private String titleSearch;
	private Status statusSearch;
	private Date approvedDateFrom;
	private Date approvedDateTo;
	private Contract contractSearch;
	
	public DealSearchBean() {
		
	}

	public DealSearchBean(Integer idSearch, String titleSearch, Status statusSearch, Date approvedDateFrom,
			Date approvedDateTo, Contract contractSearch) {
		this.idSearch = idSearch;
		this.titleSearch = titleSearch;
		this.statusSearch = statusSearch;
		this.approvedDateFrom = approvedDateFrom;
		this.approvedDateTo = approvedDateTo;
		this.contractSearch = contractSearch;
	}

	public Integer getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(Integer idSearch) {
		this.idSearch = idSearch;
	}

	public String getTitleSearch() {
		return titleSearch;
	}

	public void setTitleSearch(String titleSearch) {
		this.titleSearch = titleSearch;
	}

	public Status getStatusSearch() {
		return statusSearch;
	}

	public void setStatusSearch(Status statusSearch) {
		this.statusSearch = statusSearch;
	}

	public Date getApprovedDateFrom() {
		return approvedDateFrom;
	}

	public void setApprovedDateFrom(Date approvedDateFrom) {
		this.approvedDateFrom = approvedDateFrom;
	}

	public Date getApprovedDateTo() {
		return approvedDateTo;
	}

	public void setApprovedDateTo(Date approvedDateTo) {
		this.approvedDateTo = approvedDateTo;
	}

	public Contract getContractSearch() {
		return contractSearch;
	}

	public void setContractSearch(Contract contractSearch) {
		this.contractSearch = contractSearch;
	} 
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof DealSearchBean)) {
			return false;
		}
		DealSearchBean other = (DealSearchBean) o;
		return new EqualsBuilder()
				.append(idSearch, other.idSearch)
				.append(titleSearch, other.titleSearch)
				.append(approvedDateFrom, other.approvedDateFrom)
				.append(approvedDateTo, other.approvedDateTo)
				.append(statusSearch, other.statusSearch)
				.append(contractSearch, other.contractSearch)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(idSearch)
				.append(titleSearch)
				.append(approvedDateFrom)
				.append(approvedDateTo)
				.append(statusSearch)
				.append(contractSearch)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(idSearch)
				.append(titleSearch)
				.append(approvedDateFrom)
				.append(approvedDateTo)
				.append(statusSearch)
				.append(contractSearch)
				.toString();
	}
}
