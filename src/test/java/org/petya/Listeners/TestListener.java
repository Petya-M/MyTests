package org.petya.Listeners;

import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.petya.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private static final String SCREENSHOT_DIR = "target/screenshots";
    private final DocFile FileUtils;

    public TestListener(DocFile fileUtils) {
        FileUtils = fileUtils;
    }

    /**
     * Executes actions when a test fails (e.g., taking screenshots, logging details).
     * @param result the test result containing failure details
     */
    @Override
    public void onTestFailure(ITestResult result) {

        Object testInstance = result.getInstance();
        WebDriver driver = ((BaseTest) testInstance).driver();
        takeScreenshot(driver, result.getMethod().getMethodName());
    }
    private void takeScreenshot(WebDriver driver, String testName) {
        try {
            File directory = new File(SCREENSHOT_DIR);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = testName + "_" + timestamp + ".png";

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(directory, fileName);

            FileUtils.copyFile(FileUtils);

            System.out.println("Screenshot saved: " + destination.getAbsolutePath());

        } catch (DocFileIOException e) {
            throw new RuntimeException(e);
        }
    }

}