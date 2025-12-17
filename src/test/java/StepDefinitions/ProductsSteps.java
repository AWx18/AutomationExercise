package StepDefinitions;

import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.HomePage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ProductsSteps {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;

    @Given("the user is on the products page")
    public void the_user_is_on_the_products_page() {
        homePage = new HomePage(Hooks.driver);
        productsPage = homePage.ClickOnProducts();
        Assert.assertTrue(productsPage.IsProductsPageVisible(), "Products page is not visible!");
    }

    @Then("all products should be visible")
    public void all_products_should_be_visible() {
        Assert.assertTrue(productsPage.IsProductsPageVisible(), "Products title not visible!");
    }

    @When("the user opens a product")
    public void the_user_opens_a_product() {
        productDetailsPage = productsPage.ClickOnFirstProduct();
    }

    @Then("the product details should be displayed")
    public void the_product_details_should_be_displayed() {
        Assert.assertTrue(
                productDetailsPage.IsProductDetailsVisible(),
                "Product details not displayed!"
        );
    }

    @When("the user searches for a valid product name")
    public void the_user_searches_for_a_valid_product_name() {
        productsPage.SearchProduct("dress");
    }

    @Then("matching search results should be displayed")
    public void matching_search_results_should_be_displayed() {
        Assert.assertTrue(
                productsPage.AreProductsMatchingSearch("dress"),
                "Search results do not match!"
        );
    }
}
