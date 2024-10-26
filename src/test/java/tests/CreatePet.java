package tests;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.requests.CategoryRequest;
import pojos.requests.People;
import pojos.requests.PetRequest;
import pojos.requests.TagsRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class CreatePet {

    @Test
    public void createPetExampleWithString() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"browsers\":{\"firefox\":{\"name\":\"Firefox\",\"pref_url\":\"about:config\",\"releases\":{\"1\":{\"release_date\":\"2004-11-09\",\"status\":\"retired\",\"engine\":\"Gecko\",\"engine_version\":\"1.7\"}}}}}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        System.out.println(response.prettyPrint());
    }

    @Test
    public void createPetExampleWithMultiplParam() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("accept", "application/json");
        headerMap.put("Content-Type", "application/json");

        Response response = given().log().all()
                .headers(headerMap)
                .body("{\"browsers\":{\"firefox\":{\"name\":\"Firefox\",\"pref_url\":\"about:config\",\"releases\":{\"1\":{\"release_date\":\"2004-11-09\",\"status\":\"retired\",\"engine\":\"Gecko\",\"engine_version\":\"1.7\"}}}}}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        System.out.println(response.prettyPrint());
    }


    @Test
    public void fetchResponseHeaders() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("accept", "application/json");
        headerMap.put("Content-Type", "application/json");

        Response response = given()
                .headers(headerMap)
                .body("{\"browsers\":{\"firefox\":{\"name\":\"Firefox\",\"pref_url\":\"about:config\",\"releases\":{\"1\":{\"release_date\":\"2004-11-09\",\"status\":\"retired\",\"engine\":\"Gecko\",\"engine_version\":\"1.7\"}}}}}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        System.out.println(response.prettyPrint());

        Headers headers = response.headers();

        for (Header header : headers) {
            System.out.println(header.getName() + " " + header.getValue());
        }

        //find specific header
        System.out.println("***search server name****");
        for (Header header : headers) {
            if (header.getName().equalsIgnoreCase("Server")) {
                System.out.println("server name is " + header.getValue());
            }
        }
    }

    @Test
    public void createPetExamplePOJO() {

        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setId(43245);
        categoryRequest.setName("Cat");

        TagsRequest tagsRequest = new TagsRequest();
        tagsRequest.setId(787);
        tagsRequest.setName("tag Name");
        List<TagsRequest> listoftag = new ArrayList<>();
        listoftag.add(tagsRequest);

        List<String> photoULR = new ArrayList();
        photoULR.add("http://photolink");

        PetRequest petRequest = new PetRequest();
        petRequest.setId(89798798);
        petRequest.setCategory(categoryRequest);
        petRequest.setName("PANDA");
        petRequest.setPhotoUrls(photoULR);
        petRequest.setTags(listoftag);
        petRequest.setStatus("AVAilable");


        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .body(petRequest)
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        System.out.println(response.prettyPrint());


    }


    @Test
    public void test() {
        People people = new People();
        people.setName("abc");
        people.setAge(234);
        people.setEmail("test@gmail.com");


        List<People> peopls = new ArrayList<>();
        peopls.add(people);

        List<String> status = new ArrayList<>();
        status.add("sdsdhfkj");


    }


//fetch bearer token  - first post request response header , token , post -basic ,
//    token in response


//    get , send token ereceived in

    //response of get , multiple header , one header should have a key called server


    @Test
    public void test2() {
        Response responseToken = given()
                .auth().basic("username", "password")
                .when().post("http://generate token");


        String token = responseToken.body().path("data.token");


        Response responseheader  = given()
                .header("Authorization" , token)
                .when().get("something");


      Headers allHeaders =   responseheader.headers();
      allHeaders.size();


      for(Header header : allHeaders){
            if(header.getName().equalsIgnoreCase("server")){
                System.out.println(header.getValue());
                break;
            }
            else{
                System.out.println("server header not found");
//                logger.warn("Header")
            }
      }


    }
}
