package com.crio.webActions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.*;
import org.testng.annotations.Test;



public class Activity {
	@Test
	public void getRequest() {
		// RestAssured.baseURI = "https://content-qtripdynamic-qa-backend.azurewebsites.net";
		// RestAssured.basePath= "/api/v1/register";
		// RequestSpecification rs = RestAssured.given();
		// Response res=rs.request(Method.GET);
		// System.out.println(res.asString());

		RequestSpecification sp = RestAssured.given();
		sp.baseUri("https://content-qtripdynamic-qa-backend.azurewebsites.net");
		sp.basePath("/api/v1/cities");
		
		Response res=sp.get();
		System.out.println("Response Body:: "+res.asString());
		int statuscode =res.getStatusCode();
		if (statuscode == 200){
			System.out.println("Test Successfull");
		}else {
			System.out.println("Test Failed ");
		}




	}

	 @Test
	public void getRequestWithParams() {
		// RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net";
		// RestAssured.basePath="api/v1/products";
		// RequestSpecification re = RestAssured.given();
		// re.queryParam("value", "book");
		// Response rep=re.request(Method.GET);
		// System.out.println("Responce ::"+rep.asString());
		// if (rep.getStatusCode()==200){
		// 	System.out.println("Pass");
		// }else{
		// 	System.out.println("Fail");
		// }

		RequestSpecification rs = RestAssured.given();
		rs.baseUri("https://content-qkart-qa-backend.azurewebsites.net");
		rs.basePath("api/v1/products");
		rs.queryParam("value", "book");
		Response rep = rs.get();
		String body = rep.getBody().asString();
		int statuscode = rep.getStatusCode();
		System.out.println(statuscode);
		System.out.println(body);
		

		
	}

	@Test
	public void basicAuth() {
		// RequestSpecification httpRequest = RestAssured.given();

		// Response res = httpRequest.get("https://postman-echo.com/basic-auth");
		// String rbdy = res.body().asString();
		// System.out.println("Data from the GET API- " + rbdy);

		// RestAssured.baseURI="https://postman-echo.com";
		// RestAssured.basePath="/basic-auth";
		// RequestSpecification rs = RestAssured.given();
		// Response res=rs.request(Method.GET);
		// System.out.println("Response is "+res.getBody().asString());
		// System.out.println("Response Code is "+res.getStatusCode());

		// RequestSpecification rs = RestAssured.given();
		// rs.baseUri("https://postman-echo.com");
		// rs.basePath("/basic-auth");
		// rs.auth().basic("postman", "password");
		// Response res=rs.get();
		// System.out.println("Response is "+res.getBody().asString());
		// System.out.println("Response Code is "+res.getStatusCode());

		RequestSpecification rs = RestAssured.given();
		rs.auth().basic("postman", "password");
		Response res=rs.get("https://postman-echo.com/basic-auth");
		System.out.println("Response is "+res.getBody().asString());
		System.out.println("Response Code is "+res.getStatusCode());
		

	}

	 @Test
	public void bearerToken() {
		RestAssured.baseURI="https://content-qtripdynamic-qa-backend.azurewebsites.net";
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		JSONObject jo=new JSONObject();
		jo.put("email", "s1@gmail.com");
		jo.put("password", "s@gmail.com");
		rs.body(jo.toJSONString());
		rs.header("Content-Type", "application/json");
		Response res=rs.post("/api/v1/login");
		// System.out.println(res.body().asString());
		JsonPath jp=res.jsonPath();
		String token=jp.get("data.token");
		// System.out.println(token);

		rs.basePath("/api/v1/reservations");
		rs.queryParam("id", "4deaaikggRlD0oIt");
		rs.header("Authorization","Bearer "+token);
		Response res1=rs.get();
		System.out.println("Response code is "+res1.getStatusCode());
		
	
	}

	// @Test
	public void validateJSONSchema() {
	
	}

	// @Test
	public void validateWithHamcrestProductName() {
		
	}

}

