package org.dealoftheday.bl.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dealoftheday.bl.entities.PartnerEntity;

public class Partner {

	private Integer id;
	private String name;
	private String address;
	private String tel;
	private String cell;
	private String email;
	private String webSite;
	private Category category;
	private City city;
	
	public Partner() {

	}

	public Partner(Integer id, String name, String address, String tel, String cell, String email, String webSite, Category category,
			City city) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.cell = cell;
		this.email = email;
		this.webSite = webSite;
		this.category = category;
		this.city = city;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Partner)) {
			return false;
		}
		Partner other = (Partner) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(name, other.name)
				.append(address, other.address)
				.append(tel, other.tel)
				.append(cell, other.cell)
				.append(email, other.email)
				.append(webSite, other.webSite)
				.append(category, other.category)
				.append(city, other.city)
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
				.append(city)
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
				.append(city)
				.toString();
	}
}
