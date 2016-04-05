package com.project.steps;



import org.junit.Assert;

import com.project.services.CustomerService;
import com.project.services.IConstant;
import com.project.services.LoginService;
import com.project.services.ServiceFactory;
import com.project.session.Session;
import com.project.session.SessionManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerCompanyRelationshipAge 
{	

	@Given("^I was authenticated and have a valid session$")
	public void i_was_authenticated_and_have_a_valid_session() throws Exception
	{
		LoginService service = (LoginService)ServiceFactory.getInstance().getService(
										ServiceFactory.LOGIN_SERVICE);
		service.loginTechNuclues( IConstant.SERVICES_USERNAME,
				 IConstant.SERVICES_PASSWORD);
	}

	@When("^I retrieved releationship age$")
	public void i_retrieved_releationship_age() throws Exception 
	{	
		CustomerService service = (CustomerService)ServiceFactory.getInstance().getService(ServiceFactory.CUSTOMER_SERVICE);
		String accountCustomerHistory =   IConstant.SERVICES_TIMELINE_CUSTOMER_HISTORY_AGE;
		service.getCustomerHistory("8772105571043633")  ;
		service.getCustomerHistory(accountCustomerHistory)  ;
	}

	@Then("^I will get the customer releationship date$")
	public void i_will_get_the_customer_releationship_date() 
	{
		Session session = SessionManager.getInstance().getSession(IConstant.CURRENT_SESSION);
		String response = (String)session.getResponses().get(CustomerService.SERVICE_CUSTOMER_HISTORY_AGE);
		Assert.assertTrue(response.contains("0 years 5 months"));
	}
}
