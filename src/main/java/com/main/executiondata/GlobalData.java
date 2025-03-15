package com.main.executiondata;

import com.main.enums.Browser;

public class GlobalData {
    public static String EXECUTION_BROWSER_CHROME = System.getProperty("browser", Browser.CHROME.name());
    public static String EXECUTION_BROWSER_FIREFOX = System.getProperty("browser", Browser.FIREFOX.name());

    public static boolean CAPTURE_SCREENSHOTS_FOR_FAIL_ONLY = Boolean.parseBoolean(System.getProperty("capture_screenshots", "true"));

}
