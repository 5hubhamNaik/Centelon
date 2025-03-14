package com.web.testdata;

import java.util.Random;

public class SetTestCaseData {

    public static TestCaseData CentelonTest() {
        TestCaseData testCaseData = new TestCaseData();
        testCaseData.setFirstName("Shubham");
        testCaseData.setLastName("Naik");

        Random random = new Random();
        char c = (char) (random.nextInt(26) + 'A');

        testCaseData.setEmailAddress("Shubham.naik" + c + "@gmail.com");
        testCaseData.setPassword("Centelon@1203");
        testCaseData.setConfirmPassword("Centelon@1203");
        return testCaseData;
    }
}
