package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginButton = By.cssSelector("#nav-link-login");
    private final By usernameForm = By.cssSelector("#defaultLoginFormUsername");
    private final By passwordForm = By.cssSelector("#defaultLoginFormPassword");
    private final By signInButton = By.cssSelector("#sign-in-button");
    private final By profileButton = By.cssSelector("#nav-link-profile");
    private final String loginPageUrl = "/users/login";

    /**
     * Initializes the LoginPage with a WebDriver instance.
     * @param driver the WebDriver used to interact with the browser
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the login page.
     */
    // public void navigateToPage(){

    /// navigateTo();
    //}

    /**
     * Enters the username into the username field.
     * @param username the username to enter
     */
    public void enterUsername(String username) {
        typeText(usernameForm, username);
    }

    /**
     * Enters the password into the password field.
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        typeText(passwordForm, password);
    }

    /**
     * Clicks the sign-in button.
     */
    public void clickSignInButton() {
        click(signInButton);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        click(loginButton);
    }

    /**
     * Performs a full login action with provided credentials.
     * @param user the username
     * @param pass the password
     */
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickSignInButton();
    }

    /**
     * Clicks on the profile button after login.
     */
    public void clickProfileButton() {
        click(profileButton);

    }


    // public void navigateToPage() {
    // driver.navigate().to(baseUrl);
    //}
}
