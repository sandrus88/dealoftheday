package org.dealoftheday.bl.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dealoftheday.bl.domain.User;

@Entity
@Table(name = "USERS")
public class UserEntity {
	
	@Column(name = "LMD")
	private Date lastUpdate;
	@Id
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SURNAME")
	private String surname;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PWD")
	private String pwd;
	@Column(name = "ENABLED")
	private int enabled;
	@Column(name = "LOCKED")
	private int locked;
	@Column(name = "FAILED_LOGIN_COUNT")
	private int failedLoginCount;
	
	@ManyToMany
	@JoinTable(name = "USER_ROLE", 
			joinColumns = @JoinColumn(name = "USER_ID"),
	        inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<RoleEntity> roles;
	
	public UserEntity(){
		roles = new ArrayList<>();
	}
	
	public void addRole(RoleEntity roleEntity) {
		roles.add(roleEntity);
	}
	
	public void removeRole(RoleEntity roleEntity) {
		roles.remove(roleEntity);
	}
	
	public void removeAllRoles() {
		roles.clear();
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getFailedLoginCount() {
		return failedLoginCount;
	}

	public void setFailedLoginCount(int failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof UserEntity)) {
			return false;
		}
		UserEntity other = (UserEntity) o;

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
