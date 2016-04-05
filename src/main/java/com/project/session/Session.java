package com.project.session;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class Session 
{
		private static  RestTemplate restTemplate = new RestTemplate();
		protected Map<String, String> cookies = new HashMap<String, String>();
	    protected Map<String,Object> responses = new HashMap<String,Object>();
		public static RestTemplate getRestTemplate() {
			return restTemplate;
		}
		public static void setRestTemplate(RestTemplate restTemplate) {
			Session.restTemplate = restTemplate;
		}
		public Map<String, String> getCookies() {
			return cookies;
		}
		public void setCookies(Map<String, String> cookies) {
			this.cookies = cookies;
		}
		public Map<String, Object> getResponses() {
			return responses;
		}
		public void setResponses(Map<String, Object> responses) {
			this.responses = responses;
		}
}
