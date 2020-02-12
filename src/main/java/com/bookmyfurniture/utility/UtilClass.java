package com.bookmyfurniture.utility;


import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilClass {

	Logger logger;

	public UtilClass() {

	}

	public UtilClass(WebDriver driver) {
		logger = Logger.getLogger(this.getClass());
	}

	public static String generateRandomString(int size) {
		String sequence = "abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		int randomIndex;
		char seq[] = new char[size];
		for (int i = 0; i < size; i++) {
			randomIndex = random.nextInt(size) + 1;
			seq[i] = sequence.charAt(randomIndex);
		}
		return new String(seq);

	}

	public void deleteAllImages() throws IOException {
		File folder = new File(System.getProperty("user.dir") + "\\target\\" + "\\Screenshots\\");
		if (folder.exists()) {
			FileUtils.cleanDirectory(folder);
		}

	}

	public String addScreenshot(WebDriver driver) throws IOException, InterruptedException {
		TakesScreenshot takeScreenshot = ((TakesScreenshot) driver);
		File srceenShotFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String fileName = System.getProperty("user.dir") + "\\target\\" + "\\Screenshots\\" + generateRandomString(10)
				+ ".png";
		File screenshotFileLocation = new File(fileName);
		FileUtils.copyFile(srceenShotFile, screenshotFileLocation);

		Thread.sleep(1000);
		return fileName;
	}
	
	public static String generateEmailId() {
		return RandomStringUtils.randomAlphanumeric(10);
	}
	
	public static String generateRandomNumber(int size) {
		return RandomStringUtils.randomNumeric(size);
	}
	public static void deleteReports() throws IOException {
		try {
		File sourceFolderName = new File(System.getProperty("user.dir") + "\\extentReports\\");		
		File destinationFolderName = new File(System.getProperty("user.dir") + "\\All_reports\\");
		if(!destinationFolderName.exists()) {
			destinationFolderName.mkdir();
		}
		FileUtils.copyDirectory(sourceFolderName, destinationFolderName);
 
		File folder = new File(System.getProperty("user.dir") + "\\extentReports\\");
		if (folder.exists()) {
			FileUtils.cleanDirectory(folder);
		}
		}
		catch(Exception e) {
			System.out.println((e.getMessage()));
		}
	}
}
