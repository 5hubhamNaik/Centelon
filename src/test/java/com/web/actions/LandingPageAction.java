package com.web.actions;

import com.main.driver.DriverManager;
import com.main.executiondata.AppData;
import com.web.locator.LandingPageLocator;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

@Log4j2
public class LandingPageAction extends BaseAction {
    LandingPageLocator landingPageLocator;

    public LandingPageAction() {
        landingPageLocator = new LandingPageLocator();
        PageFactory.initElements(DriverManager.getDriver(), landingPageLocator);
    }

    public void openLandingPage() {
        String updatedAppURL = AppData.APP_URL.getUrl();
        DriverManager.getDriver().get(updatedAppURL);
        Assert.assertTrue((landingPageLocator.logo_Luma).isDisplayed(), "LUMA logo displayed");
    }

    public void navigateToCreateAccount() {
        waitAndClick(landingPageLocator.option_SignIn, "Sign In option");
        waitAndClick(landingPageLocator.option_CreateAnAccount, "Create an account option");
        waitAndClick(landingPageLocator.header_CreateNewCustAcc, "Create New Customer Account header");
    }

    public void createNewCustomerAccount(String firstName, String lastName, String emailAddress, String password, String confirmPassword) {
        waitAndEnterText(landingPageLocator.textbox_FirstName, firstName, "Firstname textbox");
        waitAndEnterText(landingPageLocator.textbox_LastName, lastName, "Lastname textbox");

        waitAndEnterText(landingPageLocator.textbox_EmailAddress, emailAddress, "Email Address textbox");
        waitAndEnterText(landingPageLocator.textbox_Password, password, "Password textbox");
        waitAndEnterText(landingPageLocator.textbox_PasswordConfirmation, confirmPassword, "Confirm password textbox");

        waitAndClick(landingPageLocator.button_CreateAnAccount, "Create an account button");
    }

    public void verifyContactInformation(String firstName, String lastName, String emailAddress) {
        String content = landingPageLocator.content_ContactInformation.getText();

        String[] lines = content.split("\n");

        String fullName = lines[0];
        String email = lines[1];

        String[] nameParts = fullName.split(" ");

        String firstname = "";
        String lastname = "";

        if (nameParts.length == 2) {
            firstname = nameParts[0];
            lastname = nameParts[1];
        } else if (nameParts.length == 1) {
            firstname = nameParts[0];
        }

        Assert.assertEquals(firstName, firstname);
        Assert.assertEquals(lastName, lastname);
        Assert.assertEquals(emailAddress, email);
    }
}
