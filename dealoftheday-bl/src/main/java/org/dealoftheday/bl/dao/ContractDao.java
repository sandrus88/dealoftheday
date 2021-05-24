package org.dealoftheday.bl.dao;

import java.util.List;

import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.ContractSearchBean;
import org.dealoftheday.bl.entities.ContractEntity;

public interface ContractDao {
	
	ContractEntity insert(ContractEntity contractEntity);

    ContractEntity get(Integer id);

    ContractEntity update(ContractEntity contractEntity);

    List<ContractEntity> getAll();

    boolean delete(Integer id);

	List<ContractEntity> searchContract(ContractSearchBean searchBean);

}
