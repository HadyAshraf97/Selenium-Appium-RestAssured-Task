package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends CommonMethods{
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By LoginBtn = By.id("login-button");
    private final By errorMsg = By.cssSelector("[data-test=\"error\"]");
WebDriver driver ;
    public Login(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void enterUsername(String username) {
        sendText(usernameField,username);
    }

    public void enterPassword(String password) {
        sendText(passwordField,password);
    }
    public void ClickOnLogin() {
         clickOnElementToBeVisible(LoginBtn);
    }

    public void userLoginWith(String number, String password) {
        enterUsername(number);
        enterPassword(password);
        ClickOnLogin();
    }

    public String getErrorMsg(){
        return getText(errorMsg);
    }

        public Product userLoginWithCorrectCredentials(String number, String password) {
        enterUsername(number);
        enterPassword(password);
        ClickOnLogin();
        return new Product(driver);
    }


}
