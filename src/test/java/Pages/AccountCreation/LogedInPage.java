package Pages.AccountCreation;

import Pages.DeleteAccPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogedInPage {
    WebDriver driver;

    public LogedInPage (WebDriver driver){
        this.driver = driver;
    }

    By loggedInUser = By.xpath("//i[@class='fa fa-user']/following-sibling::b");
    By DeleteAccountLocator = By.linkText("Delete Account");
    By LogoutLocator = By.linkText("Logout"); // Added for logout
    String ExpectedLogedIn;

    public String LoggedInUserActual(){
        return driver.findElement(loggedInUser).getText();
    }

    public void setExpectedLoggedIn(AccountInfoPage accountInfoPage) {
        this.ExpectedLogedIn = accountInfoPage.name;
    }

    public String LoggedInUserExpected(){
        return ExpectedLogedIn;
    }

    public DeleteAccPage ClickonDeleteAcc(){
        driver.findElement(DeleteAccountLocator).click();
        return  new DeleteAccPage(driver);
    }

    public HomePage ClickOnLogout(){
        driver.findElement(LogoutLocator).click();
        return new HomePage(driver);
    }
}
