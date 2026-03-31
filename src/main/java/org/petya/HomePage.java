package org.petya;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final String homePageUrl = "/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getPageExpectedUrl() {
        return super.getExpectedUrl();
    }

    public void verifyPageLoaded() {
        waitForUrl(getExpectedUrl());
    }

    public boolean isUrlLoaded() {
        verifyPageLoaded();
        return getActualCurrentUrl().equals(getPageExpectedUrl());
    }


}
