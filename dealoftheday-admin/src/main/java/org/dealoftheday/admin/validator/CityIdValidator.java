package org.dealoftheday.admin.validator;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cityIdValidator")
public class CityIdValidator implements Validator{

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	private static final String ID_PATTERN = "[A-Z]+";

	private Pattern pattern;
	private Matcher matcher;
	public ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
	public String message = bundle.getString("city.id.error");
	public String message1 = bundle.getString("city.id.validation");

	public CityIdValidator() {
		pattern = Pattern.compile(ID_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {

			FacesMessage msg = new FacesMessage(message1, message);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
