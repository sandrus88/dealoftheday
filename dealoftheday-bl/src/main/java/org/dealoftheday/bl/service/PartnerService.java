package org.dealoftheday.bl.service;

import java.util.List;

import org.dealoftheday.bl.domain.Partner;

public interface PartnerService {
	
	Partner insert(Partner partner);

    Partner get(Integer id);

    Partner update(Partner partner);

    List<Partner> getAll();

    boolean delete(Integer id);
}
