package org.dealoftheday.admin.appbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class LocaleBean {

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		this.locale = new Locale(language);
	}

}
