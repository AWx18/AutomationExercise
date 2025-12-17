package Tests;

import BaseTest.BaseTest;
import Pages.TestCasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC7 extends BaseTest {

    TestCasePage testCasesPage;

    @Test
    public void VerifyTestCasesPageNavigation() {

        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
        testCasesPage = homePage.ClickOnTestCases();

        Assert.assertEquals(testCasesPage.GetActualTitle(), testCasesPage.GetExpectedTitle(), "User was not navigated to Test Cases page");
    }
}
