import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class get_query {


    public static void main(String[] args) {

        RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net";

        RestAssured.basePath = "/api/v1/products/search";

        RequestSpecification http=RestAssured.given().queryParam("value","book");

        Response  response=http.request(Method.GET);

        int responseStatusCode = response.getStatusCode();

        if (responseStatusCode == 200) {
            System.out.println("The API call was successful");
        } else {
            System.out.println("The API call Failed");
        }

    }
}

