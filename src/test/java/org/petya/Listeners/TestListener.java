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
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static final String SCREENSHOT_DIR = "src/test/resources/screenshots";
    private final DocFile FileUtils;

    public TestListener(DocFile fileUtils) {
        FileUtils = fileUtils;
    }

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

            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
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