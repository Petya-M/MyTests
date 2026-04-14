package org.petya;

public class LoginService {

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
