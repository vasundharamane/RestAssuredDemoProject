package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;

public class RetryListener implements ITestListener {
    private int retryCount = 0;
    private static final int maxRetryCount = 1;


    @Override
    public void onTestFailure(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println(result.getName());
            //re run failed test case

            TestNG testNG = new TestNG();
            testNG.setTestClasses(new Class[]{result.getTestClass().getRealClass()});
            testNG.run();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        retryCount = 0;
    }
}
