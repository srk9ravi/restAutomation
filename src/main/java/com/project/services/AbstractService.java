package com.project.services;

import com.project.session.Session;
import com.project.session.SessionManager;
	
public abstract class AbstractService
{			
	  /**
	   * Get the cookies string to write in the request header.
	   *
	   * @return cookies as string
	   */
	  protected String getCookiesString() {
		Session session = SessionManager.getInstance().getSession(IConstant.CURRENT_SESSION);
	    StringBuilder sb = new StringBuilder();
	    if (!session.getCookies().isEmpty()) {
	    	session.getCookies().entrySet().forEach(entry -> {
	        sb.append(entry.getKey());
	        sb.append("=");
	        sb.append(entry.getValue());
	        sb.append(";");
	      });
	      sb.deleteCharAt(sb.length() - 1);
	    }
	    return sb.toString();
	  }
}
