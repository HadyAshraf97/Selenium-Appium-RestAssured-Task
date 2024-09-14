package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CartPage extends CommonMethods {

    private final By CartText= By.cssSelector(".title");
    private final By ItemsName= By.cssSelector(".inventory_item_name");
    private final By CheckoutBtn= By.id("checkout");
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getCartText() {
        return getText(CartText);
    }

    public List<String> getNameofTheProducts(){
       return getNameOfTwoProucts(ItemsName);
    }

    public CheckOutPage clickOnCheckoutBtn(){
        clickOnElementToBeVisible(CheckoutBtn);
        return new CheckOutPage(driver);
    }
}



