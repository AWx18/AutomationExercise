package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CartSteps {

    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;

    @Given("the user is viewing a product detail")
    public void the_user_is_viewing_a_product_detail() {
        homePage = new HomePage(Hooks.driver);
        productDetailsPage = homePage.ClickViewOnFirstProduct();

        Assert.assertTrue(
                productDetailsPage.IsProductDetailsVisible(),
                "Product details page did not open!"
        );
    }

    @When("the user increases the quantity to {int}")
    public void the_user_increases_the_quantity_to(Integer qty) {
        productDetailsPage.ChangeQuantity(qty);
    }

    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        cartPage = productDetailsPage.ClickOnViewCart();

        Assert.assertTrue(cartPage.IsProductDisplayedInCart(),
                "Product was NOT displayed in cart after adding!");
    }

    @Then("the cart should show quantity {int}")
    public void the_cart_should_show_quantity(Integer expectedQty) {
        int actualQty = cartPage.FindCartItems();
        Assert.assertEquals(
                actualQty,
                expectedQty.intValue(),
                "Cart quantity does not match expected!"
        );
    }
}
