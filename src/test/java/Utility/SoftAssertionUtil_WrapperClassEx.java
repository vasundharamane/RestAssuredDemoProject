package Utility;

import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class SoftAssertionUtil_WrapperClassEx {

    private SoftAssert softAssert;

    public SoftAssertionUtil_WrapperClassEx() {
        this.softAssert = new SoftAssert();
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
