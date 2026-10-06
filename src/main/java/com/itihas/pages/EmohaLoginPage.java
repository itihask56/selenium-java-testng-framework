
package com.itihas.pages;

import com.itihas.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmohaLoginPage extends BasePage {

    public EmohaLoginPage(WebDriver driver) {
        super(driver);
    }

    // Login form
    private final By usernameField =
            By.cssSelector("input[type='email']");

    private final By passwordField =
            By.cssSelector("input[type='password']");

    private final By loginButton =
            By.xpath("//button[normalize-space()='Login']");

    // Mobile verification modal
    private final By mobileNumberField =
            By.xpath("//input[contains(@placeholder,'Enter Phone')]");

    private final By sendOtpButton =
            By.xpath("//button[normalize-space()='Send OTP']");

    private final By otpField =
            By.xpath("//input[@placeholder='Enter 4-digit OTP']");

    private final By submitOtpButton =
            By.xpath("//button[normalize-space()='Submit']");

    // Dashboard verification
    private final By dashboardMenu =
            By.xpath("//*[normalize-space()='Dashboard']");

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void enterMobileNumber(String mobileNumber) {
        type(mobileNumberField, mobileNumber);
    }

    public void requestOtp() {
        click(sendOtpButton);
    }

    public void enterOtp(String otp) {
        typeWhenEnabled(otpField, otp);
    }

    public void submitOtp() {
        click(submitOtpButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void verifyMobile(String mobileNumber, String otp) {
        enterMobileNumber(mobileNumber);
        requestOtp();
        enterOtp(otp);
        submitOtp();
    }

    public boolean isDashboardDisplayed() {
        return waitUtils.waitForVisible(dashboardMenu).isDisplayed();
    }
}
