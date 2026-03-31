package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class HeaderPage extends BasePage {

    private final By homePageHeaderLink = By.cssSelector("#nav-link-home");
    private final By profilePageHeader = By.cssSelector("#nav-link-profile");
    private final By newPostHeader = By.cssSelector("#nav-link-new-post");
    private final By inputPostField = By.cssSelector("input.input-lg");
    private final By clickCreatePost = By.cssSelector("#create-post");
    private final By postTextField = By.cssSelector("input.mb-4");
    private final By createdPostToastMessage = By.cssSelector("#toast-container");

    public void uploadPicture(File file) {
        waitPresentInDom(inputPostField).sendKeys(file.getAbsolutePath());
    }

    protected WebElement waitPresentInDom(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public HeaderPage(WebDriver driver) {
        super(driver); // Calls the BasePage constructor
    }

    public void clickOnHeaderProfile() {
        click(profilePageHeader);
    }

    public void clickOnNewPost() {
        click(newPostHeader);
    }

    public void selectPostField() {
        click(inputPostField);
    }

    public void clickCreatePostButton() {
        click(clickCreatePost);
    }

    public void enterPostText(String postText) {
        typeText(postTextField, postText);
    }

    //public boolean validateToastMessageAppearance(String message) {
       // return waitForElementToBeVisible(String.format(toastMessage, message));
    //}

}
