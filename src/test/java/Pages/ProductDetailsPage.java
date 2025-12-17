package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {

    WebDriver driver;
    WebDriverWait wait ;
    By ProductName = By.className("product-information");
    By Category = By.xpath("//p[contains(text(),'Category')]");
    By Price = By.xpath("//span[contains(text(),'Rs.')]");
    By Availability = By.xpath("//b[contains(text(),'Availability')]");
    By Condition = By.xpath("//b[contains(text(),'Condition')]");
    By Brand = By.xpath("//b[contains(text(),'Brand')]");
    By ViewCartBtn= By.linkText("View Cart");
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean IsProductDetailsVisible() {
        return driver.findElement(ProductName).isDisplayed()
                && driver.findElement(Category).isDisplayed()
                && driver.findElement(Price).isDisplayed()
                && driver.findElement(Availability).isDisplayed()
                && driver.findElement(Condition).isDisplayed()
                && driver.findElement(Brand).isDisplayed();
    }
    public void ChangeQuantity(int quantity){

        WebElement qtyInput = driver.findElement(By.id("quantity"));

        qtyInput.click();
        qtyInput.clear();
        qtyInput.sendKeys(String.valueOf(quantity));

        driver.findElement(By.xpath("//button[contains(.,'Add to cart')]")).click();

    }
    public CartPage ClickOnViewCart(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartBtn)).click();

return   new   CartPage(driver);
    }
}
