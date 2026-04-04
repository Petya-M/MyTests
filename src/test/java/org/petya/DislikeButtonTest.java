package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DislikeButtonTest extends BaseTest {


    @Test
    public void clickDislikeButton(){

        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);

        loginPage = new LoginPage(driver);
        loginPage.navigateToBasePage();
        loginPage.clickLoginButton();
        loginPage.login("petyamar", "159753");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("app-post-detail")));
        List<WebElement> dislikeButtons = driver.findElements(By.cssSelector(".fa-thumbs-down"));
        headerPage.clickDislikeButton();



        int elementsCount = headerPage.getElementsCount(By.cssSelector(".ml-2"));
        System.out.println("elementsCount:" + elementsCount);




    }
}
