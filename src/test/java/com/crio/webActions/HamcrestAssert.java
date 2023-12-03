package com.crio.webActions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class HamcrestAssert {

    @Test
    public void verifyResponse (){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri(" https://content-qkart-qa-backend.azurewebsites.net");
        rs.basePath("/api/v1/products/34sLtEcMpzabRyfx");
        Response res = rs.get();
        res.then().body("stock",equalTo(10));
        res.then().body("cost", greaterThan(13));
        res.then().body("rating", lessThan(6));
        res.then().body("arguments", equalToCompressingWhiteSpace("expectedString"));

    }
}
