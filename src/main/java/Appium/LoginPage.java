package Appium;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {


    public static final String USERNAME_TEXTBOX = "aid=test-Username";

    public static final String PASSWORD_TEXTBOX = "aid=test-Password";

    public static final String LOGIN_BUTTON = "aid=test-LOGIN";
    public static final String Error_Msg = "aid=test-Error message";
    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver){
        this.driver = driver;
    }

   public void enterToUsernameTextbox(String userName){
        waitForElementVisible(driver,USERNAME_TEXTBOX);
        sendKeyToElement(driver,USERNAME_TEXTBOX,userName);
    }

    public void  enterToPasswordTextbox(String Password){
        waitForElementVisible(driver,PASSWORD_TEXTBOX);
        sendKeyToElement(driver,PASSWORD_TEXTBOX,Password);
    }


    public HomePage clickToLoginButton(){
            waitForElementClickable(driver,LOGIN_BUTTON);
            clickToElement(driver,LOGIN_BUTTON);
       return new HomePage(driver);

    }
}
