package com.EmplyeesAPIUtilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils 
{
	public static String empname()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}
	
	public static String empsalary()
	{
		String generatedString = RandomStringUtils.randomNumeric(5);
		return generatedString;
	}
	
	public static String empage()
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return generatedString;
	}
}
