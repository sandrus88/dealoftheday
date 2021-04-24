package org.dealoftheday.bl.domain;

import java.util.Date;

public class Customer {
	
	private Integer id;
	private String name;
	private String surname;
	private Date birthDate;
	private String email;
	private String pwd;
	private String tel;

	public Customer() {

	}

	public Customer(Integer id, String name, String surname, Date birthDate, String email, String pwd, String tel) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.email = email;
		this.pwd = pwd;
		this.tel = tel;
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

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) o;
		if (id != null && !id.equals(other.id)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (surname != null && !surname.equals(other.surname)) {
			return false;
		}
		if (birthDate != null && !birthDate.equals(other.birthDate)) {
			return false;
		}
		if (email != null && !email.equals(other.email)) {
			return false;
		}
		if (pwd != null && !pwd.equals(other.pwd)) {
			return false;
		}
		if (tel != null && !tel.equals(other.tel)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = result + ((name == null) ? 0 : name.hashCode());
		result = result + ((surname == null) ? 0 : surname.hashCode());
		result = result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = result + ((email == null) ? 0 : email.hashCode());
		result = result + ((pwd == null) ? 0 : pwd.hashCode());
		result = result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", surname: " + surname
				+ ", birthDate: " + birthDate + ", email: " + email + ", password: " + pwd + ", phone: " + tel
				+ "]";
	}
}
