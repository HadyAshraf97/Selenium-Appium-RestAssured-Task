package browser;


import DriverManager.DriverManager;
import Pages.*;
import org.openqa.selenium.WebDriver;

public class SauseDemo {

    public Login login;
    public Product product;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public SauseDemo(WebDriver driver){
        this.login = new Login(driver);
    }
}
