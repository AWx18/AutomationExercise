package Pages.AccountCreation;

import Pages.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By ActualSignUpMsg = By.xpath("//h2[contains(text(),'New User Signup')]");
String ExpectedSignUpMsg ="New User Signup!" ;
    By SignUpNameField = By.cssSelector("input[data-qa='signup-name']");
    By SignUpEmailField = By.cssSelector("input[data-qa='signup-email']");
    By signupButton = By.cssSelector("button[data-qa='signup-button']");
    By ActualLoginMsg= By.xpath("//h2[text()='Login to your account']");
    String ExpectedLoginMsg ="Login to your account";
    By LoginEmailField = By.cssSelector("input[data-qa='login-email']");
    By PasswordField = By.cssSelector("input[data-qa='login-password']");
By LoginBtn= By.className("btn");
By ActualInvalidLoginLocator =By.xpath("//p[text()='Your email or password is incorrect!']");
String ExpectedInvalidLoginMsg="Your email or password is incorrect!";
    By signupName = By.name("name");
    By signupEmail = By.cssSelector("input[data-qa='signup-email']");
    By signupBtn = By.cssSelector("button[data-qa='signup-button']");

    By CheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
String ExpectedErrorIfUserRegistered="Email Address already exist!";
    By ActualuserRegistered = By.xpath("//p[text()='Email Address already exist!']");

    public CheckoutPage ProceedToCheckout(){
        driver.findElement(CheckoutBtn).click();
        return new CheckoutPage(driver);
    }


    public LoginPage (WebDriver driver){
        this.driver=driver;
    }

    public String getActualSignUpMsg() {

        return driver.findElement(ActualSignUpMsg).getText();

    }

    public String getExpectedSignUpMsg() {
        return ExpectedSignUpMsg;
    }
    public void AddNameAndEmail(String name, String email){
        driver.findElement(SignUpNameField).sendKeys(name);
        driver.findElement(SignUpEmailField).sendKeys(email);

    }
    public AccountInfoPage ClickonSignUp (){
        driver.findElement(signupButton).click();
        return new AccountInfoPage (driver);
    }

    public String GetActualLoginMsg(){
        return driver.findElement(ActualLoginMsg).getText();

    }
    public String GetExpectedLoginMsg(){
        return ExpectedLoginMsg;

    }
    public void SetLoginFields(String email, String password){
        driver.findElement(LoginEmailField).sendKeys(email);
        driver.findElement(PasswordField).sendKeys(password);
    }
    public LogedInPage ClickonLogin (){
driver.findElement(LoginBtn).click();
return new LogedInPage(driver);
    }
    public String ActualinvalidLoginMsg(){
        return driver.findElement(ActualInvalidLoginLocator).getText();
    }
    public String ExpectedinvalidLoginMsg(){
        return ExpectedInvalidLoginMsg;
    }


    public  String ActualErrorIfUserRegistered (){
        return driver.findElement(ActualuserRegistered).getText();
    }
    public  String ExpectedIfUserRegistered (){
        return ExpectedErrorIfUserRegistered;
    }

}
