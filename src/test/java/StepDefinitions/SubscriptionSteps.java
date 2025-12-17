package StepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SubscriptionSteps {

    HomePage homePage;

    @Given("the user scrolls to the footer")
    public void the_user_scrolls_to_footer() {
        homePage = new HomePage(Hooks.driver);
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("the user enters an email to subscribe")
    public void the_user_submits_a_valid_email() {
        Hooks.driver.findElement(By.id("susbscribe_email"))
                .sendKeys("email" + System.currentTimeMillis() + "@mail.com");

        Hooks.driver.findElement(By.id("subscribe")).click();
    }

    @Then("a subscription success message should appear")
    public void a_subscription_success_message_should_appear() {
        String successMsg = Hooks.driver.findElement(By.xpath("//div[@class='alert-success']")).getText();
        Assert.assertTrue(successMsg.contains("You have been successfully subscribed!"));
    }
}
