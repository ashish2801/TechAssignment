package org.pingsafe.listeners;

import org.pingsafe.constants.Constants;
import org.pingsafe.utils.ConfigLoader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**Custom Logic Defined to retry the failed test cases **/
public class RetryListener implements IRetryAnalyzer {

    private int count=0;
    private int retries =2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        if (ConfigLoader.getInstance().getRetryFailedCases().equalsIgnoreCase(Constants.YES)) {
            if (count < retries) {
                try {
                    System.out.println("Waiting for 10 seconds before retrial");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Retrying the test case "+ iTestResult.getMethod().getMethodName());
                count++;
                return true;
            }
        }
        return value;
    }
}
