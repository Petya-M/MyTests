package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String homePageUrl = "/users/login";

    /**
     * Initializes the HomePage with a WebDriver instance.
     * @param driver the WebDriver used to interact with the browser
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifies that the home page is fully loaded.
     */
    public void verifyPageLoaded() {
        waitForUrl(getExpectedUrl(homePageUrl));
    }

    /**
     * Returns the expected URL of the home page.
     * @return the expected home page URL
     */
    public String getPageExpectedUrl() {
        return super.getExpectedUrl(homePageUrl);
    }

    /**
     * Checks if the current URL matches the expected one.
     * @return true if the URL is correct, false otherwise
     */
    //public boolean isUrlLoaded() {
        //verifyPageLoaded();
       // return getActualCurrentUrl().equals(getPageExpectedUrl());
   // }

    /**
     * Navigates to the home page.
     */
    public void navigateToBasePage() {
        driver.get(baseUrl);
    }

    /**
     * Returns the author name of a post at a given index.
     * @param index the index of the post
     * @return the author's name
     */
    public String getPostAuthorByIndex(int index) {
        By postAuthorLocator = By.xpath("(//div[contains(@class, 'post-list-container')]//app-post-detail//a[contains(@class, 'post-user')])[" + index + "]");
        return waitAndVisible(postAuthorLocator).getText();
    }

    /**
     * Checks if there is a post created by a specific author.
     * @param authorName the name of the author
     * @return true if such a post exists, false otherwise
     */
    public boolean hasPostByAuthorName(String authorName) {
        return isElementVisible(By.xpath("//app-post-detail//a[text()=\"" + authorName + "\"]"));
    }

}
