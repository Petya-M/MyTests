package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By loginButton=By.cssSelector("#nav-link-login");
    private final By usernameForm=By.cssSelector("#defaultLoginFormUsername");
    private final By passwordForm=By.cssSelector("#defaultLoginFormPassword");
    private final By signInButton=By.cssSelector("#sign-in-button");
    private final By profileButton=By.cssSelector("#nav-link-profile");


    private final String loginPageUrl = "/users/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }



   // public void navigateToPage(){
        ///navigateTo();
    //}

    public void enterUsername(String username) {
        typeText(usernameForm, username);
    }

    public void enterPassword(String password){
        typeText(passwordForm, password);
    }

    public void clickSignInButton(){
        click(signInButton);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public void login (String user, String pass){
        enterUsername(user);
        enterPassword(pass);
        clickSignInButton();
    }

    public void clickProfileButton(){
        click(profileButton);

    }


   // public void navigateToPage() {
       // driver.navigate().to(baseUrl);
    //}
}
