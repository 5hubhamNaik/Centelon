package com.web.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPageLocator {

    @FindBy(xpath = "//a[@class='logo']")
    public WebElement logo_Luma;

    @FindBy(xpath = "(//a[contains(text(),' Sign In ')])[1]")
    public WebElement option_SignIn;

    @FindBy(xpath = "//a[@class='action create primary']")
    public WebElement option_CreateAnAccount;
}
