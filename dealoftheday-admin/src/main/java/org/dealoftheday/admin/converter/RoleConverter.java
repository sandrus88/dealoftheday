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
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.service.UserService;

@ManagedBean
@FacesConverter("roleConverter")
public class RoleConverter implements Converter {
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	private static Logger logger = LogManager.getLogger(RoleConverter.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	List<Role> roles = userService.getAllRoles();
        for (Role role : roles) {
            if (role.getId().equals(Integer.parseInt(value))) {
                return role;
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Role) {
        	Integer valueAsInt = ((Role) value).getId();
            return String.valueOf(valueAsInt);
        } else {
            return "";
        }
    }

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}