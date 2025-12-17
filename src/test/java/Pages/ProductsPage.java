package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    WebDriver driver;

    By AllProductsTitle = By.xpath("//h2[text()='All Products']");
    By FirstProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");

    By searchField = By.id("search_product");
    By searchButton = By.id("submit_search");
    By productsList = By.cssSelector(".product-image-wrapper");

    By FirstAddToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By ContinueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    By ViewCartBtn = By.xpath("//u[text()='View Cart']");

    //*[@id="cartModal"]/div/div/div[2]/p[2]/a/u
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean IsProductsPageVisible() {
        return driver.findElement(AllProductsTitle).isDisplayed();
    }

    public ProductDetailsPage ClickOnFirstProduct() {
        driver.findElement(FirstProduct).click();
        return new ProductDetailsPage(driver);
    }

    public void SearchProduct(String productName) {
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public boolean AreProductsMatchingSearch(String productName) {
        List<WebElement> products = driver.findElements(productsList);
        if (products.isEmpty()) {
            return false; // No products found
        }
        for (WebElement product : products) {
            if (!product.getText().toLowerCase().contains(productName.toLowerCase())) {
                return false;
            }
        }
        return true;
    }


    public void AddFirstProductToCart() {
        driver.findElement(FirstAddToCartBtn).click();
    }

    public void ClickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinueShoppingBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);
    }

    public CartPage ClickonViewCartbtn() {
        WebElement viewBtn = driver.findElement(ViewCartBtn);
        viewBtn.click();
        return new CartPage(driver);
    }



    public CartPage OpenCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCartBtn = wait.until(ExpectedConditions.elementToBeClickable(ViewCartBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewCartBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartBtn);

        return new CartPage(driver);
    }

}
