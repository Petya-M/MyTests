package org.petya;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class CreateNewPostTest extends BaseTest{

    LoginPage loginPage;
    HeaderPage headerPage;
    File postPicture = new File("src/test/resources/upload/snimka1.jpg");
    String messageText = "Post created!";

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();


        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        loginPage.navigateToBasePage();
        loginPage.clickLoginButton();
        loginPage.login("petyamar", "159753");
        headerPage.clickOnNewPost();
        headerPage.selectPostField();
        headerPage.uploadPicture(postPicture);
        headerPage.enterPostText("My new post!");
        headerPage.clickCreatePostButton();

        Assert.assertEquals(messageText, "Post created!");
    }

    @Test(priority = 4)
    public void testPageScreenshot() throws InterruptedException {
        Thread.sleep(5333);
        loginPage.uploadPicture(postPicture);
    }
}


