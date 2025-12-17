package Test.AccountCreationTests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreatedTest extends BaseTest {
    @Test
    public void VerifyAccountCreated() throws InterruptedException {
        loginPage = homePage.Clickonlogin();
        loginPage.AddNameAndEmail("meshel", "adham@gmail.com");
        accountInfoPage = loginPage.ClickonSignUp();
        accountInfoPage.SelectTitle();
        accountInfoPage.FillDetails("assec",  "12345678");
        accountInfoPage.SelectBD("1", "May", "2000");
        accountInfoPage.ClickOnBoxes();
        accountInfoPage.FillAddressInfo("meshel", "Doe", "Tech Corp", "123 Main Street", "Building 5", "California", "Los Angeles", "90001", "1234567890");
       accountCreated= accountInfoPage.ClickonCreateAcc();
        Assert.assertTrue(accountCreated.getActualCreationMSG().contains(accountCreated.getExpectedCreationMsg()));


    }
}
