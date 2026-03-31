package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private static final By loginButton=By.cssSelector("#nav-link-login");
    static final By usernameForm=By.cssSelector("#defaultLoginFormUsername");
    static final By passwordForm=By.cssSelector("#defaultLoginFormPassword");
    private static final By signInButton=By.cssSelector("#sign-in-button");
    private static final By profileButton=By.cssSelector("#nav-link-profile");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage(){
        String loginPageUrl = "/users/login";
        navigateTo(loginPageUrl);
    }

    public void enterUsername(String username) {
        typeText(usernameForm, username);
    }

    public void enterPasswors(String password){
        typeText(passwordForm, password);
    }

    public void signInButton(){
        click(signInButton);
    }

    public void login (String user, String pass){
        enterUsername(user);
        enterPasswors(pass);
        signInButton();
    }

    public void clickProfileButton(){
        click(profileButton);

    }
}
