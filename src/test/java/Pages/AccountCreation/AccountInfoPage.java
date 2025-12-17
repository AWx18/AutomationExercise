package Pages.AccountCreation;

import Pages.CheckoutPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountInfoPage {
    WebDriver driver;
    Select select;
    WebDriverWait wait;
public String name;
    public String ExpectedMsg ="ENTER ACCOUNT INFORMATION";
    By ActualMsgLocator= By.xpath("//*[text()='Enter Account Information']");
By TitleLocator =By.id("id_gender1");
    By NameBoxLocator =By.id("name");
By PasswordBoxlocator =By.id ("password");
By DaysDropDownLocator =By.id ("days");
    By MonthDropDownLocator =By.id ("months");
    By YearDropDownLocator =By.id ("years");
    By NewsletterboxLocator =By.id("newsletter");
    By SpecialOffersboxLocator=By.id("optin");
By FirstnameLocator =By.id("first_name");
    By LastnameLocator =By.id("last_name");
By ComapanyLocator= By.id("company");
By Address1Locator=By.id ("address1");
By Address2Locator=By.id ("address2");
By CountryLocator =By.id("country");
    By StateLocator =By.id("state");
    By CityLocator =By.id("city");
    By ZipCodeLocator =By.id("zipcode");
    By Mobilelocator=By.id("mobile_number");
By CreateAccLocator=By.className("btn");
    By ContinueBtn = By.linkText("Continue");


    public  AccountInfoPage (WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    public String ActualMsg(){
        return driver.findElement(ActualMsgLocator).getText();
    }
    public String ExpectedMsg(){
        return ExpectedMsg;
    }
    public void SelectTitle (){
driver.findElement(TitleLocator).click();

    }
public void FillDetails(String name,String password){
    this.name = name;
    driver.findElement(NameBoxLocator).sendKeys(name);
        driver.findElement(PasswordBoxlocator).sendKeys(password);
    }
    //chatgpt code to hide ads
    public void SelectBD(String day, String month, String year) {
        Actions action = new Actions(driver);

        // Wait for ads to disappear if possible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//iframe[contains(@id,'aswift')]")));

        WebElement dayDD = wait.until(ExpectedConditions.elementToBeClickable(DaysDropDownLocator));
        action.moveToElement(dayDD).click().perform();
        new Select(dayDD).selectByVisibleText(day);

        WebElement monthDD = wait.until(ExpectedConditions.elementToBeClickable(MonthDropDownLocator));
        action.moveToElement(monthDD).click().perform();
        new Select(monthDD).selectByVisibleText(month);

        WebElement yearDD = wait.until(ExpectedConditions.elementToBeClickable(YearDropDownLocator));
        action.moveToElement(yearDD).click().perform();
        new Select(yearDD).selectByVisibleText(year);
    }
    public void ClickOnBoxes(){
        driver.findElement(NewsletterboxLocator).click();
        driver.findElement(SpecialOffersboxLocator).click();
    }

    public HomePage ClickOnContinue(){
        driver.findElement(ContinueBtn).click();
        return new HomePage(driver);
    }



public void FillAddressInfo(String firstname,String lastname,String company ,String address1, String address2,String state,String city,String zipcode,String mobile){
     driver.findElement(FirstnameLocator).sendKeys(firstname);
     driver.findElement(LastnameLocator).sendKeys(lastname);
     driver.findElement(ComapanyLocator).sendKeys(company);
     driver.findElement(Address1Locator).sendKeys(address1);
     driver.findElement(Address2Locator).sendKeys(address2);
     select =new Select(driver.findElement(CountryLocator));
    select.selectByVisibleText("India");
    driver.findElement(StateLocator).sendKeys(state);
    driver.findElement(CityLocator).sendKeys(city);
    driver.findElement(ZipCodeLocator).sendKeys(zipcode);
    driver.findElement(Mobilelocator).sendKeys(mobile);

    }
    public AccountCreated ClickonCreateAcc (){
        driver.findElement(CreateAccLocator).click();
return new AccountCreated (driver);
    }

    public CheckoutPage CompleteRegistration() {

        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("days")).sendKeys("1");
        driver.findElement(By.id("months")).sendKeys("January");
        driver.findElement(By.id("years")).sendKeys("2000");

        driver.findElement(By.id("first_name")).sendKeys("Manual");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("address1")).sendKeys("Egypt");
        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("Nasr City");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("01000000000");

        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        return new CheckoutPage(driver);
    }



}
