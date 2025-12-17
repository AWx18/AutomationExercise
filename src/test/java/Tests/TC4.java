package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4 extends BaseTest {

    @Test
    public void SuccessfulLogoutScenario() {
        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
        loginPage= homePage.Clickonlogin();
        Assert.assertTrue(loginPage.GetActualLoginMsg().contains(loginPage.GetExpectedLoginMsg()), "Login message is incorrect");
        loginPage.SetLoginFields("awg@gmail.com", "1234567");
        logedInPage = loginPage.ClickonLogin();
        Assert.assertTrue(logedInPage.LoggedInUserActual().contains("awg"),
                "User is not logged in correctly");
        logedInPage.ClickOnLogout();
        Assert.assertTrue(loginPage.GetActualLoginMsg().contains(loginPage.GetExpectedLoginMsg()),
                "User was not navigated back to login page");
    }
}
