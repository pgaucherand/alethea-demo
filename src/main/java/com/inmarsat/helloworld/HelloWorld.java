package com.inmarsat.helloworld;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {

    /**
     * The Chrome path property name.
     */
    static final String CHROME_DRIVER_PATH_PROPERTY = "webdriver.chrome.driver";

    /**
     * The Gecko path property name.
     */
    static final String GECKO_DRIVER_PATH_PROPERTY = "webdriver.gecko.driver";

    private static String CHROME_PATH = "/usr/local/bin/chromedriver";

    private static String FIREFOX_PATH = "/usr/local/bin/geckodriver";

    public static void main(String[] args) {

        // Verify webdriver creation for driver paths on the Alethea system
        System.setProperty(CHROME_DRIVER_PATH_PROPERTY, CHROME_PATH);
        System.setProperty(GECKO_DRIVER_PATH_PROPERTY, FIREFOX_PATH);

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://google.com");
        chromeDriver.quit();

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("http://google.com");
        firefoxDriver.quit();

        // use a Java 11 feature to verify setup
        List<String> sampleList = Arrays.asList("The", "setup", "works", "with", "Java11");
        String resultString = sampleList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));

        System.out.println(resultString);

    }
}
