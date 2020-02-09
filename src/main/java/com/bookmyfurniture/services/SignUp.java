package com.bookmyfurniture.services;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookmyfurniture.entity.Profile;
import com.bookmyfurniture.utility.DbConnection;
import com.bookmyfurniture.utility.UtilClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SignUp extends GetToken {

	Logger logger = Logger.getLogger(this.getClass());
	DbConnection dbConn;

	@Test
	public void signUpAUser() {
		dbConn = new DbConnection();
		Profile userProfile = new Profile(UtilClass.generateEmailId() + "@test.com", UtilClass.generateRandomNumber(10),
				"Joker singh", "Test@12390");
		httpRequest = RestAssured.given().baseUri(baseURi).header("Content-Type", "application/json");

		Response response = httpRequest.body(userProfile).when().post("/rest/api/signup/");
		logger.info(response.getStatusCode());
		System.out.println(response.getBody().asString());
		dbConn.verifyRegisteredUserDataInDb(userProfile);
		Assert.assertEquals(response.getStatusCode(), 202);
	}
}
