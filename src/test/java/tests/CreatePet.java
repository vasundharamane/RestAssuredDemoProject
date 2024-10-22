package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.requests.CategoryRequest;

public class CreatePet {

    @Test
    public void createPetExampleWithString() {
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body("{\"browsers\":{\"firefox\":{\"name\":\"Firefox\",\"pref_url\":\"about:config\",\"releases\":{\"1\":{\"release_date\":\"2004-11-09\",\"status\":\"retired\",\"engine\":\"Gecko\",\"engine_version\":\"1.7\"}}}}}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        System.out.println(response.prettyPrint());
    }




    @Test
    public void createPetExamplePOJO() {

        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setId(43245);
        categoryRequest.setName("Panda");


        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body("{\"browsers\":{\"firefox\":{\"name\":\"Firefox\",\"pref_url\":\"about:config\",\"releases\":{\"1\":{\"release_date\":\"2004-11-09\",\"status\":\"retired\",\"engine\":\"Gecko\",\"engine_version\":\"1.7\"}}}}}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        System.out.println(response.prettyPrint());

    }


}
