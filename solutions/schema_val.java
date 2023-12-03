import java.io.File;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;


public class schema_val {
    @Test
    public void validateJSONSchema(){


        RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net/api/v1/products";

        RequestSpecification http = RestAssured.given();
        Response response = http.request(Method.GET);

        response.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(new File("locationOfJsonschema.json")));

    }
}

