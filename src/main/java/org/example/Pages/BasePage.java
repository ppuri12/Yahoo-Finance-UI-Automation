package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage {
    WebDriver webDriver;
    public static final Logger logger = Logger.getLogger(BasePage.class.getName());

    BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goTo(String url) {
        logger.info("inside goTo - opening URL - " + url);
        webDriver.get(url);
    }

    public static void waitForElementVisible(WebDriver driver, WebElement locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }


}
