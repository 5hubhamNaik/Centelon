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
            TestCaseData testData = SetTestCaseData.Test();
            landingPageAction.openLandingPage();
            landingPageAction.navigateToCreateAccount();
            waitforSeconds(5);
            landingPageAction.createNewCustomerAccount(testData.getFirstName(), testData.getLastName(), testData.getEmailAddress(), testData.getPassword(), testData.getConfirmPassword());
            landingPageAction.verifyContactInformation(testData.getFirstName(), testData.getLastName(), testData.getEmailAddress());

        }
    }

}
