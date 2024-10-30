package Utility;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class JSONReader {

    //get jsonObject

    public static JSONObject getJsonData() {

        //pass the path of the testdata.json file
        File filename = new File("src/test/resources/TestData/testdata.json");
        //convert json file into string
        String json = null;
        try {
            json = FileUtils.readFileToString(filename, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //parse the string into object
        Object obj = null;
        try {
            obj = new JSONParser().parse(json);
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
        //give jsonobject o that I can return it to the function everytime it get called
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }

    public static String getTestData(String input) {
        String testdata;
        return testdata = (String) getJsonData().get(input);//input is the key

    }

}

