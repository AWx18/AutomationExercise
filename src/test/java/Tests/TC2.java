package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 extends BaseTest {
    @Test
    public void SuccessfulLoginScenario (){
//Before running test case 2 you must create account because at end of test case the account is deleted
        //email=awg@gmail.com
        //pass=12345678
        Assert.assertEquals(homePage.GetExpectedlColor(),homePage.GetActualColor());
        loginPage= homePage.Clickonlogin();
        Assert.assertTrue(loginPage.GetActualLoginMsg().contains(loginPage.GetExpectedLoginMsg()));
        loginPage.SetLoginFields("awg@gmail.com","12345678");
        logedInPage=loginPage.ClickonLogin();
        Assert.assertEquals(logedInPage.LoggedInUserActual(),"12345678");
        deleteAccPage=logedInPage.ClickonDeleteAcc();
        Assert.assertTrue(deleteAccPage.GetActualMsg().contains(deleteAccPage.GetExpectedMsg()));
        deleteAccPage.ClickOnContinue();


    }

}
