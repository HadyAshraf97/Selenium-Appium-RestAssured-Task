package browser;
import org.openqa.selenium.WebDriver;

public class Browser {

    public SauseDemo sauseDemo;
    public Browser(WebDriver driver) {
        if (driver != null) {
            sauseDemo = new SauseDemo(driver);
        } else {
            throw new IllegalArgumentException("WebDriver instance is null");
        }
    }
}
