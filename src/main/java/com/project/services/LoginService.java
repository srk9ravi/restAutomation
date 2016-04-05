package com.project.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.comcast.cable.utils.TestProperties;
import com.project.session.Session;
import com.project.session.SessionManager;

public class LoginService extends AbstractService
{
    
	public void loginTechNuclues(String username , String password) throws Exception
	{
		String url =  IConstant.SERVICES_PROTOCOL +"://"+
					  IConstant.SERVICES_DEV_SERVER + ":" +
					  IConstant.SERVICES_DEV_PORT +
					  IConstant.SERVICES_LOGIN_URL;	
		Session session = SessionManager.getInstance().getSession(IConstant.CURRENT_SESSION);
		String request = "j_username="+username + "&" + "j_password=" + password;	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<String> req = new HttpEntity<String>(request,headers);
		HttpEntity<String> response = session.getRestTemplate().exchange(
				url, HttpMethod.POST, req, String.class);
		headers = response.getHeaders();
		extractCookies(headers,session);
	}
	
	public void logoutTechNuclues() throws Exception
	{
		String url =  IConstant.SERVICES_PROTOCOL +"://"+
				  IConstant.SERVICES_DEV_SERVER + ":" +
				  IConstant.SERVICES_DEV_PORT +
				  IConstant.SERVICES_LOGOUT_URL;
		HttpHeaders head = new HttpHeaders();
		Session session = SessionManager.getInstance().getSession(IConstant.CURRENT_SESSION);
		head.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		head.put("Cookie", Arrays.asList(new String[]{getCookiesString()}));
		HttpEntity<String> req = new HttpEntity<String>(head);
		HttpEntity<String> response = session.getRestTemplate().exchange(url, HttpMethod.POST,
				req, String.class);
		response.getBody();
	}
	
	/**
	   * Extract cookies from a response header.
	   * the same key.
	   *
	   * @param headers response header
	   */
	  protected void extractCookies(HttpHeaders headers,Session session) {
	    List<String> cookiesList = headers.get("Set-Cookie");
	    if (cookiesList != null && !cookiesList.isEmpty()) {
	      String cookiesStr = cookiesList.get(0);
	      String[] cookiesSplit = cookiesStr.split(";");
	      for (String cookieStr : cookiesSplit) {
	        String[] keyValueSplit = cookieStr.split("=");
	        if(keyValueSplit.length > 1)
	        {
	        	session.getCookies().put(keyValueSplit[0], keyValueSplit[1]);
	        }
	      }
	    }
	  } 	
}
