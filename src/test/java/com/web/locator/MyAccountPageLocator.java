package com.web.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageLocator {
    @FindBy(xpath = "//div[@class='box-content']/p")
    public WebElement content_ContactInformation;

}
