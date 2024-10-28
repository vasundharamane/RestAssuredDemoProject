package tests;

import Utility.ResponseReader;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;

import static io.restassured.RestAssured.given;

public class ScenarioCoded {

//1. Post request to http://getAccessToken with basic auth , get Token

//2. get request to http://someEndpoint with token received in above step 1

// 3 validate response of step 2(Get Request), validate if multiple headers received(means get count) ,
// and one header should have a key called server

    @Test
    public void TestScenario1() {
        Response response = given()
                .auth()
                .basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth");


//        boolean authenticated = response.jsonPath().getBoolean("authenticated");
        boolean authenticated =(boolean) ResponseReader.retrieveData(response,"Boolean","authenticated");

        System.out.println("first method " + authenticated);

        
        System.out.println(response.body().path("authenticated").toString());

        //assumed that we received bearer token from above step
        String bearerToken = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

        Response headerDetailResp = given()
                .header("Authentication", bearerToken)
                .when()
                .get("https://reqres.in/api/users?page=2");

        System.out.println(headerDetailResp.headers().size());

        Headers allHeaders = headerDetailResp.headers();
        for (Header header : allHeaders) {
            System.out.println("Header name " + header.getName() + " Header value " + header.getValue());
            if (header.getName().equalsIgnoreCase("server")) {
                System.out.println(header.getValue());
                break;
            }
        }
    }
}
