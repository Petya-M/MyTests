package org.petya;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @BeforeClass
    public void loginOnce() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToBasePage();
        loginPage.login("petyamar", "159753");
    }

    @Test
    public void postAuthorNameIsCorrect() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPostAuthorByIndex(1), "petyamar");
    }
}
