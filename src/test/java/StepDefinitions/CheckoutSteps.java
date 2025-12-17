package StepDefinitions;

import Pages.*;
import Pages.AccountCreation.LoginPage;
import Pages.AccountCreation.LogedInPage;
import org.testng.Assert;
import io.cucumber.java.en.*;

public class CheckoutSteps {

    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    LoginPage loginPage;
    LogedInPage loggedInPage;

    @Given("the user has added products to the cart")
    public void the_user_has_added_products_to_the_cart() {
        homePage = new HomePage(Hooks.driver);
        homePage.Addproducts();
        cartPage = homePage.ClickonCart();
        Assert.assertTrue(cartPage.IsProductDisplayedInCart(), "Product not added to cart!");
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {

        // 1) Click Proceed to Checkout
        checkoutPage = cartPage.ClickProceedToCheckout();

        // 2) If NOT logged in → we get redirected to login page
        String currentUrl = Hooks.driver.getCurrentUrl();

        if (currentUrl.contains("/login")) {
            // Login then try checkout again
            loginPage = new LoginPage(Hooks.driver);
            loginPage.SetLoginFields("existing@mail.com", "123456");
            loggedInPage = loginPage.ClickonLogin();

            // Go to cart again
            homePage = new HomePage(Hooks.driver);
            cartPage = homePage.ClickonCart();

            // Proceed again
            checkoutPage = cartPage.ClickProceedToCheckout();
        }

        // Now verify checkout page visibility
        Assert.assertTrue(checkoutPage.IsCheckoutPageVisible(), "Checkout page did NOT load!");
    }

    @When("the user enters payment information")
    public void the_user_enters_payment_information() {
        paymentPage = checkoutPage.ClickPlaceOrder();
        paymentPage.EnterCardDetails("Test User", "4111111111111111", "11", "2027", "123");
        confirmationPage = paymentPage.CompletePayment();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        Assert.assertTrue(confirmationPage.IsOrderPlacedSuccessfully(),
                "Order was NOT placed successfully!");
    }
}
