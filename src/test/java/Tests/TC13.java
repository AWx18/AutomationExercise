package Tests;

import BaseTest.BaseTest;
import Pages.ProductsPage;
import Pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC13 extends BaseTest {

    @Test
    public void VerifyRemoveItemFromCart()  {

        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
homePage.Addproducts();
        cartPage = homePage.ClickonCart();
Assert.assertTrue(cartPage.ActualCartPageText().contains(cartPage.ExpectedCartPageText()));

cartPage.ClickonRemoveItem();
Assert.assertEquals(cartPage.FindRemainingItems(),1,"Cart item was not removed");



    }
}
