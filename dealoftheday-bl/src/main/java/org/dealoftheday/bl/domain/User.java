package org.dealoftheday.bl.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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
		if (!(o instanceof User)) {
			return false;
		}
		User other = (User) o;

		return new EqualsBuilder()
				.append(userName, other.userName)
				.append(name, other.name)
				.append(surname, other.surname)
				.append(email, other.email)
				.append(pwd, other.pwd)
				.append(enabled, other.enabled)
				.append(locked, other.locked)
				.append(failedLoginCount, other.failedLoginCount)
				.isEquals();

	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(userName)
				.append(name)
				.append(surname)
				.append(email)
				.append(pwd)
				.append(enabled)
				.append(locked)
				.append(failedLoginCount)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(userName)
				.append(name)
				.append(surname)
				.append(email)
				.append(pwd)
				.append(roles)
				.toString();
	}
}
