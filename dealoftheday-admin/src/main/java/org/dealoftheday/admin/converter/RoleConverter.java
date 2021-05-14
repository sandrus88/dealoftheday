package org.dealoftheday.admin.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.dealoftheday.admin.backingbean.UserController;
import org.dealoftheday.admin.util.JSFUtil;
import org.dealoftheday.bl.domain.Role;

@FacesConverter("roleConverter")
public class RoleConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        UserController usercontroller = JSFUtil.findBean("userController");
        for (Role role : usercontroller.getAllRoles()) {
            if (role.getName().equals(value)) {
                return role;
            }
        }
        return null;
//        return new Role(-1, value, null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Role) {
            return ((Role) value).getName();
        } else {
            return "";
        }
    }
}