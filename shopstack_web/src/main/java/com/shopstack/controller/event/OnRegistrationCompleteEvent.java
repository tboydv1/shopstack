package com.shopstack.controller.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.shopstack.entities.user.BusinessUser;


/**
 * @author oluwatobi
 *
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String appUrl;
	private Locale locale;
	private BusinessUser businessUser;
	
	public OnRegistrationCompleteEvent(BusinessUser businessUser, Locale locale, String appUrl) {
		
		super(businessUser);
		this.businessUser = businessUser;
        this.locale = locale;
        this.appUrl = appUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public BusinessUser getUser() {
		return businessUser;
	}

	public void setUser(BusinessUser businessUser) {
		this.businessUser = businessUser;
	}
	
	
	
	
}
