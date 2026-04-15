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
    protected static final String baseUrl = "http://training.skillo-bg.com:4300";

    /**
     * Initializes the base page with a WebDriver instance.
     * @param driver the WebDriver used to interact with the browser
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * Returns the full expected URL by appending a suffix to the base URL.
     * @param urlSuffix the URL suffix to append
     * @return the full expected URL
     */
    protected String getExpectedUrl(String urlSuffix) {
        return baseUrl + urlSuffix;
    }

    /**
     * Retrieves the current URL from the browser.
     * @return the current browser URL
     */
    public String getActualCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Waits until the browser navigates to the specified URL.
     * @param url the expected URL
     */
    protected void waitForUrl(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    /**
     * Waits until the element is clickable and returns it.
     * @param locator the element locator
     * @return the clickable WebElement
     */
    protected WebElement waitAndClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits until the element is visible and returns it.
     * @param locator the element locator
     * @return the visible WebElement
     */
    protected WebElement waitAndVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until the element is present in the DOM.
     * @param locator the element locator
     */
    protected WebElement waitPresentInDom(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Clicks on the element identified by the locator.
     * @param locator the element locator
     */
    protected void click(By locator) {
        waitAndClickable(locator).click();
    }

    /**
     * Navigates to the base URL of the application.
     */
    public void navigateToBasePage() {
        driver.navigate().to(baseUrl);
    }

    /**
     * Enters text into the specified input field.
     * @param locator the element locator
     * @param text the text to enter
     */
    protected void typeText(By locator, String text) {
        waitAndVisible(locator).clear();
        waitAndVisible(locator).sendKeys(text);
    }

    /**
     * Returns the number of elements matching the locator.
     * @param locator the element locator
     * @return the number of found elements
     */
    protected int getElementsCount(By locator) {
        waitAndVisible(locator);
        return driver.findElements(locator).size();
    }

    /**
     * Uploads a file (image) using a file input element.
     * @param file the file to upload
     */
    public void uploadPicture(File file) {
        waitPresentInDom(inputFileElement).sendKeys(file.getAbsolutePath());
    }

    /**
     * Checks if a given element is visible on the page.
     * @param locator the element locator
     * @return true if the element is visible, false otherwise
     */
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
