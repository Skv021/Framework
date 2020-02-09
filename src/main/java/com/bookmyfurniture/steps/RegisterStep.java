package com.bookmyfurniture.steps;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.bookmyfurniture.pages.RegisterPage;
import com.bookmyfurniture.utility.PageActions;
import com.bookmyfurniture.utility.ReadData;
import com.bookmyfurniture.utility.UtilClass;

public class RegisterStep {

	WebDriver driver;
	RegisterPage registerUser;
	PageActions action;
	UtilClass basePage;
	String usernmeForLogin;
	public RegisterStep(WebDriver driver) {
		this.driver=driver;
		registerUser=new RegisterPage(driver);
		action =new PageActions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	

	//===================================================
	
	public void signInLink() {
		action.Click(registerUser.clickSignIn());
	}
	
	public void createUser() {
		action.Click(registerUser.clickCreateYouerAccount());
	}
	
	public void enterFullName() {
		action.sendData(registerUser.enterFullName(), ReadData.getDataValue("username","data"));
		
	}
	
	public void enterMobile() {
		action.sendData(registerUser.enterMobileNum(), ReadData.getDataValue("phoneNo","data"));
		
	}
	
	public void enterEmailId() {
		basePage=new UtilClass();
		 usernmeForLogin=basePage.generateRandomString(6)+"@test.com";
		action.sendData(registerUser.enterEmail(), (usernmeForLogin));
	}
	
	public void enterPassword() {
		action.sendData(registerUser.enterPassword(), ReadData.getDataValue("password","data"));
		
	}
	
	public void clickRegisterLink() {
		action.Click(registerUser.clickRegister());
		
	}
	
	public void verifyUserRegistredSucessfully() {
		
	}
	
	public void verifyRegisterPageDisplayed() {
		action.Exists(registerUser.registerPageElement());
	}
}
