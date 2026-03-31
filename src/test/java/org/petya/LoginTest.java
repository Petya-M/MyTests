package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.TestNGException;

import java.time.Duration;

//import static org.petya.LoginPage.passwordForm;
//import static org.petya.LoginPage.usernameForm;

public class LoginTest extends BaseTest{


    @DataProvider(name = "loginCredentials")
    public Object[][] getData() {
        return new Object[][] {
                {"petyamar", "159753", true},  // Valid user
                {"petyamar", "pass456", false}, //
                {"invalid_user", "333333", false}  // Non-existent user
        };
    }


    @Test(priority = 1)
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.navigateToPage();
        loginPage.login("petyamar", "159753");
        loginPage.clickSignInButton();
        homePage.verifyPageLoaded();
        Assert.assertTrue(homePage.isUrlLoaded(), "User was not redirected to the Home Page!");
    }

    @Test(priority = 2, dataProvider = "loginCredentials")
    public void verifyLogin(String username, String password, boolean expectedResult) {
        System.out.println("Checking login for: " + username);
        LoginService loginService = new LoginService();
        boolean actualResult = loginService.login(username, password);

        Assert.assertEquals(actualResult, expectedResult, "Login result mismatch for user: " + username);
    }

    @Test(priority = 3)
    public void clickProfile() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login("petyamar", "159753");
        loginPage.clickSignInButton();
        loginPage.clickProfileButton();
        Thread.sleep(3333);

    }

}
