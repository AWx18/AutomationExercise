package Tests;

import BaseTest.BaseTest;
import Pages.ProductsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC9 extends BaseTest {

    @Test
    public void SearchFunctionalityTest() {
        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");

        ProductsPage productsPage = homePage.ClickOnProducts();

        Assert.assertTrue(productsPage.IsProductsPageVisible(), "Products page is not displayed");

        String productName = "T-shirt"; // write any product example
        productsPage.SearchProduct(productName);

        Assert.assertTrue(productsPage.AreProductsMatchingSearch(productName), "Matching products are not displayed for search: " + productName);
    }
}
