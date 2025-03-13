package com.web.actions;

import com.main.driver.DriverManager;
import com.main.executiondata.AppData;
import com.web.locator.CreateAccountPageLocator;
import com.web.locator.LandingPageLocator;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

@Log4j2
public class LandingPageAction extends BaseAction {
    LandingPageLocator landingPageLocator;
    CreateAccountPageLocator createAccountPageLocator;

    public LandingPageAction() {
        landingPageLocator = new LandingPageLocator();
        createAccountPageLocator = new CreateAccountPageLocator();
        PageFactory.initElements(DriverManager.getDriver(), landingPageLocator);
        PageFactory.initElements(DriverManager.getDriver(), createAccountPageLocator);
    }

    public void openLandingPage() {
        String updatedAppURL = AppData.APP_URL.getUrl();
        DriverManager.getDriver().get(updatedAppURL);
        Assert.assertTrue((landingPageLocator.logo_Luma).isDisplayed(), "LUMA logo displayed");
    }

    public void navigateToCreateAccount() {
        waitAndClick(landingPageLocator.option_SignIn, "Sign In option");
        waitAndClick(landingPageLocator.option_CreateAnAccount, "Create an account option");
        waitAndClick(createAccountPageLocator.header_CreateNewCustAcc, "Create New Customer Account header");
    }

}
