package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.domain.DealSearchBean;
import org.dealoftheday.bl.entities.DealEntity;

public interface DealDao {
	
	DealEntity insert(DealEntity dealEntity);

    DealEntity get(Integer id);

    DealEntity update(DealEntity dealEntity);

    List<DealEntity> getAll();

    boolean delete(Integer id);
    
    List<DealEntity> searchDeal(DealSearchBean searchBean);
}
