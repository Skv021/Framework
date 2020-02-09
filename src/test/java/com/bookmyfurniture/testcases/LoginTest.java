package com.bookmyfurniture.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bookmyfurniture.steps.LoginStep;

public class LoginTest extends TestClass{

	LoginStep loginStep;
	
	@BeforeClass(description="This method will pass the driver object to Login step class")
	public void initLog() {
		loginStep=new LoginStep(super.driver);
	}
	
	@Test(description="This test case will login a user sucessfully" ,groups = { "LoginPositiveTest" },priority=1)
	public void Login() {
		test = extent.startTest("Test sucessfull Login");
		loginStep.verifyCurrentUrl("http://okmry52647dns.eastus.cloudapp.azure.com:9090/user_entry/login");
		loginStep.clickOnHomeLink();
		loginStep.sendUserName();
		loginStep.sendPassword();
		loginStep.clickLoginButton();
		loginStep.verifyUserLoggedIn();
		logger.info("Logged in user");

	}
	
	@Test(priority=3,description="This test case will try to login with wrong password", groups= {"LoginNegativeTest"})
	public void LoginWithWrongPassword() {
		
		test=extent.startTest("Test for login with wrong password");
		loginStep.clickOnHomeLink();
		loginStep.sendUserName();
		loginStep.sendWrongPassword();
		loginStep.clickLoginButton();
		loginStep.verifyErrorMsg();
	}
	
	@Test(priority=4,description="This test case will try to login with wrong email-Id", groups= {"LoginNegativeTest"})
	public void LoginWithoutEmailId() {
		test=extent.startTest("Test for login with wrong email id");
		loginStep.clickOnHomeLink();
		loginStep.sendWrongUserName();
		loginStep.sendPassword();
		loginStep.clickLoginButton();
		loginStep.verifyErrorMsg();
		
	}
	
	@Test(priority=2)
	public void Logout()
	{
		System.out.println("In logout method");
		test=extent.startTest("Test for logout");
		loginStep.loggedInUserHiButton();
		loginStep.clickLogoutButton();
	}
}
