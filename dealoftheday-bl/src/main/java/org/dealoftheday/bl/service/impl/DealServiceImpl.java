package org.dealoftheday.bl.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.assembler.DealAssembler;
import org.dealoftheday.bl.assembler.DealItemAssembler;
import org.dealoftheday.bl.dao.DealDao;
import org.dealoftheday.bl.dao.DealItemDao;
import org.dealoftheday.bl.domain.Deal;
import org.dealoftheday.bl.domain.DealItem;
import org.dealoftheday.bl.entities.DealEntity;
import org.dealoftheday.bl.entities.DealItemEntity;
import org.dealoftheday.bl.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "dealService")
@Transactional
public class DealServiceImpl implements DealService {
	
	final private DealDao dealDao;
	final private DealItemDao dealItemDao;
	private static Logger logger = LogManager.getLogger(DealServiceImpl.class);

	@Autowired
	public DealServiceImpl(DealDao dealDao, DealItemDao dealItemDao) {
		this.dealDao = dealDao;
		this.dealItemDao = dealItemDao;
	}

	@Override
	public Deal insert(Deal deal) {
		DealEntity entity = DealAssembler.getEntity(deal);
		entity = dealDao.insert(entity);
		deal = DealAssembler.getDTO(entity);
		return deal;
	}

	@Override
	public Deal get(Integer id) {
		DealEntity entity = dealDao.get(id);
		Deal deal = DealAssembler.getDTO(entity);
		return deal;
	}

	@Override
	public Deal update(Deal deal) {
		DealEntity entity = DealAssembler.getEntity(deal);
		DealEntity entityUp = dealDao.update(entity);
		deal = DealAssembler.getDTO(entityUp);
		return deal;
	}

	@Override
	public List<Deal> getAll() {
		List<DealEntity> entityList = dealDao.getAll();
		List<Deal> dtoList = DealAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public boolean delete(Integer id) {
		return dealDao.delete(id);
	}

	@Override
	public DealItem insertDealItem(DealItem dealItem) {
		DealItemEntity entity = DealItemAssembler.getEntity(dealItem);
		entity = dealItemDao.insert(entity);
		dealItem = DealItemAssembler.getDTO(entity);
		return dealItem;
	}

	@Override
	public DealItem getDealItem(Integer id) {
		DealItemEntity entity = dealItemDao.get(id);
		DealItem dealItem = DealItemAssembler.getDTO(entity);
		return dealItem;
	}

	@Override
	public DealItem updateDealItem(DealItem dealItem) {
		DealItemEntity entity = DealItemAssembler.getEntity(dealItem);
		DealItemEntity entityUp = dealItemDao.update(entity);
		dealItem = DealItemAssembler.getDTO(entityUp);
		return dealItem;
	}

	@Override
	public boolean deleteDealItem(Integer id) {
		return dealItemDao.delete(id);
	}
}
