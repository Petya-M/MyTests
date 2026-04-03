package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class HeaderPage extends BasePage {

    private final By homePageHeaderLink = By.cssSelector("#nav-link-home");
    private final By profilePageHeader = By.cssSelector("#nav-link-profile");
    private final By newPostHeader = By.cssSelector("#nav-link-new-post");
    private final By inputPostField = By.cssSelector("input.input-lg");
    private final By clickCreatePost = By.cssSelector("#create-post");
    private final By postTextField = By.cssSelector("input.mb-4");
    private final By createdPostToastMessage = By.cssSelector("#toast-container");
    private final By dislikeButton = By.xpath("/html/body/app-root/div[2]/app-all-posts/div/div/div[2]/app-post-detail/div/div[2]/div/div[1]/i[2]");


    protected WebElement waitPresentInDom(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public HeaderPage(WebDriver driver) {
        super(driver); // Calls the BasePage constructor
    }

    public void uploadPicture(File file) {
        waitPresentInDom(inputPostField).sendKeys(file.getAbsolutePath());
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

    public void clickDislikeButton(){
        click(dislikeButton);
    }

    //public boolean validateToastMessageAppearance(String message) {
       // return waitForElementToBeVisible(String.format(toastMessage, message));
    //}

}
