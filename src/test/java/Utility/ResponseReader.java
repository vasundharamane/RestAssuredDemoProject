package Utility;

import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseReader {

    public static Object retrieveData(Response response , String type, String path){
        switch (type.toUpperCase()){
            case "BOOLEAN" :
                return  response.jsonPath().getBoolean(path);
            default :
                throw new IllegalArgumentException("Invalid parameter type is passed : " + type);
        }
    }
}
