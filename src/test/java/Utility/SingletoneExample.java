package Utility;

import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class SingletoneExample {

    private SoftAssert softAssert;
    private static SingletoneExample singletoneExampleInstance;

    private SingletoneExample() {
        this.softAssert = new SoftAssert();
    }


    public static SingletoneExample getInstance() {
        if (singletoneExampleInstance == null) {
            singletoneExampleInstance = new SingletoneExample();
        }
        return singletoneExampleInstance;
    }


    //method to assert StatusCode
    public void assertStatusCode(Response response, int expectedStausCode) {
        int actualStatusCode = response.statusCode();
        softAssert.assertEquals(actualStatusCode, expectedStausCode, "Expected status code is : " + expectedStausCode + " but actually found " + actualStatusCode);
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
