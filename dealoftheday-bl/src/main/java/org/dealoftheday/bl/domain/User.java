package org.dealoftheday.bl.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String userName;
	private String name;
	private String surname;
	private String email;
	private String pwd;
	private Boolean enabled;
	private Boolean locked;
	private int failedLoginCount;
	
	private List<Role> roles;
	
	public User() {
		roles = new ArrayList<>();
	}
	
	public User(String userName, String name, String surname, String email, String pwd, Boolean enabled, Boolean locked,
			int failedLoginCount, List<Role> roles) {
		this.userName = userName;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.pwd = pwd;
		this.enabled = enabled;
		this.locked = locked;
		this.failedLoginCount = failedLoginCount;
		this.roles = roles;
	}

	public void addRole(Role role) {
		roles.add(role);
	}
	
	public void removeRole(Role role) {
		roles.remove(role);
	}
	
	public void removeAllRoles() {
		roles.clear();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public int getFailedLoginCount() {
		return failedLoginCount;
	}

	public void setFailedLoginCount(int failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof User)) {
			return false;
		}
		User other = (User) o;
		if (userName != null && !userName.equals(other.userName)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (surname != null && !surname.equals(other.surname)) {
			return false;
		}
		if (email != null && !email.equals(other.email)) {
			return false;
		}
		if (pwd != null && !pwd.equals(other.pwd)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [Username: " + userName + ", name: " + name + ", surname: " + surname
				+ ", email: " + email + ", password: " + pwd + ", roles: " + roles + "]";
	}
}
