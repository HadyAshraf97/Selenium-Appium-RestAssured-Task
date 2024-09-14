package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends CommonMethods{

    private final By CheckoutOverViewTxt= By.cssSelector(".title");
    private final By itemsPrice= By.cssSelector(".inventory_item_price");
    private final By ItemTotalPriceText= By.cssSelector("[data-test='subtotal-label']");
    private final By finishBtn= By.cssSelector("[data-test='finish']");
    private final By ThankYoutxt= By.cssSelector(".complete-header");
    private final By dispatchMsg= By.cssSelector(".complete-text");
    WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getThankYoutxtTxt() {
        return getText(ThankYoutxt);
    }

    public String getCheckOutOverViewTxt() {
        return getText(CheckoutOverViewTxt);
    }

        public double getTotalPricesOfProducts() {
        return getTotalPrices(itemsPrice);
    }

    public double getItemTotalPrice(){
     return  getPriceAsDouble(ItemTotalPriceText);
    }


    public String getURL() {
        return getUrl();
    }

    public void clickOnFinishBtn() {
        clickOnElementToBeVisible(finishBtn);
    }

    public String getOrderDispatchTxt() {
        return getText(dispatchMsg);
    }
}
