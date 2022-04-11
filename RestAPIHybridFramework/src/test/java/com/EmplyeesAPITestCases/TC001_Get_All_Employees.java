package com.EmplyeesAPITestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EmplyeesAPIBase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase
{
	@BeforeClass
	void getAllEmployees() throws Exception
	{
		logger.info("************ Started TC001_Get_All_Employees ************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/public/api/v1";
		httprequest = RestAssured.given();
		response = httprequest.request(Method.GET,"/employees");
		
		Thread.sleep(5000);	
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("************ Checking Response Body ************");
		String response_body = response.getBody().asString();
		logger.info("Response Body ===> "+response_body);
		Assert.assertTrue(response_body!=null);
		logger.info("-----------------------------------------------------------");
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("************ Checking Status Code ************");
		int response_code = response.getStatusCode();
		logger.info("Status Code ===> "+response_code);
		Assert.assertEquals(response_code, 200);
		logger.info("-----------------------------------------------------------");
	}
	
	@Test
	void checkResponseTime()
	{
		logger.info("************ Checking Response Time ************");
		long response_time = response.getTime();
		logger.info("Response Time ===> "+response_time);
		
		if(response_time > 2000)
		{
			logger.warn("Response time is greater than 2000");
		}
		
		Assert.assertTrue(response_time<2000);
		logger.info("-----------------------------------------------------------");
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("************ Checking Status Line ************");
		String status_line = response.getStatusLine();
		logger.info("Status Line ===> "+status_line);
		Assert.assertEquals(status_line, "HTTP/1.1 200 OK");
		logger.info("-----------------------------------------------------------");
	}
	
	@Test
	void getContentType()
	{
		logger.info("************ Checking Content Type ************");
		String content_type = response.header("Content-Type") ;
		logger.info("Content Type ===> "+content_type);
		Assert.assertEquals(content_type, "application/json");	
		logger.info("-----------------------------------------------------------");
	}
	
	@Test
	void getContentEncoding()
	{
		logger.info("************ Checking Content Encoding ************");
		String content_encoding = response.header("Content-Encoding") ;
		logger.info("Content Encoding ===> "+content_encoding);
		Assert.assertEquals(content_encoding, "gzip");	
		logger.info("-----------------------------------------------------------");
	}
	
	@Test
	void getServerType()
	{
		logger.info("************ Checking Server Type ************");
		String server_type = response.header("Server") ;
		logger.info("Server ===> "+server_type);
		Assert.assertEquals(server_type, "nginx");
		logger.info("-----------------------------------------------------------");
	}
	
	@Test
	void getContentLength()
	{
		logger.info("************ Checking Content Length ************");
		String content_length = response.header("Content-Length") ;
		logger.info("Content Length ===> "+content_length);
		
		if(Integer.parseInt(content_length) < 100)
		{
			logger.warn("Content length is less than 100");
		}
		Assert.assertTrue(Integer.parseInt(content_length)>100);
		logger.info("-----------------------------------------------------------");
	}
	
//	@Test
//	void checkCookies()
//	{
//		logger.info("************ Checking Cookies ************");
//		String cookie = response.getCookie("PHPSESSID");
//		Assert.assertTrue(cookie!=null);
//	}
	
	@AfterClass
	public void afterExcecution()
	{
		logger.info("************ Finished TC001_Get_All_Employees ************");
	}
	
}
