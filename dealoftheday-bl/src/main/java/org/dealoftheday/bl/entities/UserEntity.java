package org.dealoftheday.bl.entities;

import java.util.ArrayList;
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

@Entity
@Table(name = "USERS")
public class UserEntity {
	
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
		if (o == null) {
			return false;
		}
		if (!(o instanceof UserEntity)) {
			return false;
		}
		UserEntity other = (UserEntity) o;
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
		return this.getClass().getSimpleName() + " [User Name: " + userName + ", name: " + name + ", surname: " + surname
				+ ", email: " + email + ", password: " + pwd + ", roles: " + roles + "]";
	}
}
