package com.bookmyfurniture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Sign In ')]")
	WebElement signInLinK;
	
	@FindBy(how=How.XPATH,using ="//button[@class='btn btn-primary btn-md' and contains(text(),'Create your Account')]")
	WebElement createYourAccount;
	
	@FindBy(how=How.XPATH,using ="//input[@placeholder='Enter User Name']")
	WebElement enterFullName;
	
	@FindBy(how=How.XPATH,using ="//input[@placeholder='Enter Mobile Number']")
	WebElement enterMobileNumer;
	
	@FindBy(how=How.XPATH,using ="//div[@class='sign-up-main']//..//input[@placeholder='Enter Email']")
	WebElement enterEmail;
	
	@FindBy(how=How.XPATH,using ="//div[@class='sign-up-main']//..//input[@placeholder='Enter Password']")
	WebElement enterPassword;
	
	@FindBy(how=How.XPATH,using ="//button[contains(text(),'Register')]")
	WebElement register;
	
	@FindBy(how=How.XPATH,using ="//h2[contains(text(),'Create Account')]")
	WebElement createYourAccountText;
	
	public WebElement clickSignIn() {
		return signInLinK;
	}
	
	public WebElement clickCreateYouerAccount() {
		return createYourAccount;
	}
	
	public WebElement enterFullName() {
		return enterFullName;
	}
	
	public WebElement enterMobileNum() {
		return enterMobileNumer;
	}
	
	public WebElement enterEmail() {
		return enterEmail;
	}
	
	public WebElement enterPassword() {
		return enterPassword;
	}
	
	public WebElement clickRegister() {
		return register;
	}
	
	public  WebElement registerPageElement() {
		return createYourAccountText;
	}
}
