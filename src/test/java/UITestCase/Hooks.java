package UITestCase;

import DriverManager.DriverManager;
import UITestCase.tests.Credentials;
import browser.Browser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resoruces.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Hooks extends BaseTest {
    private static ExtentReports extentReports;
    private static ExtentTest scenarioTest;

    @Before
    public void setUp(Scenario scenario)  {
        System.out.println("Thread ID at setUp: " + Thread.currentThread().getId());
        if (extentReports == null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String reportName = "Cucumber_Report_" + timestamp + ".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportName);
            sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Cucumber Test Report");
            sparkReporter.config().setReportName("Scenario Report");
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
        scenarioTest = extentReports.createTest(scenario.getName());
        scenarioTest.log(Status.INFO, "Starting scenario: " + scenario.getName());
        webDriverManager = new DriverManager();
        System.out.println("webDriverManager initialized: " + (webDriverManager != null));
        browser = new Browser(webDriverManager.getWebDriver());
        System.out.println("Browser initialized: " + (browser != null));

        // Check if sauseDemo is correctly initialized in the Browser class
        System.out.println("sauseDemo initialized: " + (browser.sauseDemo != null));
        data = new ConfigReader();
        webDriverManager.navigateTo(data.getProperty("url"));
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotPath = takeScreenshot(scenario.getName());
            scenarioTest.fail("Scenario failed: " + scenario.getName());
            scenarioTest.addScreenCaptureFromPath(screenshotPath);
        }
    }



    @After
    public void tearDown(Scenario scenario) {
        // Log scenario result
        if (scenario.isFailed()) {
            scenarioTest.log(Status.FAIL, "Scenario failed: " + scenario.getName());
        } else {
            scenarioTest.log(Status.PASS, "Scenario passed: " + scenario.getName());
        }
        if (extentReports != null) {
            extentReports.flush();
        }
//        // Close WebDriver
//        if (webDriverManager.getWebDriver() != null) {
//            webDriverManager.getWebDriver().quit();
//        }
    }

    public static String takeScreenshot(String scenarioName) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String screenshotPath = "screenshots/" + scenarioName + "_" + dateTime + ".png";
        File screenshot = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
