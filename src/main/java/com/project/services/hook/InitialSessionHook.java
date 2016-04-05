package com.project.services.hook;

import com.project.services.IConstant;
import com.project.session.Session;
import com.project.session.SessionManager;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class InitialSessionHook
{
	@Before("@service")
	public void beforeScenario() 
	{
		SessionManager manager = SessionManager.getInstance();
		Session session = new Session();
		manager.setSession(IConstant.CURRENT_SESSION, session);
	}

	@After("@service")
	public void afterScenario()
	{
		SessionManager manager = SessionManager.getInstance();
		manager.removeSession(IConstant.CURRENT_SESSION);
	}
}