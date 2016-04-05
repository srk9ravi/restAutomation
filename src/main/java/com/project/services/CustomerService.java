package com.project.services;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.project.session.Session;
import com.project.session.SessionManager;

public class CustomerService extends AbstractService
{
	public static String SERVICE_CUSTOMER_HISTORY_AGE = "ServiceCustomerHistoryAge";
	
	public String getCustomerHistory(String accountNumber)  throws Exception
	{
		String url = IConstant.SERVICES_PROTOCOL +"://"+
				IConstant.SERVICES_DEV_SERVER  + ":" +
				 IConstant.SERVICES_DEV_PORT  +
				 IConstant.SERVICES_TIMELINE_BASE_URL  +accountNumber+
				 IConstant.SERVICES_TIMELINE_CUSTOMER_AGE_URL;		
		
		HttpHeaders head = new HttpHeaders();
		head.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		head.put("Cookie", Arrays.asList(new String[]{getCookiesString()}));
		HttpEntity<String> req = new HttpEntity<String>(head);
		Session session = SessionManager.getInstance().getSession(IConstant.CURRENT_SESSION);
		HttpEntity<String> response = session.getRestTemplate().exchange(
				url, HttpMethod.GET, req, String.class);
		String message = response.getBody();
		session.getResponses().put(SERVICE_CUSTOMER_HISTORY_AGE, message);
		return message;
	}
}
