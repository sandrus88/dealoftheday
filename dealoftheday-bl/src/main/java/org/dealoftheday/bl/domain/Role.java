package org.dealoftheday.bl.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Role {

	public static final int ROLE_DATA_ENTRY = 1;
	public static final int ROLE_EDITOR = 2;
	public static final int ROLE_PUBLISHER = 3;
	public static final int ROLE_READ_ONLY = 4;
	public static final int ROLE_ADMIN = 5;

	private Integer id;
	private String name;
	private String description;

	public Role(int id) {
		this.id = id;
	}

    public Role(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

    public Role() {
		
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
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Role)) {
			return false;
		}
		Role other = (Role) o;
		return new EqualsBuilder()
				.append(id, other.id)
				.append(name, other.name)
				.append(description, other.description)
				.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(description)
				.toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append(id)
				.append(name)
				.append(description)
				.toString();
	}
}
