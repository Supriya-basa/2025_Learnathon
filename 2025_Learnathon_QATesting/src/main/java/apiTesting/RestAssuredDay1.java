package apiTesting;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDay1 {

   /* given() - content type, set cookies, add auth, add parameters, set headers

     when() - get, post, put, delete

     then() - validate status code, extract response, extract headers, extract cookies, extract response body
    */

    @Test(priority = 1)
    void getUser() {
        given()
                .when().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
    }

    @Test(priority = 2)
    void getUsers() {
        given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200)
                .body("page", equalTo(2)).log().all();
    }

    @Test
    void createUser() {
        HashMap data = new HashMap();
        data.put("name", "Supriya");
        data.put("job", "QA Automation Tester");

        given()
                .contentType("application/json")
                .body(data).

                when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

    }





}
