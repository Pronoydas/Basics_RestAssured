import io.restassured.http.ContentType;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;



public class post_register {

    public static void main(String[] args) {

        String jsonString = "{\"username\":\"crio-users2214\",\"password\":\"password12\"}";

        RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net";

        RestAssured.basePath = "/api/v1/auth/register";

        RequestSpecification http = RestAssured.given();
        http.contentType(ContentType.JSON);
        http.body(jsonString);

        Response response = http.request(Method.POST);

        int responseStatusCode = response.getStatusCode();

        if (responseStatusCode == 201) {
            System.out.println("The API call was successful");
        } else {
            System.out.println("The API call Failed");
        }

    }
}

