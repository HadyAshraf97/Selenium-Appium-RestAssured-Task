package Appium;

import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

    public static final String PRODUCT_HEADER_LABEL = "xpath=//android.widget.TextView[@text='PRODUCTS']";
AndroidDriver driver;
    public HomePage(AndroidDriver driver){
        this.driver = driver;
    }

    public boolean isProductHeaderDisplayed() {
        waitForElementVisible(driver, PRODUCT_HEADER_LABEL);
        return isElementDisplayed(driver, PRODUCT_HEADER_LABEL);
    }
}
