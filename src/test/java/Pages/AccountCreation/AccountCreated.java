package Pages.AccountCreation;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreated {
    WebDriver driver;
    String ExpectedCreationMsg="ACCOUNT CREATED!";

    By ActualCreationMSG=  By.cssSelector("[data-qa='account-created']");
    By ContinueBtnLocator= By.className("btn");

    public  AccountCreated(WebDriver driver){

        this.driver=driver;
    }

    public String getExpectedCreationMsg() {
        return ExpectedCreationMsg;
    }

    public String getActualCreationMSG() {
        return driver.findElement(ActualCreationMSG).getText();
    }
    public LogedInPage ClickOnContinue(){
        driver.findElement(ContinueBtnLocator).click();
    return new LogedInPage(driver);
    }
}
