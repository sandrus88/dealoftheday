package org.dealoftheday.admin.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.dealoftheday.bl.domain.City;

@FacesConverter("partnerCityConverter")
public class PartnerCityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}

		try {
			City city = new City();
			city.setId(value);
			return city;
		} catch (Exception exception) {
			throw new ConverterException(exception);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!(value instanceof City)) {
			return null;
		}
		return ((City) value).getId();
	}
}