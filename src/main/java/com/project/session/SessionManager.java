package com.project.session;

import java.util.HashMap;
import java.util.Map;

public class SessionManager 
{	
	private Map<String,Session> sessionMap = new HashMap<String,Session>();
	
	private static SessionManager sessionManager = new SessionManager();

	private SessionManager(){};
	
	public static SessionManager getInstance()
	{
		return sessionManager;
	}	
	public Session getSession(String sessionName)
	{
		Session session = null;
		session = sessionMap.get(sessionName);
		return session;
	}	
	public void setSession(String sessionName,Session session)
	{
		sessionMap.put(sessionName,session);	
	}
	public void removeSession(String sessionName)
	{
		sessionMap.remove(sessionName);	
	}
}
