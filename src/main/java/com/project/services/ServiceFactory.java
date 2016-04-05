 package com.project.services;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory 
{  	
	private static ServiceFactory instance = new ServiceFactory();
		
	private Map<String,AbstractService> services = new HashMap<String,AbstractService>();
				
	public final static String CUSTOMER_SERVICE = "CustomerService";
		
	public final static String LOGIN_SERVICE = "CustomerService";
	
	private ServiceFactory()
	{
		services.put(CUSTOMER_SERVICE, new CustomerService());
		services.put(CUSTOMER_SERVICE, new LoginService());	
	}
	
	public static ServiceFactory getInstance()
	{
		return instance;
	}
	
	public AbstractService getService(String serviceName)
	{
		AbstractService service = null;		
		if(services.containsKey(serviceName))
		{
			service = services.get(serviceName);	
		}else{
			throw new IllegalArgumentException("Requested Service name "
	  				+ "is not avilable : "+serviceName);
		}
		return service;
	}

	
}
