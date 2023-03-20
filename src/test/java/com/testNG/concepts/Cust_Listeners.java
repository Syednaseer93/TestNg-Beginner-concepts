package com.testNG.concepts;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class Cust_Listeners implements ITestListener {
	//wil execute before starting the test
	public void onStart(ITestContext args)
	{
		System.out.println("Starts to execute test");
	}	

}
