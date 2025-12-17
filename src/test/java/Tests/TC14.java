package Tests;

import BaseTest.BaseTest;
import Pages.ProductsPage;
import Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends BaseTest {

    @Test
    public void VerifyCartQuantity() {

        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
        productDetailsPage= homePage.ClickViewOnFirstProduct();


        Assert.assertTrue(productDetailsPage.IsProductDetailsVisible(),
                "Product details are not visible");
 productDetailsPage.ChangeQuantity(4);
 cartPage=productDetailsPage.ClickOnViewCart();
 Assert.assertEquals(cartPage.FindCartItems(),4,"not 4");


        }
}
