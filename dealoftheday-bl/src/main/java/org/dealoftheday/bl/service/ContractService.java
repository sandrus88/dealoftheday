package org.dealoftheday.bl.service;

import java.util.List;

import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.domain.Contract;

public interface ContractService {
	
	Contract insert(Contract contract);

    Contract get(Integer id);

    Contract update(Contract contract);

    List<Contract> getAll();

    boolean delete(Integer id);
    
    List<Contract> searchContract(Contract searchDto);
    
    List<Partner> getAllPartners();

}
