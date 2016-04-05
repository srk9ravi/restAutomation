package com.project.steps;
	
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
	
public class CucumberHooks {
	private static final Logger logger = LoggerFactory
			.getLogger(CucumberHooks.class);
	public static String scenarioName;
	public static Collection<String> tagNames;
	
	/**
	 * This method executes before every scenario using @Before annotation of Cucumber
	 * @param scenario			
	 * @throws Throwable
	 */
	@Before()
	public void startUp(Scenario scenario) throws Throwable {
		scenarioName = scenario.getName();
		logger.info("Scenario Name:- " + scenarioName);
		tagNames = scenario.getSourceTagNames();
		// include the code to mock the service if you don't have real end point
	}
	
	/**
	 * This method executes after every scenario using @After annotation of Cucumber
	 * To unregister all the services
	 */
	@After
	public void teardowniosDriver(Scenario scenario) throws Throwable {
		}
}