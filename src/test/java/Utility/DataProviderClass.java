package Utility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "testData")
    public static Object[][] dataProviderMethod() {
        return new Object[][]{
                {"name1", 34},
                {"name2", 35},
                {"name3", 36}
        };
    }
}
