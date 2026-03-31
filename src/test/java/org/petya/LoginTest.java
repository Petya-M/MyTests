package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.petya.LoginPage.passwordForm;
import static org.petya.LoginPage.usernameForm;

public class LoginTest extends BaseTest{

    @DataProvider(name = "loginCredentials")
    public Object[][] getData() {
        return new Object[][] {
                {"petyamar", "159753", true},  // Valid user
                {"petyamar", "pass456", false}, //
                {"invalid_user", "333333", false}  // Non-existent user
        };
    }

    protected void waitForVisibilityAndSendKeys(WebDriver driver, By locator, String input) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(input);
    }


    @Test(priority = 1)
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.navigateToPage();
        waitForVisibilityAndSendKeys(driver, LoginPage.usernameForm, "petyamar");
        //loginPage.login("petyamar", "159753");
        waitForVisibilityAndSendKeys(driver, LoginPage.passwordForm, "159753");
        homePage.verifyPageLoaded();
        Assert.assertTrue(homePage.isUrlLoaded(), "User was not redirected to the Home Page!");
    }

    @Test(priority = 3)
    public void clickProfile() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickProfileButton();
        Thread.sleep(1333);

    }


    @Test(priority = 2, dataProvider = "loginCredentials")
    public void verifyLogin(String username, String password, boolean expectedResult) {
        System.out.println("Checking login for: " + username);
        LoginService loginService = new LoginService();
        boolean actualResult = loginService.login(username, password);

        Assert.assertEquals(actualResult, expectedResult, "Login result mismatch for user: " + username);
    }

}
