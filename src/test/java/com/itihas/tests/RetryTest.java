package com.itihas.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;
import com.itihas.retry.RetryAnalyzer;

public class RetryTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void retryTest() {
        System.out.println("Executing Test");
        Assert.fail("Intentional Failure");
    }

}
