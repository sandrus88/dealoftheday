package org.dealoftheday.bl.service;

import java.util.List;

import org.dealoftheday.bl.domain.User;

public interface UserService {
	
	User insert(User user);

	User get(String id);

	User update(User user);

    List<User> getAll();

    boolean delete(String id);
    
    List<User> searchUser(User searchDto);

}
