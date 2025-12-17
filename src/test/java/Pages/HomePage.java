package Pages;
import Pages.ContactUsPage;
import Pages.AccountCreation.AccountInfoPage;
import Pages.AccountCreation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait ;

    By HomeBtnLocator=By.linkText("Home");
    By addToCartProduct1Btn = By.cssSelector("a[data-product-id='1']");
    By addToCartProduct2Btn = By.cssSelector("a[data-product-id='2']");
    By ContinueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    By CartBtn= By.linkText("Cart");
    String ExpectedColor="rgb(255, 165, 0)";
    By loginLink = By.cssSelector("a[href='/login']");
    By FirstProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");


public HomePage (WebDriver driver){
        this.driver=driver;


}
    public String GetActualColor (){
        return driver.findElement(HomeBtnLocator).getCssValue("color");
    }
    public String GetExpectedlColor () {
        return  ExpectedColor;
    }
    public LoginPage Clickonlogin(){
        driver.findElement(loginLink).click();
        return  new LoginPage (driver);

    }

    By contactUsBtn = By.linkText("Contact us");

    public ContactUsPage ClickOnContactUs(){
        driver.findElement(contactUsBtn).click();
        return new ContactUsPage(driver);
    }

    By TestCasesBtn = By.linkText("Test Cases");

    public TestCasePage ClickOnTestCases() {
        driver.findElement(TestCasesBtn).click();
        return new TestCasePage(driver);
    }

    By ProductsBtn = By.xpath("//a[@href='/products']");

    public ProductsPage ClickOnProducts() {
        driver.findElement(ProductsBtn).click();
        return new ProductsPage(driver);
    }

    public void Addproducts ()  {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // FIXED

        driver.findElement(addToCartProduct1Btn).click();
        wait.until(ExpectedConditions.elementToBeClickable(ContinueShoppingBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartProduct2Btn)).click();


        wait.until(ExpectedConditions.elementToBeClickable(ContinueShoppingBtn)).click();

    }
public CartPage ClickonCart(){
                driver.findElement(CartBtn).click();
                return new CartPage(driver);

}
    public ProductDetailsPage ClickViewOnFirstProduct() {
        driver.findElement(FirstProduct).click();
        return new ProductDetailsPage(driver);
    }


}
