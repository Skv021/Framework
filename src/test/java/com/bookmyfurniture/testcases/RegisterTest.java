package com.bookmyfurniture.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bookmyfurniture.steps.RegisterStep;

public class RegisterTest extends TestClass{
	RegisterStep registerStep;
	
	@BeforeClass(description="This method will pass the driver object to Register step class")
	public void initLog() {
		 registerStep=new RegisterStep(super.driver);
	}
	
	@Test(description="This test case will register a user sucessfully" ,groups = { "RegisterPositiveTest" })
	public void registerFurniture() {
		//test=extent.startTest("registerFurniture");
		registerStep.signInLink();	
		registerStep.createUser();
		registerStep.verifyRegisterPageDisplayed();
		registerStep.enterFullName();
		registerStep.enterMobile();
		registerStep.enterEmailId();
		registerStep.enterPassword();
		registerStep.clickRegisterLink();
		logger.info("Registereda user");
		//check DB if user exists there
	}
	@Test(description="This test will be passed")
	public void skv() {
		//test=extent.startTest("Dem");
		logger.info("test case passed");
	}
	
	@Test(description="This test will failed intentionally")
	public void faiTest() {
		//test = extent.startTest("TC_faiTest");
		Assert.fail("This test fails");
		logger.info("Test case failed");
	}
	
	
}
