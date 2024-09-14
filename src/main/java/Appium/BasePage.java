package Appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriverWait explicitWait;

    private final long longTimeout = 40;


    private String getLocatorValue(String locator) {
        return locator.substring(locator.indexOf("=") + 1);
    }

    private By getByLocator(String locator) {
        By by = null;
        String trueLocator = locator.toLowerCase();

        if (trueLocator.startsWith("id=")) {
            by = AppiumBy.id(getLocatorValue(locator));
        } else if (trueLocator.startsWith("aid=")) {
            by = AppiumBy.accessibilityId(getLocatorValue(locator));
        } else if (trueLocator.startsWith("class")) {
            by = AppiumBy.className(getLocatorValue(locator));
        } else if (trueLocator.startsWith("name=")) {
            by = AppiumBy.name(getLocatorValue(locator));
        } else if (trueLocator.startsWith("xpath=")) {
            by = AppiumBy.xpath(getLocatorValue(locator));
        } else if (trueLocator.startsWith("img=")) {
            by = AppiumBy.image(getLocatorValue("img="));
        } else if (trueLocator.startsWith("uia2=")) {
            by = AppiumBy.androidUIAutomator(getLocatorValue("uia2="));
        } else {
            throw new RuntimeException("Locator type is invalid");
        }
        return by;
    }


    private WebElement getElement(AndroidDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }




    protected void clickToElement(AndroidDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    protected void sendKeyToElement(AndroidDriver driver, String locator, String value) {
        getElement(driver, locator).sendKeys(value);
    }


    protected Boolean isElementDisplayed(AndroidDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }


    protected void waitForElementVisible(AndroidDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOf(getElement(driver, locator)));
    }


    protected void waitForElementClickable(AndroidDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getElement(driver, locator)));
    }




}
