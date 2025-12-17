package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5 extends BaseTest {

    @Test
    public void AlreadyRegisteredEmailSignup() {
        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
        loginPage = homePage.Clickonlogin();
        Assert.assertEquals(loginPage.getActualSignUpMsg(), loginPage.getExpectedSignUpMsg(), "'New User Signup!' message is incorrect");
        loginPage.AddNameAndEmail("awg", "awg@gmail.com"); // already registered email

         loginPage.ClickonSignUp();
Assert.assertEquals(loginPage.ActualErrorIfUserRegistered(),loginPage.ExpectedIfUserRegistered());
    }
}
