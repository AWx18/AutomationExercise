package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ContactUsPage {

    WebDriver driver;

    // Locators
    By getInTouchMsg = By.xpath("//h2[text()='Get In Touch']");
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.id("message");
    By uploadFile = By.name("upload_file");
    By submitBtn = By.name("submit");
    By successMsg = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
    By homeBtn = By.linkText("Home");

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    // Step 5
    public String GetActualGetInTouchMsg(){
        return driver.findElement(getInTouchMsg).getText();
    }

    public String GetExpectedGetInTouchMsg(){
        return "GET IN TOUCH";
    }

    // Step 6
    public void FillContactForm(String name, String email, String subject, String message){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    // Step 7
    public void UploadFile(String filePath){
        driver.findElement(uploadFile).sendKeys(new File(filePath).getAbsolutePath());
    }

    // Step 8
    public void ClickSubmit(){
        driver.findElement(submitBtn).click();
    }

    // Step 9
    public void AcceptAlert(){
        driver.switchTo().alert().accept();
    }

    // Step 10
    public String GetActualSuccessMsg(){
        return driver.findElement(successMsg).getText();
    }

    public String GetExpectedSuccessMsg(){
        return "Success! Your details have been submitted successfully.";
    }

    // Step 11
    public HomePage ClickHome(){
        driver.findElement(homeBtn).click();
        return new HomePage(driver);
    }
}
