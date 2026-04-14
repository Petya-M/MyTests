package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class CreateNewPostTest extends BaseTest {

    File postPicture = new File("src/test/resources/upload/snimka1.jpg");
    //String messageText = "Post created!";
    //String postText = "My new post!";

    //Verifying the creation of a new post after successful login
    @Test
    public void createNewPostAfterLogin() {

        new LoginPage(driver);
        LoginPage loginPage;
        new HeaderPage(driver);
        HeaderPage headerPage;
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        loginPage.navigateToBasePage();
        loginPage.clickLoginButton();
        loginPage.login("petyamar", "159753");
        headerPage.clickOnNewPost();
        headerPage.uploadPicture(postPicture);
        headerPage.enterPostText("My new post!");
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']//div[contains(@class,'toast-message')]")));
        //Assert.assertEquals(post, "My new post!");
        headerPage.clickCreatePostButton();
        //WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']//div[contains(@class,'toast-message')]")));
        assertTrue(toast.getText().contains("Post created!"), "Post not created");
    }
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']//div[contains(@class,'toast-message') and text()='Post created!']")));
    //Assert.assertEquals(messageText, "Post created!");
}




