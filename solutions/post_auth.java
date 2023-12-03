import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class post_auth {


    public static  void main  (String[] args) {

        String jsonString = "{\"address\":\"My new address - excited about moving in\"}";

        String token= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImNyaW8tdXNlcnMyMTQiLCJpYXQiOjE2NjQyMTUyMTYsImV4cCI6MTY2NDIzNjgxNn0.AIpLK0iCVluqJPZS_WOqlAMgv519_j8e6Jmj5_2QyPI";

        RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net";

        RestAssured.basePath = "/api/v1/user/addresses";

        RequestSpecification http = RestAssured.given();
        http.contentType(ContentType.JSON);
        http.body(jsonString);
        http.header("Authorization", "Bearer " + token );

        Response response = http.request(Method.POST);

        int responseStatusCode = response.getStatusCode();
        if (responseStatusCode == 200) {
            System.out.println("The API call was successful");
        } else {
            System.out.println("The API call Failed");
        }
    }
}

