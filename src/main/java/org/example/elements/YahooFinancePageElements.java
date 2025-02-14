package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YahooFinancePageElements {
    WebDriver webDriver;

    public YahooFinancePageElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebElement searchBox() {
        WebElement searchBox = webDriver.findElement(By.xpath("//input[contains(@id,'ybar-sbq') and (@name='p')]"));
        return searchBox;
    }

    @FindBy(xpath = "//div[contains(@class,'container yf-1t')]/div[1]/span")
    public WebElement stockPrice;
    @FindBy(xpath = "//ul[contains(@class,'modules-module_list')]/li[1]//div[text()='TSLA']")
    public WebElement stock;
    @FindBy(xpath = "//ul[contains(@class,'modules-module_list')]/li/div/div/div[contains(@class,'modules-module_quoteS')]")
    public List<WebElement> autoSuggestOptions;

    public WebElement getStockInDropDown(String name) {
        WebElement stockName = webDriver.findElement(By.xpath("//ul[contains(@class,'modules-module_list')]/li[1]//div[text()='" + name + "']"));
        return stockName;
    }

    public WebElement getAdditionalInfomation(String value) {
        WebElement additionalInfo = webDriver.findElement(By.xpath("//ul[contains(@class,'yf-gn3zu3')]/li/span[text()='" + value + "']/following-sibling::span"));
        return additionalInfo;
    }

}
