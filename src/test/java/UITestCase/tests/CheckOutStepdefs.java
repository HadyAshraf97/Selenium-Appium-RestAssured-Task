package UITestCase.tests;

import UITestCase.BaseTest;
import UITestCase.Hooks;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resoruces.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckOutStepdefs extends BaseTest {

    public  List<Credentials> credentialsList;
    private List<String> ProductPageName = new ArrayList<>();

    @When("user login with inValidnumber {int} and inValidpassword {int}")
    public void loginWithUserNameAndPassword(int numberKey, int passwordKey) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        credentialsList = mapper.readValue(
                new File("src/test/java/UITestCase/tests/Credentails.json"),
                new TypeReference<List<Credentials>>() {
                }
        );
        Credentials credentials = credentialsList.get(numberKey - 1);
        browser.sauseDemo.login.userLoginWith(credentials.getNumber(), credentials.getPassword());
    }

    @Then("verify the error message {int}")
    public void verifyErrorMessage(int expectedMessageKey) {
        Credentials credentials = credentialsList.get(expectedMessageKey - 1);
        String actualMessage = browser.sauseDemo.login.getErrorMsg();
        Assert.assertEquals(credentials.getExpectedMessage(), actualMessage);
    }

    @When("user login with ValidUserName {string} and ValidPassword {string}")
    public void userLoginWithValidUserNameAndValidPassword(String UserName, String Password) throws IOException {
        System.out.println("Thread ID in step definition: " + Thread.currentThread().getId());
        if (browser == null) {
            System.out.println("browser or sauseDemo or login is null");
            return;
        }
        browser.sauseDemo.product = browser.sauseDemo.login.userLoginWithCorrectCredentials(UserName, Password);

    }

    @Then("ProductTxt message should be {string}")
    public void verifyProductTextMessage(String ExpectedProductText) {
        String ActualProductTxt = browser.sauseDemo.product.getProductText();
        Assert.assertEquals(ExpectedProductText, ActualProductTxt);
    }


    @When("Select HighPrices from FilterBtn")
    public void clickOnSearchBar() {
        browser.sauseDemo.product.FilterWithHighPrices();
    }

    @When("Add The Most Expensive Two Products")
    public void AddThetwoMostExpensiveProducts() {
        ProductPageName = browser.sauseDemo.product.AddTheMostExpensiveTwoProducts();
    }

    @When("Click on the cart button")
    public void ClickonTheCartButton() {
        browser.sauseDemo.cartPage = browser.sauseDemo.product.ClickOnCartBtn();
    }

    @Then("CartTxt message should be {string}")
    public void verifyCartTextMessage(String ExpectedProductText) {
        String ActualProductTxt = browser.sauseDemo.cartPage.getCartText();
        Assert.assertEquals(ExpectedProductText, ActualProductTxt);
        Assert.assertEquals(ProductPageName, browser.sauseDemo.cartPage.getNameofTheProducts());
    }

    @When("Click on the CheckOut button")
    public void ClickonCheckOutButton() {
        browser.sauseDemo.checkOutPage = browser.sauseDemo.cartPage.clickOnCheckoutBtn();
    }

    @Then("CheckoutTxt message should be {string}")
    public void verifyCheckOutMessage(String ExpectedProductText) {
        String ActualProductTxt = browser.sauseDemo.checkOutPage.getCheckOutTxt();
        Assert.assertEquals(ExpectedProductText, ActualProductTxt);
    }

    @When("Fill all the displayed form {string}, {string},{string}")
    public void FillAllTheDisplayedForm(String FirstName, String LastName,String PostalCode) {
         browser.sauseDemo.checkOutPage.fillDisplayedForm(FirstName,LastName,PostalCode);
    }

    @When("Click on the Continue button")
    public void ClickonContinueButton() {
        browser.sauseDemo.checkoutOverviewPage = browser.sauseDemo.checkOutPage.clickOnContinueBtn();
    }

    @When("CheckoutOverViewTxt message should be {string}")
    public void verifyCheckOutOverviewMessage(String ExpectedProductText) {
        String ActualProductTxt = browser.sauseDemo.checkoutOverviewPage.getCheckOutOverViewTxt();
        Assert.assertEquals(ExpectedProductText, ActualProductTxt);
    }

    @Then("Verify the Items total amount before taxes")
    public void verifyTotalAmountMessage() {
        double ActualSum = browser.sauseDemo.checkoutOverviewPage.getTotalPricesOfProducts();
        Assert.assertEquals(browser.sauseDemo.checkoutOverviewPage.getItemTotalPrice(), ActualSum);
    }

        @Then("Verify that the URL matches")
    public void VerifyThatTheURLMatches() {
        Assert.assertEquals(browser.sauseDemo.checkoutOverviewPage.getURL(),"https://www.saucedemo.com/checkout-step-two.html"   );
    }

    @When("Click on the “Finish” button")
    public void ClickonFinishButton() {
            browser.sauseDemo.checkoutOverviewPage.clickOnFinishBtn();
    }

    @Then("Verify both, the Thank You and the order has been dispatched messages")
    public void VerifyThatTheThankYouAndOrderDispatched() {
        Assert.assertEquals(browser.sauseDemo.checkoutOverviewPage.getThankYoutxtTxt(),"Thank you for your order!"  );
        Assert.assertEquals(browser.sauseDemo.checkoutOverviewPage.getOrderDispatchTxt(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!"  );
    }


}
