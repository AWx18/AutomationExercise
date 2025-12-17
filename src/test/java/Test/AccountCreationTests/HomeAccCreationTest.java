package Test.AccountCreationTests;

import BaseTest.BaseTest;
import Pages.DeleteAccPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeAccCreationTest extends BaseTest {
    DeleteAccPage deleteAccPage;
    @Test
    public void VerifySignUpNameOnHomePage() throws InterruptedException {
        loginPage = homePage.Clickonlogin();
        loginPage.AddNameAndEmail("abcd", "abcd@gmail.com");
        accountInfoPage = loginPage.ClickonSignUp();
        accountInfoPage.SelectTitle();
        accountInfoPage.FillDetails("assec",  "12345678");
        accountInfoPage.SelectBD("1", "May", "2000");
        accountInfoPage.ClickOnBoxes();
        accountInfoPage.FillAddressInfo("abcd", "Doe", "Tech Corp", "123 Main Street", "Building 5", "California", "Los Angeles", "90001", "1234567890");
        accountCreated= accountInfoPage.ClickonCreateAcc();
        logedInPage=accountCreated.ClickOnContinue();

        logedInPage.setExpectedLoggedIn(accountInfoPage);

Assert.assertTrue(logedInPage.LoggedInUserActual().contains(logedInPage.LoggedInUserExpected()));

    }
}
