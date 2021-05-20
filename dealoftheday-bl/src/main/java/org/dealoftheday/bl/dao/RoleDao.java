package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.entities.RoleEntity;

public interface RoleDao {

    List<RoleEntity> getAll();
}
