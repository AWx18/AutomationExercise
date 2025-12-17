package Tests;

import BaseTest.BaseTest;
import Pages.DeleteAccPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends BaseTest {


    @Test
    public void SuccessfulSignUpScenario (){

     Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
     loginPage= homePage.Clickonlogin();
        System.out.println(
                "Actual msg is "+  loginPage.getActualSignUpMsg()

        );

        System.out.println( "Expected msg is "+ loginPage.getExpectedSignUpMsg());
        Assert.assertTrue(loginPage.getActualSignUpMsg().contains(loginPage.getExpectedSignUpMsg()));

        loginPage.AddNameAndEmail("andrew", "ahmedashrafffff@gmail.com");
        accountInfoPage = loginPage.ClickonSignUp();
        accountInfoPage.SelectTitle();
        accountInfoPage.FillDetails("",  "12345678");
        accountInfoPage.SelectBD("1", "May", "2000");
        accountInfoPage.ClickOnBoxes();
        accountInfoPage.FillAddressInfo("andrew", "Doe", "Tech Corp", "123 Main Street", "Building 5", "California", "Los Angeles", "90001", "1234567890");
        accountCreated= accountInfoPage.ClickonCreateAcc();
        Assert.assertTrue(accountCreated.getActualCreationMSG().contains(accountCreated.getExpectedCreationMsg()));
        logedInPage=accountCreated.ClickOnContinue();

        logedInPage.setExpectedLoggedIn(accountInfoPage);

        Assert.assertTrue(logedInPage.LoggedInUserActual().contains(logedInPage.LoggedInUserExpected()));

        deleteAccPage=logedInPage.ClickonDeleteAcc();
        Assert.assertTrue(deleteAccPage.GetActualMsg().contains(deleteAccPage.GetExpectedMsg()));
        deleteAccPage.ClickOnContinue();
    }
}
