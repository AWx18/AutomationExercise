package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    WebDriver driver;

    By orderPlacedMessage = By.xpath("//p[contains(text(),'Your order has been placed successfully!')]");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean IsOrderPlacedSuccessfully() {
        return driver.findElement(orderPlacedMessage).isDisplayed();
    }
}
