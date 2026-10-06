# WaitUtils Execution Flow

## Objective

Understand how the framework handles explicit waits when entering text into an enabled input field.

## Execution sequence

1. **EmohaLoginPage**
   - Calls `typeWhenEnabled(locator, text)`.
   - Defines the application-specific action, such as entering the OTP.

2. **BasePage**
   - Receives the locator and text.
   - Calls `waitUtils.waitForClickable(locator)`.
   - Clears the input and enters the supplied text.

3. **WaitUtils**
   - Uses the existing `WebDriverWait`.
   - Waits up to 10 seconds for the element to become clickable.
   - Returns the `WebElement` when the condition is satisfied.

## Screenshot

![WaitUtils execution flow](../screenshots/wait_utils_flow.png)

## Key takeaway

Waiting logic is centralized in `WaitUtils`, reusable browser interactions live in `BasePage`, and application-specific actions live in `EmohaLoginPage`.

This separation makes the framework easier to understand, maintain, and extend.