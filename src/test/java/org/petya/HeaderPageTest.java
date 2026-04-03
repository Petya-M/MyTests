package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class HeaderPageTest extends BaseTest {

    File postPicture = new File("src/test/resources/upload/snimka1.jpeg");
    String messageText = "Post created!";


    @Test(priority = 3)
    public void createOneNewPost() {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        BasePage basePage = new BasePage(driver);

        basePage.navigateToBasePage();
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-login")));
        loginLink.click();
        loginPage.login("petyamar", "159753");
        loginPage.clickSignInButton();
        headerPage.clickOnNewPost();
        headerPage.selectPostField();
        headerPage.uploadPicture(postPicture);
        headerPage.enterPostText("My new post!");
        headerPage.clickCreatePostButton();
        //waitForElementVisible(By.cssSelector("#toast-container"), 5);

        Assert.assertEquals(messageText, "Post created!");

    }

    @Test
    public void clickDislikeButton(){

            BasePage basePage = new BasePage(driver);
            HeaderPage headerPage = new HeaderPage(driver);

            basePage.navigateToBasePage();

            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-login")));
            loginLink.click();

            WebElement usernameField = driver.findElement(By.id("defaultRegisterFormUserName"));
            WebElement passwordField = driver.findElement(By.id("defaultRegisterFormPassword"));
            WebElement signInButton = driver.findElement(By.id("sign-in-button"));

            usernameField.sendKeys("petyamar");
            passwordField.sendKeys("159753");
            signInButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("app-post-detail")));
            List<WebElement> dislikeButtons = driver.findElements(By.cssSelector(".fa-thumbs-down"));
            headerPage.clickDislikeButton();

            Assert.assertEquals(dislikeButtons.get(0).getText(),"1 dislikes");


    }
}
