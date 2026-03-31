package org.petya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;

public class BaseTest {



    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }


}
