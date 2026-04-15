package org.petya.Listeners;

import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.petya.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TestNG listener that captures screenshots when a test fails.
 */
public class TestListener implements ITestListener {

    /**
     * Triggered when a test method fails.
     * Takes a screenshot of the current browser state.
     *
     * @param result the result of the failed test containing context and metadata
     */
    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        takeScreenshot(driver, result.getName());
    }

    /**
     * Captures a screenshot and saves it to the local filesystem.
     *
     * @param driver   the WebDriver instance used to capture the screenshot
     * @param testName the name of the test (used in the screenshot filename)
     */
    private void takeScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String directoryPath = "screenshots";
        File directory = new File(directoryPath);

        // Create directory if it doesn't exist
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String destinationPath = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            Files.copy(source.toPath(), new File(destinationPath).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Test " + testName + " failed. Screenshot saved at: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}