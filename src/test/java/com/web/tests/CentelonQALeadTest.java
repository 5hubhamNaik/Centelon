package com.web.tests;

import com.web.testdata.SetTestCaseData;
import com.web.testdata.TestCaseData;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class CentelonQALeadTest extends BaseTest {
    @Test()
    public void CentelonTest() {
        {
            TestCaseData testData = SetTestCaseData.CentelonTest();
            landingPageAction.openLandingPage();
            landingPageAction.navigateToCreateAccount();
            createAccountPageAction.createNewCustomerAccount(testData.getFirstName(), testData.getLastName(), testData.getEmailAddress(), testData.getPassword(), testData.getConfirmPassword());
            myAccountPageAction.verifyContactInformation(testData.getFirstName(), testData.getLastName(), testData.getEmailAddress());
        }
    }

}
