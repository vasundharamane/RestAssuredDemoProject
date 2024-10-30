package tests;

import Utility.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import pojos.requests.SimpleJsonExample;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReqResTests {

    @Test
    public void testGetNHamcrest() {
        Response response = given()
                .queryParam("page", 2)
                .pathParam("userspath", "users")
                .when()
                .get("https://reqres.in/api/{userspath}")
                .then()
                .statusCode(StatusCodes.SUCCESS.statusCode)
                .body("data", notNullValue())
                .body("page", equalTo(2))
                .body(containsString("tobias.funke@reqres.in"))
                .body("data.id", hasItems(8, 9))
                .body("data", hasSize(6))
                .extract().response();


        assertThat(response.body().jsonPath().getInt("page"), equalTo(2));

        List<String> list = new ArrayList<String>();
        list.add("tobias.funke@reqres.in");

        assertThat(response.body().jsonPath().getList("data.email"), hasItems(list.toArray(new String[0])));

        assertThat(response.body().jsonPath().get("data"), hasSize(6));
    }


    @Test
    public void schemaValidationExample() {

        SimpleJsonExample simpleJsonExample = new SimpleJsonExample();
        simpleJsonExample.setJob("leader");
        simpleJsonExample.setName("morpheus");

        Map<String, String> reqHeaders = new HashMap<>();
        reqHeaders.put("content-type", "application/json");
        reqHeaders.put("authorization", "Bearer hfgduvlsidfvs.jsdgkufslidfhsvd.rfuydsulbdvshjfdhsfdsa");

        Response response = given().log().all()
                .headers(reqHeaders)
//                .header("content-type", "application/json")
//                .header("authorization", "Bearer hfgduvlsidfvs.jsdgkufslidfhsvd.rfuydsulbdvshjfdhsfdsa")

                .body(simpleJsonExample)
                .when()
                .post("https://reqres.in/api/users");

        response.then().body(matchesJsonSchema(new File("src/test/resources/schema/userResponse.json")));


    }

    @Test
    public void jsonDataUse() {
        Response response = given()
                .auth()
                .basic(JSONReader.getTestData("username"), JSONReader.getTestData("password"))
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then().log().all().extract().response();
    }

    @Test
    public void requestBuilderPatternExample() {
        Response response = given().log().all()
//                .baseUri("https://reqres.in/api")
                .spec(requestSpec())
                .pathParam("user", "users")
                .queryParam("page", 2)
                .when()
                .get("/{user}")
                .then()
                .statusCode(200)
                .extract().response();

    }

    public RequestSpecification requestSpec() {
        return new RequestSpecBuilder().addHeader("authorization", "bearer eyihjhjgkijlkfjhlidjoajskln.hiukjghfjlkh")
                .setBaseUri("https://reqres.in/api").build();
    }

    @Test
    public void responseBulderPatternExample() {
        Response response = given().log().all()
//                .baseUri("https://reqres.in/api")
                .spec(requestSpec())
                .pathParam("user", "users")
                .queryParam("page", 2)
                .when()
                .get("/{user}")
                .then().log().all()
                .spec(responseSpec())
                .extract().response();

    }

    public ResponseSpecification responseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectHeader("Server", "cloudflare")
                .build();
    }

    @Test
    public void wrapperClassUse() {

        SoftAssertionUtil_WrapperClassEx softAssertionUtilWrapperClassEx = new SoftAssertionUtil_WrapperClassEx();

        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");

        System.out.println(response.prettyPrint());

        softAssertionUtilWrapperClassEx.assertStatusCode(response, 200);
        softAssertionUtilWrapperClassEx.assertAll();
    }


    @Test
    public void singleToneInstance() {


        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");

        System.out.println(response.prettyPrint());

        SingletoneExample.getInstance().assertStatusCode(response, 200);
        SingletoneExample.getInstance().assertAll();

    }


    @Test(dataProvider = "testData", dataProviderClass = DataProviderClass.class)
    public void testDataproviderEx(String name, int id) {
        System.out.println("name:  " + name + " id:  " + id);
    }


}