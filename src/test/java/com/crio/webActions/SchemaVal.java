package com.crio.webActions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.util.ArrayList;
import org.testng.annotations.Test;

public class SchemaVal {

    @Test
    public void verifySchema(){

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RestAssured.basePath="posts/2";
        RequestSpecification rs = RestAssured.given();
        Response res=rs.request(Method.GET);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema.json")));


    }

    @Test
    public void VerifyQkartResponse(){
    RequestSpecification rs = RestAssured.given();
    Response res=rs.get("https://content-qkart-qa-backend.azurewebsites.net/api/v1/products");
    res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/JsonSchema.json")));
    System.out.println(res.getStatusCode()+" Response Code");
    JsonPath jp=res.jsonPath();
  ArrayList<String> stock=jp.get("stock");
    System.out.println(stock);




    }



    
}
