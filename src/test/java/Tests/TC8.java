package Tests;

import BaseTest.BaseTest;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC8 extends BaseTest {

    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;

    @Test
    public void VerifyProductListingAndDetails() {

        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");

        productsPage = homePage.ClickOnProducts();

        Assert.assertTrue(productsPage.IsProductsPageVisible(), "All Products page is not displayed");

        productDetailsPage = productsPage.ClickOnFirstProduct();
        Assert.assertTrue(productDetailsPage.IsProductDetailsVisible(),
                "Product details are not visible");
    }
}
