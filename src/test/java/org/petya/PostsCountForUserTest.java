package org.petya;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PostsCountForUserTest extends BaseTest {

    @BeforeMethod
    public void loginOnce() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToBasePage();
        loginPage.clickLoginButton();
        loginPage.login("petyamar", "159753");
    }

    //Gets the posts count for user 11612
    @Test
    public void getPostsCountForUser() {
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickProfileButton();
        int postsCount = headerPage.getPostsCount();
        System.out.println("Posts from this author: " + postsCount);
        Assert.assertTrue(postsCount >= 0, "Posts count should be non-negative");
    }
}