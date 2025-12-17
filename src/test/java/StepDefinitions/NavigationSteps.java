package StepDefinitions;

import Pages.HomePage;
import Pages.TestCasePage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class NavigationSteps {

    HomePage homePage;
    TestCasePage testCasePage;

    @Given("the user is on the home page for navigation")
    public void the_user_is_on_the_home_page_for_navigation() {
        homePage = new HomePage(Hooks.driver);
    }

    @When("the user clicks the Test Cases button")
    public void the_user_clicks_the_test_cases_button() {
        testCasePage = homePage.ClickOnTestCases();
    }

    @Then("the Test Cases page should be displayed")
    public void the_test_cases_page_should_be_displayed() {
        Assert.assertEquals(
                testCasePage.GetActualTitle(),
                testCasePage.GetExpectedTitle(),
                "Test Cases page did not open!"
        );
    }
}
