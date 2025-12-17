package Tests;

import BaseTest.BaseTest;
import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12 extends BaseTest {

    @Test
    public void VerifyContactUsFormSubmission() throws InterruptedException {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        Assert.assertEquals(contactUsPage.GetActualGetInTouchMsg().toUpperCase(), contactUsPage.GetExpectedGetInTouchMsg());
        contactUsPage.FillContactForm("Ahmed Test", "ahmed@test.com", "Automation Test", "This is a test message.");

        contactUsPage.UploadFile("C:\\Users\\Ahmed\\Documents\\testfile.txt"); // choose any file from your computer

        contactUsPage.ClickSubmit();

        contactUsPage.AcceptAlert();

        Assert.assertEquals(contactUsPage.GetActualSuccessMsg(), contactUsPage.GetExpectedSuccessMsg());

        HomePage homePage = contactUsPage.ClickHome();


    }
}
