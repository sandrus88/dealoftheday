package org.dealoftheday.bl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCustomer")
	@SequenceGenerator(name = "seqCustomer", sequenceName = "SEQ_CUSTOMER", initialValue = 200, allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SURNAME")
	private String surname;
	@Column(name = "BIRTHDATE")
	private Date birthDate;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PWD")
	private String pwd;
	@Column(name = "TEL")
	private String tel;
	@Column(name = "SEX")
	private String sex;
	@Column(name = "ACTIVE")
	private int active;
	
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CustomerEntity)) {
			return false;
		}
		CustomerEntity other = (CustomerEntity) o;
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
