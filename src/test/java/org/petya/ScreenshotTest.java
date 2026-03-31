package org.petya;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotTest extends BaseTest {


    private static final String SCREENSHOTS_DIR = "target/screenshots";

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();

        new File(SCREENSHOTS_DIR).mkdirs();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
    }
    @Test
    public void loginFormScreenshot() throws IOException {
        WebElement loginForm = driver.findElement(By.cssSelector("form"));
        File tempFile = loginForm.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "login_form_element_" + timestamp + ".png";
        Path destination = Paths.get(SCREENSHOTS_DIR, fileName);

        Files.copy(tempFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Element screenshot saved to: " + destination.toAbsolutePath());
        Assert.assertTrue(Files.exists(destination), "Element screenshot file should exist");


    }
}