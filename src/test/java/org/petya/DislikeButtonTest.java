package org.petya;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import static org.openqa.selenium.By.*;

public class DislikeButtonTest extends BaseTest {


    @Test
    public void clickDislikeButton() {

        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);

        loginPage.navigateToBasePage();
        loginPage.clickLoginButton();
        loginPage.login("petyamar", "159753");
        headerPage.clickDislikeButton();

        WebElement post;
        post = driver.findElement(By.xpath("//app-post-detail[.//a[@href='/users/11612']]"));
        WebElement dislikesElement = post.findElement(
                xpath(".//strong[contains(text(),'dislikes')]")
        );

        String dislikesText = dislikesElement.getText();
        int dislikesCount = Integer.parseInt(dislikesText.split(" ")[0]);
        System.out.println("Number of displikes: " + dislikesCount);
       // Assert.notNull(dislikesCount, "dislikesCount should not be null");
        Assert.assertTrue(dislikesCount > 0, "dislikesCount should not be 0");
    }
}
