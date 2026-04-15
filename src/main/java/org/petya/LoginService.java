package org.petya;

public class LoginService {

    /**
     * Handles the login process by coordinating actions from the LoginPage.
     * @param username the username
     * @param password the password
     */
    public boolean login(String username, String password) {
        if (username.equals("petyamar") && password.equals("159753")) {
            return true;
        }
       if (username.equals("petyamar") && password.equals("pass456")) {
            System.out.println("LOG: Wrong username or password for " + username);
            return false;
        }
        return false;
    }
}
