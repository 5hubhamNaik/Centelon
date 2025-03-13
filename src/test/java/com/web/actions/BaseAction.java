package com.web.actions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.main.driver.DriverManager;
import com.main.executiondata.GlobalData;
import com.web.listeners.ExtentListeners;
import com.web.listeners.ExtentManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public abstract class BaseAction {

    protected void waitAndClick(WebElement element, String elementName) {
        waitForElementToBeClickable(element);
        try {
            element.click();
            logInfo("Clicking on : " + elementName);
        } catch (Exception e) {
            logError("Can't Click on : " + elementName);
        }
    }


    protected void waitAndEnterText(WebElement element, String value, String elementName) {
        waitForElementToDisplay(element, elementName);
        element.sendKeys(value);
        logInfo("Typing in : " + elementName + " entered the value as : " + value);
    }


    protected WebElement waitForElementToDisplay(WebElement element, String elementName) {
        WebElement webElement = null;
        try {
            Wait<WebDriver> waitOnElement = new FluentWait<WebDriver>(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
            webElement = waitOnElement.until(ExpectedConditions.visibilityOf(element));
            logInfo("Element Loaded: " + elementName);
        } catch (Exception e) {
            //logError("Element not loaded: "+ elementName);
        }
        return webElement;
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        return new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    protected static void logInfo(String message) {
        ExtentListeners.testReport.get().info(message);
        ExtentManager.captureScreenshot();
        if (!GlobalData.CAPTURE_SCREENSHOTS_FOR_FAIL_ONLY) {
            try {
                ExtentListeners.testReport.get().info(
                        "<b>" + "<font color=" + "blue>" + "Screenshot" + "</font>" + "</b>",
                        MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected static void logError(String message) {
        ExtentListeners.testReport.get().log(Status.FAIL, message);
        ExtentManager.captureScreenshot();
        try {
            ExtentListeners.testReport.get().fail(
                    "<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
        } catch (Exception e) {
            ExtentListeners.testReport.get().info("!Unable to Capture Screen Shot!");
        }
        ExtentListeners.overAllFailure = true;
    }

}
