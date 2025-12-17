package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    WebDriver driver;

    By cardNameField = By.name("name_on_card");
    By cardNumberField = By.name("card_number");
    By cvcField = By.name("cvc");
    By expiryMonthField = By.name("expiry_month");
    By expiryYearField = By.name("expiry_year");
    By payButton = By.id("submit");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Fill card details
    public void EnterCardDetails(String name, String number, String month, String year, String cvc) {
        driver.findElement(cardNameField).sendKeys(name);
        driver.findElement(cardNumberField).sendKeys(number);
        driver.findElement(expiryMonthField).sendKeys(month);
        driver.findElement(expiryYearField).sendKeys(year);
        driver.findElement(cvcField).sendKeys(cvc);
    }

    public void EnterCardDetails(String number, String month, String year, String cvc) {
        driver.findElement(cardNumberField).sendKeys(number);
        driver.findElement(expiryMonthField).sendKeys(month);
        driver.findElement(expiryYearField).sendKeys(year);
        driver.findElement(cvcField).sendKeys(cvc);
    }

    public ConfirmationPage CompletePayment() {
        driver.findElement(payButton).click();
        return new ConfirmationPage(driver);
    }


}
