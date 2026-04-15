package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class HeaderPage extends BasePage {

    private final By profilePageHeader = By.cssSelector("#nav-link-profile");
    private final By newPostHeader = By.cssSelector("#nav-link-new-post");
    private final By inputPostField = By.cssSelector(".file.ng-untouched");
    private final By clickCreatePost = By.cssSelector("#create-post");
    private final By postTextField = By.cssSelector("input.mb-4");
    private final By dislikeButton = By.xpath("(//app-post-detail)[1]//i[contains(@class,'fa-thumbs-down')]");

    /**
     * Clicks on the profile section in the header.
     */
    public HeaderPage(WebDriver driver) {
        super(driver); // Calls the BasePage constructor
    }

    /**
     * Clicks the button to create a new post.
     */
    public void clickOnHeaderProfile() {
        click(profilePageHeader);
    }

    /**
     * Clicks the button to create a new post.
     */
    public void clickOnNewPost() {
        click(newPostHeader);
    }

    /**
     * Clicks the button to submit a new post.
     */
    public void clickCreatePostButton() {
        click(clickCreatePost);
    }

    /**
     * Enters text into the post field.
     * @param postText the content of the post
     */
    public void enterPostText(String postText) {
        typeText(postTextField, postText);
    }

    /**
     * Clicks the dislike button on a post.
     */
    public void clickDislikeButton() {
        click(dislikeButton);
    }

    /**
     * Returns the number of posts for the current user.
     * @return the posts count as integer
     */
    public int getPostsCount() {
        String text = waitAndVisible(By.cssSelector("ul li:first-child strong.profile-stat-count")).getText();
        return Integer.parseInt(text);
    }

}
