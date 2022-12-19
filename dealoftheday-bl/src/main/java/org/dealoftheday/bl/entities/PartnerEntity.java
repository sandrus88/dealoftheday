package org.dealoftheday.bl.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "PARTNER")
public class PartnerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPartner")
	@SequenceGenerator(name = "seqPartner", sequenceName = "SEQ_PARTNER", initialValue = 200, allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "TEL")
	private String tel;
	@Column(name = "CELL")
	private String cell;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "WEB_SITE")
	private String webSite;
	@Column(name = "CATEGORY")
	private String category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITY_ID")
	private CityEntity cityEntity;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARTNER_ID")
	private List<ContractEntity> contracts;
	
	public PartnerEntity() {
		contracts = new ArrayList<>();
	}
	
	public void addContract(ContractEntity contractEntity) {
		contracts.add(contractEntity);
	}
	
	public void removeContract(ContractEntity contractEntity) {
		contracts.remove(contractEntity);
	}
	
	public void removeAllContracts() {
		contracts.clear();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CityEntity getCityEntity() {
		return cityEntity;
	}

	public void setCityEntity(CityEntity cityEntity) {
		this.cityEntity = cityEntity;
	}

	public List<ContractEntity> getContracts() {
		return contracts;
	}

	public void setContracts(List<ContractEntity> contracts) {
		this.contracts = contracts;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PartnerEntity)) {
			return false;
		}
		PartnerEntity other = (PartnerEntity) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(name, other.name)
				.append(address, other.address)
				.append(tel, other.tel)
				.append(cell, other.cell)
				.append(email, other.email)
				.append(webSite, other.webSite)
				.append(category, other.category)
				.append(cityEntity, other.cityEntity)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(name)
				.append(address)
				.append(tel)
				.append(cell)
				.append(email)
				.append(webSite)
				.append(category)
				.append(cityEntity)
				.append(contracts)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(name)
				.append(address)
				.append(tel)
				.append(cell)
				.append(email)
				.append(webSite)
				.append(category)
				.append(cityEntity)
				.append(contracts)
				.toString();
	}
}
