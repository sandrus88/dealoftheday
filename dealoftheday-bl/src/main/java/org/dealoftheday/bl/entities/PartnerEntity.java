package org.dealoftheday.bl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	@Column(name = "CITY_ID")
	private String cityId;

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

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof PartnerEntity)) {
			return false;
		}
		PartnerEntity other = (PartnerEntity) o;
		if (id != null && !id.equals(other.id)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (address != null && !address.equals(other.address)) {
			return false;
		}
		if (tel != null && !tel.equals(other.tel)) {
			return false;
		}
		if (cell != null && !cell.equals(other.cell)) {
			return false;
		}
		if (email != null && !email.equals(other.email)) {
			return false;
		}
		if (webSite != null && !webSite.equals(other.webSite)) {
			return false;
		}
		if (cityId != null && !cityId.equals(other.cityId)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = result + ((name == null) ? 0 : name.hashCode());
		result = result + ((address == null) ? 0 : address.hashCode());
		result = result + ((tel == null) ? 0 : tel.hashCode());
		result = result + ((cell == null) ? 0 : cell.hashCode());
		result = result + ((email == null) ? 0 : email.hashCode());
		result = result + ((webSite == null) ? 0 : webSite.hashCode());
		result = result + ((cityId == null) ? 0 : cityId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", address: " + address + ", tel: "
				+ tel + ", cell: " + cell + ", email: " + email + ", webSite: " + webSite + ", cityId: " + cityId + "]";
	}
}
