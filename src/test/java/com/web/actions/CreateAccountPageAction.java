package com.web.actions;

import com.main.driver.DriverManager;
import com.main.executiondata.AppData;
import com.web.locator.CreateAccountPageLocator;
import com.web.locator.LandingPageLocator;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

@Log4j2
public class CreateAccountPageAction extends BaseAction {
    LandingPageLocator landingPageLocator;
    CreateAccountPageLocator createAccountPageLocator;

    public CreateAccountPageAction() {
        landingPageLocator = new LandingPageLocator();
        createAccountPageLocator = new CreateAccountPageLocator();

        PageFactory.initElements(DriverManager.getDriver(), landingPageLocator);
        PageFactory.initElements(DriverManager.getDriver(), createAccountPageLocator);
    }


    public void createNewCustomerAccount(String firstName, String lastName, String emailAddress, String password, String confirmPassword) {
        waitAndEnterText(createAccountPageLocator.textbox_FirstName, firstName, "Firstname textbox");
        waitAndEnterText(createAccountPageLocator.textbox_LastName, lastName, "Lastname textbox");

        waitAndEnterText(createAccountPageLocator.textbox_EmailAddress, emailAddress, "Email Address textbox");
        waitAndEnterText(createAccountPageLocator.textbox_Password, password, "Password textbox");
        waitAndEnterText(createAccountPageLocator.textbox_PasswordConfirmation, confirmPassword, "Confirm password textbox");

        waitAndClick(createAccountPageLocator.button_CreateAnAccount, "Create an account button");
    }
}
