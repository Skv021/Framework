package com.bookmyfurniture.services;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetToken {
	String baseURi = "http://okmry52647dns.eastus.cloudapp.azure.com:8089/";
	static String token_value;
	RequestSpecification httpRequest;
	Response productInfoResponse;

	@BeforeClass
	public void setProxy() {
		//System.setProperty("http.proxyHost", "127.0.0.1");
		//System.setProperty("http.proxyPort", "9000");
	}

	@Test(priority = 1)
	public void getAuthToken() {
		httpRequest = RestAssured.given().baseUri(baseURi).header("Content-Type", "application/x-www-form-urlencoded")
				.header("Authorization", "Basic amFtYWxDbGllbnRIZXJlOmphbWFsU2VjcmV0SGVyZQ==");

		httpRequest.formParam("username", "abcxyz@test.com").formParam("password", "Test@1234").formParam("grant_type",
				"password");
		Response response = httpRequest.post("/oauth/token");
		JSONObject jsonObject = new JSONObject(response.body().asString());

		token_value = jsonObject.get("access_token").toString();
		System.out.println(token_value);

	}

	// @Test
	public void signUpUser() {
		httpRequest = RestAssured.given().baseUri(baseURi).header("Content-Type", "application/json");
		JsonObject loginCredentials = new JsonObject();
		loginCredentials.addProperty("name", "abcxyz@test.com");
		loginCredentials.addProperty("mobileNo", "9876501234");
		loginCredentials.addProperty("emailId", "abc@test.com");
		loginCredentials.addProperty("password", "Test@1234");
		httpRequest.body(loginCredentials.toString());
		Response response = httpRequest.post("/rest/api/signup/");
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}

	// @Test(priority=2)
	public void loginApi() {
		httpRequest = RestAssured.given().baseUri(baseURi).header("Content-Type", "application/json");
		// Create new JSON Object
		JsonObject loginCredentials = new JsonObject();
		loginCredentials.addProperty("emailId", "abcxyz@test.com");
		loginCredentials.addProperty("password", "Test@1234");
		httpRequest.body(loginCredentials.toString());
		Response response = httpRequest.post("/rest/api/login/signin");

		System.out.println("authorizationHeader" + response.getHeader("Content-Type"));

		System.out.println("responsse-->" + response.body().asString());
		Assert.assertEquals(response.getStatusCode(), 202);
	}

	// @Test(priority = 3)
	public void showCartItems() {
		Response res = given().header("Authorization", "Bearer " + token_value)
				.header("Content-Type", "application/json").baseUri(baseURi).basePath("/rest/api/cart/141").when()
				.get();
		System.out.println((res.getStatusCode()));

		Assert.assertEquals(res.getStatusCode(), 200);
	}

	 @Test(priority=2)
	public void searchAProduct() {
		String searchProduct = "Chair";
		httpRequest = RestAssured.given().baseUri(baseURi).header("Content-Type", "application/json")
				.basePath("/rest/api/product/search/");

		productInfoResponse = httpRequest.given().pathParam("key", searchProduct).when().get("/{key}");

		System.out.println(productInfoResponse.getBody().asString());

	}

	// @Test(priority=3)
	public void addAProducttoCart() {
		JSONObject jsonObject = new JSONObject(productInfoResponse);
		httpRequest = RestAssured.given().header("Authorization", "Bearer " + token_value)
				.header("Content-Type", "application/json").baseUri(baseURi);

		httpRequest.body(jsonObject);
		Response response = httpRequest.post("/rest/api/cart/user/141");
		System.out.println((response.getStatusCode()));
	}

	//@Test(priority=2)
	public void getPlacedOrder() {
		httpRequest = RestAssured.given().header("Authorization", "Bearer " + token_value)
				.header("Content-Type", "application/json").baseUri(baseURi);
		String request_payload = "{\"price\":\"27000\",\"product\":{\"pid\":\"5\"},\"quantity\":\"1\",\"user\":{\"userId\":\"141\"},\"orderDate\":\"2020-02-01T09:38:30.485Z\"}";
		// JSONObject
		httpRequest.body(request_payload);
		Response response = httpRequest.post("/rest/api/order/");
		System.out.println("placed order LogStatus code ->" + response.getStatusCode());
	}
}
