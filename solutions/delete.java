import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class delete {


    public static  void main  (String[] args) {

        String token= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImNyaW8tdXNlcnNhYSIsImlhdCI6MTY2NDI5NDMwOSwiZXhwIjoxNjY0MzE1OTA5fQ.ENnbIcMzFtlx_g4FMCDcQQ4S3ib6GgEAu1EkIMsFBJU";

        RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net";

        RestAssured.basePath = "/api/v1/user/addresses/n00GeA7IcNkYuUaVLQgSp";

        RequestSpecification http = RestAssured.given();
        http.header("Authorization", "Bearer " + token );
        Response response = http.request(Method.DELETE);

        int responseStatusCode = response.getStatusCode();
        if (responseStatusCode == 200) {
            System.out.println("The API call was successful");
        } else {
            System.out.println("The API call Failed");
        }

    }
}

