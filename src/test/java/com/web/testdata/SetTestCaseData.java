package com.web.testdata;

public class SetTestCaseData {

    public static TestCaseData CentelonTest() {
        TestCaseData testCaseData = new TestCaseData();
        testCaseData.setFirstName("Shubham");
        testCaseData.setLastName("Naik");
        testCaseData.setEmailAddress("sn.shubhamnaik4@gmail.com");
        testCaseData.setPassword("Centelon@1203");
        testCaseData.setConfirmPassword("Centelon@1203");
        return testCaseData;
    }
}
