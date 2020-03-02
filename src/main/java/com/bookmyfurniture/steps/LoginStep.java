package com.bookmyfurniture.steps;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;

import com.bookmyfurniture.pages.LoginPage;
import com.bookmyfurniture.utility.PageActions;
import com.bookmyfurniture.utility.ReadData;
import com.bookmyfurniture.utility.UtilClass;

public class LoginStep {

	WebDriver driver;
	LoginPage loginPage;
	PageActions action;
	UtilClass basePage;
	public LoginStep(WebDriver driver) {
		this.driver=driver;
		loginPage=new LoginPage(driver);
		action =new PageActions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
	}

	
	public void clickOnHomeLink() {
		//action.waitTillInvisbilityOfToastMsg(loginPage.toastMsgElement());
		action.Click(loginPage.signInLink());
	}

	public void sendUserName() {
		action.sendData(loginPage.emailField(), ReadData.getDataValue("email","data"));

	}
	
	public void sendWrongUserName() {
		action.sendData(loginPage.emailField(), "abcxyz@xyztest.com");

	}
	
	public void sendPassword() {
		action.sendData(loginPage.userPasswordField(), "Test@1234");
	}
	
	public void sendWrongPassword() {
		action.sendData(loginPage.userPasswordField(), "Test@12345678");
	}
	

	public void clickLoginButton() {
		action.Click(loginPage.loginButton());
	}
	
	public void verifyUserLoggedIn() {
		action.Exists(loginPage.userLoggedIn());
	}
	
	public void verifyErrorMsg() {
		try {
		action.waitTillInvisbilityOfToastMsg(loginPage.toastMsgElement());
		}
		catch(InvalidSelectorException e) {
			System.out.println((e.getMessage()));
		}
		action.Exists(loginPage.invalidUserNameErrorMsg());
	}
	public void verifyCurrentUrl(String actualHeader) {
		action.verifyPageOpensUp(actualHeader);
	}
	
	public void loggedInUserHiButton() {
		action.waitTillInvisbilityOfToastMsg(loginPage.toastMsgElement());
		action.Click(loginPage.userLoggedIn());
	}
	
	public void clickLogoutButton() {		
		action.Click(loginPage.logoutButton());
		action.waitTillInvisbilityOfToastMsg(loginPage.toastMsgElement());
	}
}
