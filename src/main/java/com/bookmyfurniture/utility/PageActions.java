package com.bookmyfurniture.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageActions {

	WebDriver driver;
	Logger logger;
	public static ExtentTest test;

	public PageActions(WebDriver driver) {
		this.driver = driver;
		logger = Logger.getLogger(this.getClass());
		
	}

	public boolean verifyPageOpensUp(String expectedUrl) {
		try {
			if (driver.getCurrentUrl().contains(expectedUrl)) {
				logger.info("Current Page URL " + driver.getCurrentUrl() + " is matching with expected " + expectedUrl
						+ " url");
				test.log(LogStatus.INFO, "Current Page URL " + driver.getCurrentUrl() + " is matching with expected " + expectedUrl
						+ " url");
				return true;
			} else {
				logger.error("Current Page URL " + driver.getCurrentUrl() + " is not matching with expected "
						+ expectedUrl + " url");
				test.log(LogStatus.INFO,"Current Page URL " + driver.getCurrentUrl() + " is not matching with expected "
						+ expectedUrl + " url");
				
				return false;
			}
		} catch (Exception e) {
			logger.error("Exception in verifyPageOpensUp method- " + e.getMessage());
			test.log(LogStatus.FAIL, (e.getMessage()));
			return false;
		}
	}

	public void Exists(WebElement webelementOnpage) {
		try {
			if (webelementOnpage == null) {
				logger.info(webelementOnpage + " is found");
				test.log(LogStatus.INFO, webelementOnpage + " is found");
			}
		} catch (Exception e) {
			logger.error(webelementOnpage + " not found");
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

	public void Click(WebElement element) {
		try {
			waitForAnElementToBeVisible(element);
			logger.info("Element " + element + " found on the page");
			test.log(LogStatus.INFO,"Element " + element + " found on the page");
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			logger.info("Element " + element + " clicked successfully");
			test.log(LogStatus.INFO, "Element " + element + " clicked successfully");
		} catch (Exception e) {
			logger.error("Exception in Click method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

	public void sendData(WebElement element, String data) {
		try {
			Click(element);
			clearATextField(element);
			logger.info("Cleared the " + element + " text field");
			test.log(LogStatus.INFO, "Cleared the " + element + " text field");
			element.sendKeys(data);
			logger.info("Send data to " + element + " sucessfully");
			test.log(LogStatus.INFO,"Send data to " + element + " sucessfully");
		} catch (Exception e) {
			logger.error("Exception in sendData method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

	public WebElement waitForElement(WebElement element) {
		try {
			if (element != null) {
				logger.info("Element " + element + " found");
				test.log(LogStatus.INFO,"Element " + element + " found");
				return element;
			} else {
				logger.error("Element " + element + " not found");
				test.log(LogStatus.INFO,"Element " + element + " not found");
			}
		} catch (Exception e) {
			logger.error("Exception in waitForElement method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
		return element;
	}

	public void selectTheValue(WebElement selectTagName, String value) {
		try {
			selectTagName.click();
			logger.info("Clicked on the select field " + selectTagName);
			test.log(LogStatus.INFO,"Clicked on the select field " + selectTagName);
			Select select = new Select(selectTagName);
			select.selectByVisibleText(value);
			logger.info("Slected the " + value + " from " + selectTagName + " sucessfully");
			test.log(LogStatus.INFO,"Slected the " + value + " from " + selectTagName + " sucessfully");
		} catch (Exception e) {
			logger.error("Exception in selectTheValue method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

	public void swipeWhileNotFound(WebElement element, int maxRounds) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// Vertical scroll - down by 150 pixels
			for (int scrollCounter = 0; scrollCounter < maxRounds; scrollCounter++) {
				if (isElementPresent(element)) {
					break;
				}
				js.executeScript("window.scrollBy(0,100)");
				logger.info("Swiping : ");
				test.log(LogStatus.INFO,"Swiping : ");
			}
		} catch (Exception e) {
			logger.error("Exception in swipeWhileNotFound method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

	private boolean isElementPresent(WebElement element) {
		try {
			driver.findElement(By.xpath(element.toString()));
			logger.info("Element " + element + " found");
			test.log(LogStatus.INFO,"Element " + element + " found");
			return true;
		} catch (NoSuchElementException e) {
			logger.error("Exception in isElementPresent method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
			return false;
		}
	}

	public void verifyPageHeader(String header) {
		try {
			String pageTitle = driver.getTitle();
			if (pageTitle.equalsIgnoreCase(header)) {
				logger.info("Header " + header + " is found");
				test.log(LogStatus.INFO,"Header " + header + " is found");
			} else {
				logger.info("Header " + header + " is not found");
				test.log(LogStatus.INFO,"Header " + header + " is not found");
			}
		} catch (Exception e) {
			logger.error("Exception in verifyPageHeader method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

	public void clearATextField(WebElement element) {
		try {
			if (!(element.getAttribute("value").equalsIgnoreCase(""))) {
				logger.info("Element field " + element + " value attribute recived sucessfully");
				test.log(LogStatus.INFO,"Element field " + element + " value attribute recived sucessfully");
				element.clear();
				logger.info("Element field " + element + " is cleared sucessfully");
				test.log(LogStatus.INFO,"Element field " + element + " is cleared sucessfully");
			}
		} catch (Exception e) {
			logger.error("Exception in clearATextField method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

	public void waitForAnElementToBeVisible(WebElement element) {
		try {
			String xpathExpressionTemp = element.toString().split("xpath: ")[1].trim();
			String xpathExpression = xpathExpressionTemp.substring(0, xpathExpressionTemp.length() - 1);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			logger.info("Wait for the " + element);
			test.log(LogStatus.INFO,"Wait for the " + element);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
			logger.info("Wait for the " + element + " to be visible");
			test.log(LogStatus.INFO,"Wait for the " + element + " to be visible");
			wait.until(ExpectedConditions.elementToBeClickable(element));
			logger.info("element is clickable");
			test.log(LogStatus.INFO,"element is clickable");
		} catch (Exception e) {
			logger.error("Exception in waitForAnElementToBeVisible method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

	public void waitTillInvisbilityOfToastMsg(WebElement element) {
		try {
			String xpathExpressionTemp = element.toString().split("xpath: ")[1].trim();
			String xpathExpression = xpathExpressionTemp.substring(0, xpathExpressionTemp.length() - 1);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			logger.info("Wait for the " + element + " to be invisible");
			test.log(LogStatus.INFO,"Wait for the " + element + " to be visible");
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpathExpression))));
			logger.info("element is invisible now");
			test.log(LogStatus.INFO,"element is invisible now");
		} catch (Exception e) {
			logger.error("Exception in waitTillInvisbilityOfToastMsg method- " + e.getMessage());
			test.log(LogStatus.FAIL,(e.getMessage()));
		}
	}

}
