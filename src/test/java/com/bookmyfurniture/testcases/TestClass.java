package com.bookmyfurniture.testcases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.bookmyfurniture.utility.ReadData;
import com.bookmyfurniture.utility.UtilClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestClass {

	WebDriver driver;
	static ExtentReports extent;
	ExtentTest test;
	Logger logger;

	@BeforeSuite
	public void setExtentReport() throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		UtilClass.deleteReports();
		String filePath = System.getProperty("user.dir") + "/extentReports/" + timeStamp + "/TestReport.html";
		extent = new ExtentReports(filePath, true);
		extent.addSystemInfo("Host name", "sweet").addSystemInfo("Environment", "QA").addSystemInfo("Host name",
				"Sweta Verma");
		extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
	}

	@Parameters("browser")
	@BeforeClass
	public WebDriver setDriver(String browserName) {
		String websiteUrl = ReadData.getDataValue("WEBSITE_URL", "config");
		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty(ReadData.getDataValue("CHROME_WEB_DRIVER", "config"),
					ReadData.getDataValue("CHROME_DRIVER_PATH", "config"));

			System.setProperty("webdriver.chrome.driver",
					new File(System.getProperty("user.dir"), "/lib/chromedriver.exe").getAbsolutePath());
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {

			System.setProperty(ReadData.getDataValue("IE_WEB_DRIVER", "config"),
					ReadData.getDataValue("IE_DRIVER_PATH", "config"));
			driver = new InternetExplorerDriver();
		}
		driver.get(websiteUrl);
		driver.manage().window().maximize();
		// Assert.assertEquals(driver.getCurrentUrl(), websiteUrl);
		logger = Logger.getLogger(this.getClass());

		PropertyConfigurator.configure("log4j.properties");

		// extent-report

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;

	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException {
		UtilClass util = new UtilClass();
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = util.addScreenshot(driver);

			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			test.log(LogStatus.FAIL, "Failed step is: " + test.addScreenCapture(path));

		} else if (result.getStatus() == ITestResult.SKIP) {
			util.addScreenshot(driver);
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			// BasePage.addScreenshot();
			test.log(LogStatus.PASS, "Test Case Passed sucessfully " + result.getName());
		}
		extent.endTest(test);
	}

	@AfterSuite
	public void destoryExtent() {
		extent.flush();
		extent.close();
	}

	@AfterClass
	public void close() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
