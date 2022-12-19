package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.entities.DealItemEntity;

public interface DealItemDao {
	
	DealItemEntity insert(DealItemEntity dealItemEntity);

    DealItemEntity get(Integer id);

    DealItemEntity update(DealItemEntity dealItemEntity);

    List<DealItemEntity> getAll();

    boolean delete(Integer id);

}
