package StepDefinitions;

import Pages.ContactUsPage;
import Pages.HomePage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ContactUsSteps {

    HomePage homePage;
    ContactUsPage contactUsPage;

    @Given("the user is on the contact us page")
    public void the_user_is_on_the_contact_us_page() {
        homePage = new HomePage(Hooks.driver);
        contactUsPage = homePage.ClickOnContactUs();
        Assert.assertEquals(
                contactUsPage.GetActualGetInTouchMsg(),
                contactUsPage.GetExpectedGetInTouchMsg(),
                "Contact Us page header mismatch!"
        );
    }

    @When("the user fills the contact form")
    public void the_user_fills_the_contact_form() {
        contactUsPage.FillContactForm(
                "Test User",
                "test@mail.com",
                "Test Subject",
                "This is a test message"
        );
    }

    @When("the user uploads a file")
    public void the_user_uploads_a_file() {
        contactUsPage.UploadFile("src/test/resources/testfile.txt");
    }

    @When("the user submits the form")
    public void the_user_submits_the_form() {
        contactUsPage.ClickSubmit();
        contactUsPage.AcceptAlert();
    }

    @Then("a success message should appear")
    public void a_success_message_should_appear() {
        Assert.assertEquals(
                contactUsPage.GetActualSuccessMsg(),
                contactUsPage.GetExpectedSuccessMsg(),
                "Contact form success message mismatch!"
        );
    }

    @When("the user returns to the home page")
    public void the_user_returns_to_the_home_page() {
        homePage = contactUsPage.ClickHome();
    }

    @Then("the home page should be displayed")
    public void the_home_page_should_be_displayed() {
        Assert.assertEquals(
                homePage.GetActualColor(),
                homePage.GetExpectedlColor(),
                "Home page is not displayed!"
        );
    }
}
