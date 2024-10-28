package Utility;

import io.restassured.response.Response;

public class ResponseReader {

    public static Object retrieveData(Response response, String type, String path) {
        switch (type.toUpperCase()) {
            case "BOOLEAN":
                return response.jsonPath().getBoolean(path);
            default:
                throw new IllegalArgumentException("Invalid parameter type is passed : " + type);
        }
    }

    public static Object retrieveData(Response response, String path) {
        return response.body().path(path);
    }


//                System.out.println(response.body().path("authenticated").toString());


}
