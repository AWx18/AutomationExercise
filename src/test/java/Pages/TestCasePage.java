package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage {

    WebDriver driver;

    By ActualTitle = By.xpath("//b[text()='Test Cases']");
    String ExpectedTitle = "TEST CASES";

    public TestCasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String GetActualTitle() {
        return driver.findElement(ActualTitle).getText().toUpperCase();
    }

    public String GetExpectedTitle() {
        return ExpectedTitle;
    }
}
