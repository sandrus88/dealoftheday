package org.dealoftheday.bl.service;

import java.util.List;

import org.dealoftheday.bl.domain.Role;

public interface RoleService {
	
	Role insert(Role role);

	Role get(Integer id);

	Role update(Role role);

    List<Role> getAll();

    boolean delete(Integer id);
}
