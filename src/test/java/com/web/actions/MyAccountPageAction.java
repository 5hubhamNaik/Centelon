package com.web.actions;

import com.main.driver.DriverManager;
import com.web.locator.MyAccountPageLocator;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

@Log4j2
public class MyAccountPageAction extends BaseAction {
    MyAccountPageLocator myAccountPageLocator;

    public MyAccountPageAction() {
        myAccountPageLocator = new MyAccountPageLocator();
        PageFactory.initElements(DriverManager.getDriver(), myAccountPageLocator);
    }

    public void verifyContactInformation(String firstName, String lastName, String emailAddress) {
        String content = myAccountPageLocator.content_ContactInformation.getText();

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
