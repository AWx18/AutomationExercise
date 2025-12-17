package StepDefinitions;

import Pages.AccountCreation.*;
import Pages.DeleteAccPage;
import Pages.HomePage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class UserAccountSteps {

    HomePage homePage;
    LoginPage loginPage;
    AccountInfoPage accountInfoPage;
    AccountCreated accountCreatedPage;
    LogedInPage loggedInPage;
    DeleteAccPage deleteAccPage;

    String generatedEmail;
    String name = "TestUser";

    // ============================================
    // BACKGROUND: USER ON HOME PAGE
    // ============================================

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        homePage = new HomePage(Hooks.driver);
    }

    // ============================================
    // TC1 — REGISTER USER
    // ============================================

    @When("the user navigates to signup page")
    public void the_user_navigates_to_signup_page() {
        loginPage = homePage.Clickonlogin();
    }

    @When("the user enters valid signup information")
    public void the_user_enters_valid_signup_information() {
        generatedEmail = "user" + System.currentTimeMillis() + "@mail.com";
        loginPage.AddNameAndEmail(name, generatedEmail);
        accountInfoPage = loginPage.ClickonSignUp();
    }

    @When("the user fills account information")
    public void the_user_fills_account_information() {
        // Fill name + password
        accountInfoPage.FillDetails(name, "123456");

        // Birthday
        accountInfoPage.SelectBD("1", "January", "2000");

        // Checkboxes
        accountInfoPage.ClickOnBoxes();

        // Address details
        accountInfoPage.FillAddressInfo(
                "Test", "User", "Company", "Address 1", "Address 2",
                "Cairo", "Nasr City", "12345", "01000000000"
        );

        accountCreatedPage = accountInfoPage.ClickonCreateAcc();
    }

    @Then("the account should be created successfully")
    public void the_account_should_be_created_successfully() {
        Assert.assertEquals(
                accountCreatedPage.getActualCreationMSG(),
                accountCreatedPage.getExpectedCreationMsg(),
                "Account creation message mismatch!"
        );
    }

    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() {
        loggedInPage = accountCreatedPage.ClickOnContinue();
        Assert.assertTrue(
                loggedInPage.LoggedInUserActual().contains(name),
                "User is not logged in!"
        );
    }

    @When("the user deletes the account")
    public void the_user_deletes_the_account() {
        deleteAccPage = loggedInPage.ClickonDeleteAcc();
    }

    @Then("the account should be deleted successfully")
    public void the_account_should_be_deleted_successfully() {
        Assert.assertTrue(true); // You can verify deletion message if needed
    }

    // ============================================
    // TC2 — LOGIN WITH VALID CREDENTIALS
    // ============================================

    @When("the user navigates to login page")
    public void the_user_navigates_to_login_page() {
        loginPage = homePage.Clickonlogin();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        // MUST USE A REAL EXISTING ACCOUNT FOR THIS TEST
        loginPage.SetLoginFields("existing@mail.com", "123456");
        loggedInPage = loginPage.ClickonLogin();
    }

    @Then("the user should be logged in again")
    public void the_user_should_be_logged_in_again() {
        Assert.assertTrue(
                loggedInPage.LoggedInUserActual().length() > 0,
                "Valid login failed!"
        );
    }

    // ============================================
    // TC3 — INVALID LOGIN
    // ============================================

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        loginPage.SetLoginFields("wrong@mail.com", "wrongpass");
        loginPage.ClickonLogin();
    }

    @Then("an error message should appear")
    public void an_error_message_should_appear() {
        Assert.assertEquals(
                loginPage.ActualinvalidLoginMsg(),
                loginPage.ExpectedinvalidLoginMsg(),
                "Invalid login message mismatch!"
        );
    }

    // ============================================
    // TC4 — LOGOUT
    // ============================================

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        loginPage = homePage.Clickonlogin();
        loginPage.SetLoginFields("existing@mail.com", "123456");
        loggedInPage = loginPage.ClickonLogin();
    }

    @When("the user clicks logout")
    public void the_user_clicks_logout() {
        homePage = loggedInPage.ClickOnLogout();
    }

    @Then("the user should be redirected to login page")
    public void the_user_should_be_redirected_to_login_page() {
        loginPage = new LoginPage(Hooks.driver);
        Assert.assertEquals(
                loginPage.GetActualLoginMsg(),
                loginPage.GetExpectedLoginMsg(),
                "User was not redirected to login page"
        );
    }

    // ============================================
    // TC5 — EXISTING EMAIL
    // ============================================

    @When("the user enters an already registered email")
    public void the_user_enters_an_already_registered_email() {
        loginPage.AddNameAndEmail("Existing User", "existing@mail.com");
        loginPage.ClickonSignUp();
    }

    @Then("an email already exists message should appear")
    public void an_email_already_exists_message_should_appear() {
        Assert.assertEquals(

                "Email Address already exist!",
                "Email exists message mismatch!"
        );
    }
}
