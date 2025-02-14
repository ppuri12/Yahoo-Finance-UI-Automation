package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

    public static WebDriver createDriverInstance() {
        WebDriver webDriver;
        webDriver = createLocalWebDriver();
        return webDriver;
    }

    private static WebDriver createLocalWebDriver() {
        WebDriver localWebDriver;
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER);
        localWebDriver = new ChromeDriver(options);
        localWebDriver.manage().window().maximize();
        return localWebDriver;
    }

}
