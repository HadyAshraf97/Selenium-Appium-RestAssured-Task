package Pages;


import DriverManager.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonMethods {

    private WebDriver driver;
    private WebDriverWait wait;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Adjust timeout as needed
    }

    public void clickOnElementToBeClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.out.println("Error clicking on element: " + e.getMessage());
        }
    }

    public void clickOnElementToBeVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.out.println("Error clicking on element: " + e.getMessage());
        }
    }

    public void waitElementToBeInvisible(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Error waiting for element to be invisible: " + e.getMessage());
        }
    }

    public void selectElement(By locator, String value) {
        try {
            WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select sel = new Select(selectElement);
            sel.selectByValue(value);
        } catch (Exception e) {
            System.out.println("Error selecting element: " + e.getMessage());
        }
    }

    public void sendText(By locator, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator).sendKeys(text);
        } catch (Exception e) {
            System.out.println("Error sending text to element: " + e.getMessage());
        }
    }

    public String getText(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        } catch (Exception e) {
            System.out.println("Error getting text from element: " + e.getMessage());
            return null;
        }
    }

    public List<String> selectTwoProduct(By locator, By locator2) {
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            List<WebElement> elementsText = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator2));
            List<String> productText = new ArrayList<>();
            for (int i=0; i <2;i++) {
               elements.get(i).click();
               productText.add(elementsText.get(i).getText());
            }
            System.out.println(productText);
            return productText;

        } catch (Exception e) {
            System.out.println("Error selecting product: " + e.getMessage());
        }
        return null;
    }

    public List<String> getNameOfTwoProucts(By locator) {
        try {
            List<WebElement> elementsText = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            List<String> productText = new ArrayList<>();
            for (int i=0; i <2;i++) {
                productText.add(elementsText.get(i).getText());
            }
         return productText;
        } catch (Exception e) {
            System.out.println("Error selecting product: " + e.getMessage());
        }
        return null;
    }

    public double getTotalPrices(By locator) {
        try {
            List<WebElement> elementsText = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            double sum = 0.0;
            for (int i=0; i <2;i++) {
                String priceWithoutDollar = elementsText.get(i).getText().split("\\$")[1].trim();
                double priceAsDouble = Double.parseDouble(priceWithoutDollar);
                sum = sum + priceAsDouble;
            }
            return sum;
        } catch (Exception e) {
            System.out.println("Error selecting product: " + e.getMessage());
        }
        return 0;
    }

    public double getPriceAsDouble(By locator) {
        String price = driver.findElement(locator).getText();
        String priceWithoutDollar = price.split("\\$")[1].trim();
        return Double.parseDouble(priceWithoutDollar);
    }

    public String getUrl(){
       return driver.getCurrentUrl();
    }


}
