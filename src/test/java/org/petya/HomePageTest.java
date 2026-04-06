package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {

    @BeforeClass
    public void loginOnce() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToBasePage();
        loginPage.clickLoginButton();
        loginPage.login("petyamar", "159753");
    }

    @Test
    public void testPostsCount() {
        HomePage homePage = new HomePage(driver);
        homePage.hasPostByAuthorName("petyamar");
        List<WebElement> author = driver.findElements(By.xpath("//app-post-detail[.//a[@href='/users/11612']]"));
        System.out.println("Posts from this author: " + author.size());

    }
}