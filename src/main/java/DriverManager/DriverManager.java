package DriverManager;

import Base.AppConstrains;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public DriverManager() {
        initializeDriver();
    }

    private void initializeDriver() {
        WebDriver driver = webDriver.get();
        if (driver == null) {
            String browserType = AppConstrains.browserName.toLowerCase();


            switch (browserType) {

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    // Setup ChromeDriver using WebDriverManager
                    WebDriverManager.chromedriver().setup();
                    webDriver.set(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    // Setup FirefoxDriver using WebDriverManager
                    WebDriverManager.firefoxdriver().setup();
                    webDriver.set(new FirefoxDriver(firefoxOptions));
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
        }
    }

    public static WebDriver getWebDriver() {
        WebDriver driver = webDriver.get();
        if (driver == null) {
            System.out.println("WebDriver is null");
        }
        return driver;
    }

    public void navigateTo(String link) {
        getWebDriver().navigate().to(link);
    }

    public void resetCache() {
        getWebDriver().manage().deleteAllCookies();
    }

    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
            webDriver.remove();  // Clean up the ThreadLocal instance
        }
    }
}
