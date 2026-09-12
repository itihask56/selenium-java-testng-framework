package com.itihas.retry;
import com.itihas.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 0;

    private static final Logger log = LoggerUtil.getLogger(RetryAnalyzer.class);
    @Override
    public boolean retry(ITestResult result) {

        System.out.println("Retry method invoked");

        if (retryCount < MAX_RETRY_COUNT) {

            retryCount++;

            log.warn(
                    "Retrying Test: {} | Attempt {}/{}",
                    result.getName(),
                    retryCount,
                    MAX_RETRY_COUNT
            );

            return true;
        }

        return false;
    }
}