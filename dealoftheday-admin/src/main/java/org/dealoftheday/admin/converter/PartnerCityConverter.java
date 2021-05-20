package org.dealoftheday.admin.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.dealoftheday.bl.domain.City;
import org.dealoftheday.bl.service.PartnerService;

@ManagedBean
@FacesConverter("partnerCityConverter")
public class PartnerCityConverter implements Converter {
	
	@ManagedProperty(value = "#{partnerService}")
	private PartnerService partnerService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<City> cities = partnerService.getAllCities();
        for (City city : cities) {
            if (city.getId().equals(value)) {
                return city;
            }
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!(value instanceof City)) {
			return null;
		}
		return ((City) value).getId();
	}

	public void setPartnerService(PartnerService partnerService) {
		this.partnerService = partnerService;
	}
}