package Tests;

import BaseTest.BaseTest;
import Pages.CartPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends BaseTest {

    @Test
    public void VerifyAddProductsToCart(){

        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page not visible");
        ProductsPage productsPage = homePage.ClickOnProducts();

        Assert.assertTrue(productsPage.IsProductsPageVisible(), "Products page is not visible");

        productsPage.AddFirstProductToCart();

        CartPage cartPage = productsPage.OpenCart();

        Assert.assertTrue(cartPage.IsProductDisplayedInCart(), "Product is not displayed in the cart");
    }
}
