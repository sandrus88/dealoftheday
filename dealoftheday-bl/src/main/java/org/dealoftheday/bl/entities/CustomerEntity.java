package org.dealoftheday.bl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
		if (o == null) {
			return false;
		}
		if (!(o instanceof CustomerEntity)) {
			return false;
		}
		CustomerEntity other = (CustomerEntity) o;
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
		if (sex != null && !sex.equals(other.sex)) {
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
		result = result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", surname: " + surname
				+ ", birthDate: " + birthDate + ", email: " + email + ", password: " + pwd + ", phone: " + tel 
				+ ", sex: " + sex + ", active: " + active + "]";
	}
}
