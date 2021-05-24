package org.dealoftheday.bl.service;

import java.util.List;

import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.ContractSearchBean;

public interface ContractService {
	
	Contract insert(Contract contract);

    Contract get(Integer id);

    Contract update(Contract contract);

    List<Contract> getAll();

    boolean delete(Integer id);
    
    List<Contract> searchContract(ContractSearchBean searchBean);
}
