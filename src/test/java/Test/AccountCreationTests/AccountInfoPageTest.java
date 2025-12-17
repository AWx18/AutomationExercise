package Test.AccountCreationTests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountInfoPageTest extends BaseTest {
//    @Test
//    public void verifyDisplayMsg() {
//        loginPage = homePage.Clickonlogin();
//        loginPage.AddNameAndEmail("meshel", "meshel@gmail.com");
//        accountInfoPage = loginPage.ClickonSignUp();
//        System.out.println("Actual " + accountInfoPage.ActualMsg());
//        System.out.println("Expected " + accountInfoPage.ExpectedMsg());
//        Assert.assertTrue(accountInfoPage.ActualMsg().contains(accountInfoPage.ExpectedMsg()));
//    }

    @Test
    public void SetFields() throws InterruptedException {
        loginPage = homePage.Clickonlogin();
        loginPage.AddNameAndEmail("meshel", "helal@gmail.com");
        accountInfoPage = loginPage.ClickonSignUp();
        accountInfoPage.SelectTitle();
        accountInfoPage.FillDetails("",  "12345678");
        accountInfoPage.SelectBD("1", "May", "2000");
accountInfoPage.ClickOnBoxes();
        accountInfoPage.FillAddressInfo("meshel", "Doe", "Tech Corp", "123 Main Street", "Building 5", "California", "Los Angeles", "90001", "1234567890");
accountInfoPage.ClickonCreateAcc();


    }

}
