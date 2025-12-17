package Pages;

import Pages.AccountCreation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;
    By CartProduct = By.className("cart_description");
    By CartPageText =By.className("active");

By RemoveitemBtn= By.className("fa-times");


    public CartPage(WebDriver driver){
        this.driver = driver;

    }

    public boolean IsProductDisplayedInCart(){
        return driver.findElement(CartProduct).isDisplayed();
    }

    By ProceedToCheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    By RegisterLoginBtn = By.xpath("//u[text()='Register / Login']");

    By CheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");

    public CheckoutPage ClickProceedToCheckout(){
        driver.findElement(CheckoutBtn).click();
        return new CheckoutPage(driver);
    }

    public LoginPage ClickRegisterLogin() {
        driver.findElement(RegisterLoginBtn).click();
        return new LoginPage(driver);
    }

    By removeBtn = By.xpath("//a[text()='X']"); // Adjust if your site uses a different selector
    By emptyCartMsg = By.xpath("//p[contains(text(),'Your shopping cart is empty')]");

    public void RemoveFirstItem() {
        driver.findElement(removeBtn).click();
    }

    // Verify cart is empty
    public boolean IsCartEmpty() {
        return driver.findElement(emptyCartMsg).isDisplayed();
}

    By quantityField = By.xpath("//input[@type='text' and contains(@name,'quantity')]"); // Adjust if needed
    By updateBtn = By.xpath("//button[text()='Update']");




    public String ActualCartPageText(){
     return    driver.findElement(CartPageText).getText();
    }
    public String ExpectedCartPageText(){
        return "Shopping Cart";
    }
    public void ClickonRemoveItem(){
        driver.findElement(RemoveitemBtn).click();
    }
    public int FindRemainingItems() {
        List<WebElement> itemsBefore = driver.findElements(By.xpath("//section[@id='cart_items']//tbody/tr"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
                By.xpath("//section[@id='cart_items']//tbody/tr"),
                itemsBefore.size()));

        return driver.findElements(By.xpath("//section[@id='cart_items']//tbody/tr")).size();
    }
    public int FindCartItems() {
     return Integer.parseInt(driver.findElement(By.cssSelector("td.cart_quantity button.disabled")).getText());


    }

}
