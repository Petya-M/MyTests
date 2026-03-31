package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class HeaderPageTest extends BasePage{

    File postPicture = new File("src/test/resources/upload/snimka1.jpeg");
    String messageText = "Post created!";



    @Test(priority = 3)
    public void createOneNewPost () {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnNewPost();
        headerPage.selectPostField();
        headerPage.uploadPicture(postPicture);
        headerPage.enterPostText("My new post!");
        headerPage.clickCreatePostButton();
        //waitForElementVisible(By.cssSelector("#toast-container"), 5);

        Assert.assertEquals(messageText, "Post created!");
        
    }
}
