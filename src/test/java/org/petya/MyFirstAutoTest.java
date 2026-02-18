package org.petya;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstAutoTest {


    private static final By loginButton=By.cssSelector("#nav-link-login");
    private static final By usernameForm=By.cssSelector("#defaultLoginFormUsername");
    private static final By passwordForm=By.cssSelector("#defaultLoginFormPassword");
    private static final By signInButton=By.cssSelector("#sign-in-button");
    private static final By profileButton=By.cssSelector("#nav-link-profile");
    private static final By signOutButton=By.cssSelector(".fa-sign-out-alt");


    @Test
    public void MyFirstTest() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4200/posts/all");

        WebElement loginButtonElement= driver.findElement(loginButton);
        loginButtonElement.click();
        Thread.sleep(2000);

        WebElement usernameFormElement= driver.findElement(usernameForm);
        usernameFormElement.sendKeys("PetyaM");

        WebElement passwordFormElement=driver.findElement(passwordForm);
        passwordFormElement.sendKeys("p159753");
        Thread.sleep(2000);

        WebElement signInButtonElement=driver.findElement(signInButton);
        signInButtonElement.click();
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "http://training.skillo-bg.com:4200/posts/all");
        Thread.sleep(2000);

        WebElement profileButtonElement=driver.findElement(profileButton);
        profileButtonElement.click();
        Thread.sleep(2000);

        WebElement signOutButtonElement=driver.findElement(signOutButton);
        signOutButtonElement.click();
        Thread.sleep(2000);

        driver.quit();

    }

}