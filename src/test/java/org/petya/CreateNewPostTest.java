package org.petya;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class CreateNewPostTest extends BaseTest{

    LoginPage loginPage;
    HeaderPage headerPage;
    File postPicture = new File("src/test/resources/upload/snimka1.jpg");

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();


        loginPage = new LoginPage(driver);
        loginPage.navigateToBasePage();
        loginPage.login("petyamar", "159753");
        headerPage = new HeaderPage(driver);
        headerPage.clickOnNewPost();
    }

    @Test(priority = 4)
    public void testPageScreenshot() throws InterruptedException {
        Thread.sleep(5333);
        loginPage.uploadPicture(postPicture);
    }
}


