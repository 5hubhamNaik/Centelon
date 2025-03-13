package com.web.tests;

import com.web.actions.*;
import com.main.driver.DriverManager;
import com.main.executiondata.AppData;
import com.main.executiondata.GlobalData;
import com.web.listeners.ExtentListeners;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.InputStream;
import java.util.Properties;


@Log4j2
@Listeners({ExtentListeners.class})

public abstract class BaseTest {

    LandingPageAction landingPageAction;

    @BeforeTest(alwaysRun = true)
    public void setupObjects() {
        landingPageAction = new LandingPageAction();
    }

    @BeforeTest(alwaysRun = true)
    public static void setup() {
        //load properties
        String activeProfile = System.getProperty("env", "qa");
        log.info("Active profile: " + activeProfile);
        Properties properties = new Properties();
        log.info("Loading properties from property file");

        log.info("Resource URI:" + BaseTest.class.getClassLoader().getResource("config.properties"));

        try (InputStream resourceStream = BaseTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (resourceStream == null) {
                throw new RuntimeException("Resource not found: " + "config.properties");
            }
            properties.load(resourceStream);
            log.info("Properties loaded: " + properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AppData.APP_URL.setUrl(properties.getProperty("app_url"));
        log.info("Setting AppData done");
    }

    @BeforeTest(alwaysRun = true)
    public static void setupDriver() {
        log.info("Setting up driver");
        DriverManager.setDriver(GlobalData.EXECUTION_BROWSER);
        log.info("Driver setup done");
    }

    @AfterSuite()
    public static void tearDown() {
        DriverManager.quitDriver();
        log.info("Quit Driver done");
    }

    protected void waitforSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
