package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccPage {
    WebDriver driver;
    String ExpectedDeleteMsg ="ACCOUNT DELETED";
     By ActualDeletedMsg= By.className("title");
     By ContinueBtn= By.linkText("Continue");

    public DeleteAccPage(WebDriver driver){

        this.driver=driver;
    }
    public String GetActualMsg(){
        return driver.findElement(ActualDeletedMsg).getText();

    }
    public String GetExpectedMsg(){
        return ExpectedDeleteMsg;
    }
public HomePage ClickOnContinue (){
        driver.findElement(ContinueBtn).click();
        return new HomePage(driver);
}

}
