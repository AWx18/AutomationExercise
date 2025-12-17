package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    By CheckoutTitle = By.xpath("//h2[text()='Checkout']");
    By AddressDetails = By.xpath("//h2[text()='Address Details']");
    By ReviewOrder = By.xpath("//h2[text()='Review Your Order']");

    By CommentBox = By.name("message");
    By PlaceOrderBtn = By.xpath("//a[text()='Place Order']");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean IsCheckoutPageVisible() {
        return driver.findElement(AddressDetails).isDisplayed()
                && driver.findElement(ReviewOrder).isDisplayed();
    }

    public void AddComment(String message){
        driver.findElement(CommentBox).sendKeys(message);
    }

    public PaymentPage ClickPlaceOrder(){
        driver.findElement(PlaceOrderBtn).click();
        return new PaymentPage(driver);
    }
}
