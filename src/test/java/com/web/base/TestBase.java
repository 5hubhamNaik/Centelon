package com.web.base;

import com.main.driver.DriverManager;
import com.web.actions.*;
import org.openqa.selenium.support.PageFactory;

public class TestBase {

    LandingPageAction loginPageAction;

    public TestBase() {
        loginPageAction = new LandingPageAction();

        PageFactory.initElements(DriverManager.getDriver(), loginPageAction);

    }
}
