package com.bookmyfurniture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.bookmyfurniture.utility.PageActions;

public class LoginPage {

	WebDriver driver;
	PageActions basePage;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		basePage = new PageActions(driver);		
	}

	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Sign In ')]")
	WebElement signInLinK;

	@FindBy(how=How.XPATH,using ="(//input[@placeholder='Enter Email'])[1]")
	WebElement enterEmail;

	@FindBy(how=How.XPATH,using ="(//input[@placeholder='Enter Password'])[1]")
	WebElement enterPassword;
	
	@FindBy(how=How.XPATH,using ="(//button[contains(text(),'Sign In')])[1]")
	WebElement clickSignIn;
	
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Hi,')]")
	WebElement userLoggedIn;
	
	@FindBy(how=How.XPATH,using ="//div[@role='alert' and contains(text(),'Invalid Email or Password !!! ')]")
	WebElement invalidUserNameError;
	
	@FindBy(how=How.XPATH,using ="(//mat-icon[contains(text(),'power_settings_new')])[2]")
	WebElement logoutButton;
	
	@FindBy(how=How.XPATH,using="//div[@id='toast-container']")
	WebElement toastMsg;
	
	
	public WebElement signInLink() {
		return signInLinK;
	}
	
	public WebElement emailField() {
		return enterEmail;
	}
	
	public WebElement userPasswordField() {
		return enterPassword;
	}
	
	public WebElement loginButton() {
		return clickSignIn;
	}
	
	public WebElement userLoggedIn() {
		return userLoggedIn;
	}
	
	public WebElement invalidUserNameErrorMsg() {
		return invalidUserNameError;
	}
	public WebElement logoutButton() {
		return logoutButton;
	}
	
	public WebElement toastMsgElement() {
		return toastMsg;
	}	
}
