package com.EmplyeesAPIBase;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase 
{
	public static RequestSpecification httprequest;
	public static Response response;
	
	public String empID = "3";
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger = Logger.getLogger("EmployeeLogs"); //added a logger
		PropertyConfigurator.configure("log4j.properties"); //added a logger
		logger.setLevel(Level.DEBUG);
	}
	

}
