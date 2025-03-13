package com.web.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageLocator {
    @FindBy(xpath = "//span[contains(text(),'Create New Customer Account')]")
    public WebElement header_CreateNewCustAcc;

    @FindBy(id = "firstname")
    public WebElement textbox_FirstName;

    @FindBy(id = "lastname")
    public WebElement textbox_LastName;

    @FindBy(id = "email_address")
    public WebElement textbox_EmailAddress;

    @FindBy(id = "password")
    public WebElement textbox_Password;

    @FindBy(id = "password-confirmation")
    public WebElement textbox_PasswordConfirmation;

    @FindBy(xpath = "//button[@title='Create an Account']")
    public WebElement button_CreateAnAccount;

    @FindBy(xpath = "//div[@class='box-content']/p")
    public WebElement content_ContactInformation;

}
