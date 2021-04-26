package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.entities.PartnerEntity;

public interface PartnerDao {
	
	PartnerEntity insert(PartnerEntity partnerEntity);

    PartnerEntity get(Integer id);

    PartnerEntity update(PartnerEntity partnerEntity);

    List<PartnerEntity> getAll();

    boolean delete(Integer id);

}
