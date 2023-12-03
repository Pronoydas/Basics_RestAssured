import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class assertion_3 {

    @Test

    public void verify(){

        RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net/api/v1/products/34sLtEcMpzabRyfx";

        //RestAssured.basePath = "/api/v1/products";

        RequestSpecification http = RestAssured.given();
        Response response = http.request(Method.GET);

        response.then().body("stock", greaterThanOrEqualTo(8));


    }
}

