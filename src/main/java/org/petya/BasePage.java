package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final By inputFileElement = By.cssSelector("input.file[type='file']");
    protected static final String baseUrl = "http://training.skillo-bg.com:4200";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected String getExpectedUrl(String urlSuffix) {
        return baseUrl + urlSuffix;
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

    protected WebElement waitPresentInDom(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitAndClickable(locator).click();
    }

    protected void navigateTo() {
        driver.get(baseUrl + "http://training.skillo-bg.com:4200/posts/all");
    }

    public void navigateToBasePage() {
        driver.navigate().to(baseUrl);
    }

    protected void typeText(By locator, String text) {
        waitAndVisible(locator).clear();
        waitAndVisible(locator).sendKeys(text);
    }

    protected int getElementsCount(By locator) {
        waitAndVisible(locator);
        return driver.findElements(locator).size();
    }

    public void uploadPicture(File file) {
        waitPresentInDom(inputFileElement).sendKeys(file.getAbsolutePath());
    }

    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            System.out.println("Element: " + locator + "NOT FOUND!");
            return false;
        }
    }

}
