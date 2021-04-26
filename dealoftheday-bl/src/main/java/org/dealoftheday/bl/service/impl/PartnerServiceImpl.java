package org.dealoftheday.bl.service.impl;

import java.util.List;

import org.dealoftheday.bl.assembler.PartnerAssembler;
import org.dealoftheday.bl.dao.PartnerDao;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.entities.PartnerEntity;
import org.dealoftheday.bl.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "partnerService")
@Transactional
public class PartnerServiceImpl implements PartnerService{
	
	final private PartnerDao partnerDao;

	@Autowired
	public PartnerServiceImpl(PartnerDao partnerDao) {
		this.partnerDao = partnerDao;
	}

	@Override
	public Partner insert(Partner partner) {
		PartnerEntity entity = PartnerAssembler.getEntity(partner);
		entity = partnerDao.insert(entity);
		partner = PartnerAssembler.getDTO(entity);
		return partner;
	}

	@Override
	public Partner get(Integer id) {
		PartnerEntity entity = partnerDao.get(id);
		Partner partner = PartnerAssembler.getDTO(entity);
		return partner;
	}

	@Override
	public Partner update(Partner partner) {
		PartnerEntity entity = PartnerAssembler.getEntity(partner);
		PartnerEntity entityUp = partnerDao.update(entity);
		partner = PartnerAssembler.getDTO(entityUp);
		return partner;
	}

	@Override
	public List<Partner> getAll() {
		List<PartnerEntity> entityList = partnerDao.getAll();
		List<Partner> dtoList = PartnerAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public boolean delete(Integer id) {
		return partnerDao.delete(id);
	}
}
