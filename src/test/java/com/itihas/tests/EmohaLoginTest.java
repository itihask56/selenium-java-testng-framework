
package com.itihas.tests;

import com.itihas.base.BaseTest;
import com.itihas.pages.EmohaLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.itihas.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class EmohaLoginTest extends BaseTest {
    private static final Logger log = LoggerUtil.getLogger(EmohaLoginTest.class);

    @Test
    public void loginToEmohaCrm() {

        log.info("========== EMOHA LOGIN TEST STARTED ==========");
        String username = System.getenv("EMOHA_UI_USERNAME");
        String password = System.getenv("EMOHA_UI_PASSWORD");
        String mobile = System.getenv("EMOHA_UI_MOBILE");
        String otp = System.getenv("EMOHA_UI_OTP");
        log.info("Username configured: {}", username != null);
        log.info("Password configured: {}", password != null);
        log.info("Mobile configured: {}", mobile != null);
        log.info("OTP configured: {}", otp != null);




        Assert.assertNotNull(username, "Username environment variable is missing");
        Assert.assertNotNull(password, "Password environment variable is missing");
        Assert.assertNotNull(mobile, "Mobile environment variable is missing");
        Assert.assertNotNull(otp, "OTP environment variable is missing");

        EmohaLoginPage loginPage = new EmohaLoginPage(driver);

        // Step 1: Submit login credentials
        loginPage.login(username, password);

        // Step 2: Complete mobile verification
        loginPage.verifyMobile(mobile, otp);

        // Step 3: Verify successful login
        Assert.assertTrue(
                loginPage.isDashboardDisplayed(),
                "Emoha CRM dashboard was not displayed after login"
        );
        log.info("========== EMOHA LOGIN TEST PASSED ==========");
    }
}
