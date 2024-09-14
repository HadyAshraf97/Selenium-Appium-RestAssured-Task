package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Utils {

    AndroidDriver driver;
    AppiumDriverLocalService service;

    @BeforeMethod
    public void setup() throws MalformedURLException, URISyntaxException {

        //localserver,Capabilites
        //Appiumcode->>Appiumserver->>mobile
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HadyAs\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("HadyAshrafsPhone");
        options.setApp("C:\\Users\\HadyAs\\IdeaProjects\\HadyAshraf_SeniorQA_EjadaTask\\src\\test\\java\\resoruces\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        options.setCapability("appPackage", "com.swaglabsmobileapp");
        options.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        options.setPlatformName("Android");
        options.setUdid("emulator-5556");
        options.setAutomationName("UiAutomator2");
        options.setAutoGrantPermissions(true);
        options.setNoReset(true);
        options.setFullReset(false);

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-Username")));
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
