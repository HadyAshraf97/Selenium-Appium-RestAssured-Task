package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends CommonMethods{

    private final By CheckoutTxt= By.cssSelector(".title");
    private final By inputFirstName= By.cssSelector("[data-test='firstName']");
    private final By inputLastName= By.cssSelector("[data-test='lastName']");
    private final By inputPostalCode= By.cssSelector("[data-test='postalCode']");
    private final By buttonContinue= By.cssSelector("[data-test='continue']");
WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getCheckOutTxt() {
        return getText(CheckoutTxt);
    }

    public void  EnterFirstName(String FirstName){
        sendText(inputFirstName,FirstName);

    }

    public void EnterLastName(String LastName) {
        sendText(inputLastName, LastName);

    }

    public void EnterPostalCode(String PostalCode) {
        sendText(inputPostalCode, PostalCode);

    }

    public CheckoutOverviewPage clickOnContinueBtn(){
        clickOnElementToBeVisible(buttonContinue);
        return new CheckoutOverviewPage(driver);
    }


        public void fillDisplayedForm(String FirstName, String LastName,String PostalCode) {
        EnterFirstName(FirstName);
        EnterLastName(LastName);
        EnterPostalCode(PostalCode);
    }


}
