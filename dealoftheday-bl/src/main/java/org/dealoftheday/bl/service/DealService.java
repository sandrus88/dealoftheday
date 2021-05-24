package org.dealoftheday.bl.service;

import java.util.List;

import org.dealoftheday.bl.domain.Deal;
import org.dealoftheday.bl.domain.DealItem;

public interface DealService {
	
	Deal insert(Deal deal);

    Deal get(Integer id);

    Deal update(Deal deal);

    List<Deal> getAll();

    boolean delete(Integer id);
    
    
    DealItem insertDealItem(DealItem dealItem);

    DealItem getDealItem(Integer id);

    DealItem updateDealItem(DealItem dealItem);

    boolean deleteDealItem(Integer id);
}
