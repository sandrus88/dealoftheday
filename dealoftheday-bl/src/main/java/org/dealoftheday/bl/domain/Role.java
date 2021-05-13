package org.dealoftheday.bl.domain;

import java.util.ArrayList;
import java.util.List;

import org.dealoftheday.bl.entities.UserEntity;

public class Role {
	
	private Integer id;
	private String name;
	private String description;
	
	private List<User> users;
	
	public Role() {
		users = new ArrayList<>();
	}

	public Role(int role1) {
		
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

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Role)) {
			return false;
		}
		Role other = (Role) o;
		if (id != null && !id.equals(other.id)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (description != null && !description.equals(other.description)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [Id: " + id + ", name: " + name +", description: " + description + "]";
	}
}
