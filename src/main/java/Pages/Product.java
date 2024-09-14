package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Product extends CommonMethods{

    private final By ProductText= By.cssSelector(".title");
    private final By dropdownProductSort= By.cssSelector("[data-test='product-sort-container']");
    private final By AddtoCartBtns= By.xpath("//button[contains(text(),'Add to cart')]");
    private final By AddToCart= By.cssSelector("[data-test='shopping-cart-link']");
    private final By ItemsName= By.cssSelector(".inventory_item_name");
WebDriver driver;
    public Product(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getProductText() {
            return getText(ProductText);
    }

    public void FilterWithHighPrices(){
        clickOnElementToBeVisible(dropdownProductSort);
        selectElement(dropdownProductSort,"hilo");
    }

    public List<String> AddTheMostExpensiveTwoProducts(){
       return selectTwoProduct(AddtoCartBtns,ItemsName);
    }

    public CartPage ClickOnCartBtn() {
        clickOnElementToBeVisible(AddToCart);
        return new CartPage(driver);
    }
}
