package org.dealoftheday.bl.domain;

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
		if (o == null) {
			return false;
		}
		if (!(o instanceof Partner)) {
			return false;
		}
		Partner other = (Partner) o;
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
		if (category != null && !category.equals(other.category)) {
			return false;
		}
		if (city != null && !city.equals(other.city)) {
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
		result = result + ((category == null) ? 0 : category.hashCode());
		result = result + ((city == null) ? 0 : city.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", address: " + address + ", tel: "
				+ tel + ", cell: " + cell + ", email: " + email + ", webSite: " + webSite + ", category: " + category + ", city: " + city.getId() + "-" + city.getName() + "]";
	}

}
