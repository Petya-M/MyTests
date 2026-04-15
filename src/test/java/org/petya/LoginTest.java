package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.petya.Listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @DataProvider(name = "loginCredentials")
    public Object[][] getData() {
        return new Object[][]{
                {"petyamar", "159753", true},  // Valid user
                {"petyamar", "pass456", false}, // Valid username - wrong password
                {"invalid_user", "333333", false}  // Non-existent user
        };
    }

       //Testing the login with correct credentials, correct username - wrong pass and wrong credentials
    @Test(priority = 1, dataProvider = "loginCredentials")
    public void verifyLogin(String username, String password, boolean expectedResult) {
        LoginService loginService = new LoginService();
        boolean actualResult = loginService.login(username, password);
        Assert.assertEquals(actualResult, expectedResult, "Login result mismatch for user: " + username);
    }

    //Click on the Profile button after successful login
    @Test(priority = 2)
    public void clickProfileButtonAfterLogin() {
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        loginPage.navigateToBasePage();
        loginPage.clickLoginButton();
        loginPage.login("petyamar", "159753");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-link-profile")));
        loginPage.clickProfileButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fas.fa-user-edit")));
        Assert.assertTrue(basePage.getActualCurrentUrl().contains("11612"),"Not on the Profile page");

    }

}
