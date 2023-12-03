package com.crio.webActions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class VerifyPost {
    @Test
    public void verifyPost(){
        RestAssured.baseURI="https://content-qtripdynamic-qa-backend.azurewebsites.net";
        RequestSpecification rs = RestAssured.given();
        rs.basePath("/api/v1/register");
        rs.contentType(ContentType.JSON);
        rs.body("{\"email\":\"suu@gmail.com\",\"password\":\"s@gmail.com\",\"confirmpassword\":\"s@gmail.com\"}");
        Response res=rs.post();
        System.out.println(res.getStatusCode());
        String resBody=res.jsonPath().get("$.success");
        System.out.println(resBody);

    }
    @Test
    public void verifyPut (){
        RestAssured.baseURI="https://demoqa.com";
        RequestSpecification rs = RestAssured.given();
        rs.header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImNyaW8tdG9vbHNAQUJDMTIzIiwicGFzc3dvcmQiOiJjcmlvLXRvb2xzQEFCQzEyMyIsImlhdCI6MTcwMTQ0MjExOX0.YzLmOXogAyl5E11n0Gycr5XyoKY7eEG20vsMXR2SU0Q");
        JSONObject jo=new JSONObject();
        jo.put("isbn", "9781593275846");
        jo.put("userId", "aac10e88-2a8d-4bab-bc4d-c47c38d4da2c");
        rs.body(jo.toJSONString());
        Response r=rs.put("/BookStore/v1/Books/9781449331818");
        System.out.println("Response Code"+r.getStatusCode());


        //9781593275846
    }

    
}
