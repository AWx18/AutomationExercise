package Test.AccountCreationTests;

import BaseTest.BaseTest;
import Pages.DeleteAccPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void VerifySignUpVisibilty(){
       loginPage= homePage.Clickonlogin();
        System.out.println(
              "Actual msg is "+  loginPage.getActualSignUpMsg()

        );
        System.out.println( "Expected msg is "+ loginPage.getExpectedSignUpMsg());
        Assert.assertTrue(loginPage.getActualSignUpMsg().contains(loginPage.getExpectedSignUpMsg()));

    }



}
