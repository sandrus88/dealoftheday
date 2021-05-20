package org.dealoftheday.admin.backingbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Contract;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.service.ContractService;

@ManagedBean
@ViewScoped
public class ContractController {
	
	@ManagedProperty(value = "#{contractService}")
	private ContractService contractService;
	
	private static Logger logger = LogManager.getLogger(ContractController.class);
	
	private String newTitle;
	private String newDescription;
	private Float newPrice;
	private Date newDayOfSignature;
	private Partner newPartner;
	
	private Integer searchId;
	private String searchTitle;
	private Date searchDayOfSignature;
	private Partner searchPartner;
	
	private List<Partner> allPartners;
	private List<Contract> contractList = new ArrayList<>();
	private Contract selectedContract;
	
	@PostConstruct
	public void init() {
		allPartners = contractService.getAllPartners();
		selectedContract = new Contract();
		searchContract();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void searchContract() {
		Contract searchDto = new Contract(searchId, searchTitle, null, null, searchDayOfSignature, null, null, searchPartner);
		contractList = contractService.searchContract(searchDto);
	}

	public void cleanDialogForm() {
		newTitle = null;
		newDescription = null;
		newPrice = null;
		newDayOfSignature = null;
		newPartner = null;
	}

	public void cleanSearchForm() {
		searchId = null;
		searchTitle = null;
		searchDayOfSignature = null;
		searchPartner = null;
	}

	public void addContract() {
		Contract contract = new Contract();
		contract.setTitle(newTitle);
		contract.setDescription(newDescription);
		contract.setPrice(newPrice);
		contract.setDayOfSignature(newDayOfSignature);
		contract.setPartner(newPartner);
		contractService.insert(contract);
		cleanDialogForm();
		searchContract();
	}

	public void updateSelectedContract(Contract contract) {
		contractService.update(contract);
		searchContract();
	}

	public void deleteContract(Contract contract) {
		contractService.delete(contract.getId());
		searchContract();
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewDescription() {
		return newDescription;
	}

	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
	}

	public Float getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Float newPrice) {
		this.newPrice = newPrice;
	}

	public Date getNewDayOfSignature() {
		return newDayOfSignature;
	}

	public void setNewDayOfSignature(Date newDayOfSignature) {
		this.newDayOfSignature = newDayOfSignature;
	}

	public Partner getNewPartner() {
		return newPartner;
	}

	public void setNewPartner(Partner newPartner) {
		this.newPartner = newPartner;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public String getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public Date getSearchDayOfSignature() {
		return searchDayOfSignature;
	}

	public void setSearchDayOfSignature(Date searchDayOfSignature) {
		this.searchDayOfSignature = searchDayOfSignature;
	}

	public Partner getSearchPartner() {
		return searchPartner;
	}

	public void setSearchPartner(Partner searchPartner) {
		this.searchPartner = searchPartner;
	}

	public List<Partner> getAllPartners() {
		return allPartners;
	}

	public void setAllPartners(List<Partner> allPartners) {
		this.allPartners = allPartners;
	}

	public List<Contract> getContractList() {
		return contractList;
	}

	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	public Contract getSelectedContract() {
		return selectedContract;
	}

	public void setSelectedContract(Contract selectedContract) {
		this.selectedContract = selectedContract;
	}

	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
}
