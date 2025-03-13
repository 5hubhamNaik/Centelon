package com.web.tests;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        XmlSuite suite = new XmlSuite();
        suite.setName("RuntimeSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("RuntimeTest");

        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("com.web.tests.CentelonTest"));
        test.setXmlClasses(classes);
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);
        testng.run();
    }
}