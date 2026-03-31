package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final String baseUrl = "http://training.skillo-bg.com:4200";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public BasePage() {
    }

    protected String getExpectedUrl() {
        return baseUrl + "/posts/all";
    }

    public String getActualCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void waitForUrl(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    protected WebElement waitAndClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitAndVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitAndClickable(locator).click();
    }

    protected void navigateTo() {
        driver.get(baseUrl + "/users/login");
    }

    protected void typeText(By locator, String text) {
        waitAndVisible(locator).clear();
        waitAndVisible(locator).sendKeys(text);
    }
}
