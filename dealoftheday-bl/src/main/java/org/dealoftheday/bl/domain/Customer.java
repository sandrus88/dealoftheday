package org.dealoftheday.bl.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dealoftheday.bl.entities.CustomerEntity;

public class Customer {
	
	public static final String SEX_M = "M";
	public static final String SEX_F = "F";
	
	private Integer id;
	private String name;
	private String surname;
	private Date birthDate;
	private String email;
	private String pwd;
	private String tel;
	private String sex;
	private Boolean active;

	public Customer() {

	}

	public Customer(Integer id, String name, String surname, Date birthDate, String email, String pwd, String tel, String sex, Boolean active) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.email = email;
		this.pwd = pwd;
		this.tel = tel;
		this.sex = sex;
		this.active = active;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(name, other.name)
				.append(surname, other.surname)
				.append(birthDate, other.birthDate)
				.append(email, other.email)
				.append(pwd, other.pwd)
				.append(tel, other.tel)
				.append(sex, other.sex)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(surname)
				.append(birthDate)
				.append(email)
				.append(pwd)
				.append(tel)
				.append(sex)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(id)
				.append(name)
				.append(surname)
				.append(birthDate)
				.append(email)
				.append(pwd)
				.append(tel)
				.append(sex)
				.toString();
	}
}
