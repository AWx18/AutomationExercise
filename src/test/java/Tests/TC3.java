package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3 extends BaseTest {
    @Test
    public void FailLoginScenario() {

        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
        loginPage = homePage.Clickonlogin();
        Assert.assertTrue(loginPage.GetActualLoginMsg().contains(loginPage.GetExpectedLoginMsg()));
        loginPage.SetLoginFields("awg@gmail.com", "1234567");
        loginPage.ClickonLogin();
Assert.assertTrue(loginPage.ActualinvalidLoginMsg().contains(loginPage.ExpectedinvalidLoginMsg()));
    }
}
