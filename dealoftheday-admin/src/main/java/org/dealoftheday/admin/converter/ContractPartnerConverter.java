package org.dealoftheday.admin.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Partner;
import org.dealoftheday.bl.service.ContractService;

@ManagedBean
@FacesConverter("contractPartnerConverter")
public class ContractPartnerConverter implements Converter {
	
	@ManagedProperty(value = "#{contractService}")
	private ContractService contractService;
	
	private static Logger logger = LogManager.getLogger(ContractPartnerConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<Partner> partners = contractService.getAllPartners();
        for (Partner partner : partners) {
            if (partner.getId().equals(Integer.parseInt(value))) {
                return partner;
            }
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!(value instanceof Partner)) {
			return null;
		}
		return String.valueOf(((Partner) value).getId());
	}

	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
}
