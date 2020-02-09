package com.bookmyfurniture.services;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.bookmyfurniture.entity.UserProfile;

import io.restassured.RestAssured;
import io.restassured.response.Response;

	public class SignUp extends GetToken{

		Logger logger = Logger.getLogger(this.getClass());
		@Test
		public void signUpAUser() {
	        UserProfile userProfile = new UserProfile("deaf90@test.com","7657349838","Joker singh","Test@12390");
	        httpRequest= RestAssured.given().baseUri(baseURi).header("Content-Type", "application/json");
	        Response response=httpRequest.body(userProfile).when().post("/rest/api/signup/");
	        logger.info(response.getStatusCode());
	        System.out.println(response.getBody().asString());
		}
		
		


}
