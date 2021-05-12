package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.entities.UserEntity;

public interface UserDao {
	
	UserEntity insert(UserEntity userEntity);

	UserEntity get(String id);

	UserEntity update(UserEntity userEntity);

    List<UserEntity> getAll();

    boolean delete(String id);
    
    List<UserEntity> searchUser(User searchDto);

}
