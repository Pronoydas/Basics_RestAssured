import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class post_all {

   //Creating static register method with int return type
   static int register() {

   //save the JSON values to be sent  in the String object
       String jsonString = "{\"username\":\"crio-users125\",\"password\":\"password12\"}";
      
       RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net";

       RestAssured.basePath = "/api/v1/auth/register";

       RequestSpecification http = RestAssured.given();
       http.contentType(ContentType.JSON);
       http.body(jsonString);

       Response response = http.request(Method.POST);

       int responseStatusCode = response.getStatusCode();
      
       //returning status code to verify if call was succcessful
       return responseStatusCode;
   }

   //Creating Login method with string return type to fetch and return token details
   static String login() {


       String jsonString = "{\"username\":\"crio-users125\",\"password\":\"password12\"}";

       RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net";

       RestAssured.basePath = "/api/v1/auth/login";

       RequestSpecification http = RestAssured.given();
       http.contentType(ContentType.JSON);
       http.body(jsonString);

       Response response = http.request(Method.POST);

       String responseBody = response.getBody().asString();
       JsonPath jsonPath = new JsonPath(responseBody);
       String token = jsonPath.getString("token");

      
       return token;
   }

   //creating auth method to trigger POST address API
   static void auth(String token) {
       String jsonString = "{\"address\":\"My new address - excited about moving in\"}";

       RestAssured.baseURI = "https://content-qkart-qa-backend.azurewebsites.net";

       RestAssured.basePath = "/api/v1/user/addresses";

       //Here we are sending token details has bearer Token which is fetched from login response
       RequestSpecification http = RestAssured.given();
       http.contentType(ContentType.JSON);
       http.body(jsonString);
       http.header("Authorization", "Bearer " + token);

       Response response = http.request(Method.POST);

       int responseStatusCode = response.getStatusCode();
       if (responseStatusCode == 200) {
           System.out.println("The API call was successful");
       } else {
           System.out.println("The API call Failed");
       }

       String responseBody = response.getBody().asString();
       System.out.println(responseBody);

   }


   public static void main(String[] args) {

       //Call register method and assign status code to responseStatus
       int responseStatus = register();

       //if status code is 200 call login method
       if (responseStatus == 201) {

           String token = null;
           token = login();


           //if token details is not null call auth method with token as argument
           if (token != null) {
               auth(token);
           }

       } else {
           System.out.println("fail");
       }

   }

}

