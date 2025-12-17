package Tests;

import BaseTest.BaseTest;
import Pages.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6 extends BaseTest {

    @Test
    public void ContactUsFormSubmission(){
        Assert.assertEquals(homePage.GetExpectedlColor(), homePage.GetActualColor(), "Home page is not visible");
        ContactUsPage contactUsPage = homePage.ClickOnContactUs();
        Assert.assertEquals(contactUsPage.GetActualGetInTouchMsg(), contactUsPage.GetExpectedGetInTouchMsg(),"Get in touch message not visible");
        contactUsPage.FillContactForm("Manual User", "manual_user@gmail.com", "Automation Test", "Testing Contact Us form in Selenium");
        contactUsPage.UploadFile("C:\\DEPI AMIT\\Technical\\Project\\Cucumber BDD.docx");
        contactUsPage.ClickSubmit();
        contactUsPage.AcceptAlert();
        Assert.assertTrue(contactUsPage.GetActualSuccessMsg().contains(contactUsPage.GetExpectedSuccessMsg()), "Success message not displayed");

        homePage = contactUsPage.ClickHome();
        Assert.assertEquals(homePage.GetExpectedlColor(),homePage.GetActualColor());
    }
}
