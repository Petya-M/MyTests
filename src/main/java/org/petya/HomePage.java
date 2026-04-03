package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final String homePageUrl = "/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageLoaded() {
        waitForUrl(getExpectedUrl(homePageUrl));
    }

    public String getPageExpectedUrl() {
        return super.getExpectedUrl(homePageUrl);
    }

    public boolean isUrlLoaded() {
        verifyPageLoaded();
        return getActualCurrentUrl().equals(getPageExpectedUrl());
    }

    public void navigateToPage(String homePageUrl) {
        navigateToPage(this.homePageUrl);
    }

    public String getPostAuthorByIndex(int index) {
        By postAuthorLocator = By.xpath("(//div[contains(@class, 'post-list-container')]//app-post-detail//a[contains(@class, 'post-user')])[" + index + "]");
        return waitAndVisible(postAuthorLocator).getText();
    }

}
