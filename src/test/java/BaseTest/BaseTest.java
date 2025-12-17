package BaseTest;

import Pages.*;
import Pages.AccountCreation.AccountCreated;
import Pages.AccountCreation.AccountInfoPage;
import Pages.AccountCreation.LogedInPage;
import Pages.AccountCreation.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected AccountInfoPage accountInfoPage;
    protected AccountCreated accountCreated;
    protected LogedInPage logedInPage;
    protected DeleteAccPage deleteAccPage;
    protected CartPage cartPage;
    protected  ProductDetailsPage productDetailsPage;
    @BeforeClass
    public void setup(){
        FirefoxProfile profile = new FirefoxProfile();

        // Disable password saving & autofill
        profile.setPreference("signon.rememberSignons", false);
        profile.setPreference("signon.autofillForms", false);
        profile.setPreference("signon.generation.enabled", false);
        profile.setPreference("extensions.formautofill.creditCards.enabled", false);

        // Disable leak detection alerts
        profile.setPreference("signon.management.page.breach-alerts.enabled", false);

        // Block web notifications
        profile.setPreference("dom.webnotifications.enabled", false);

        // Block pop-ups
        profile.setPreference("dom.disable_open_during_load", true);

        // Attach the profile to Firefox options
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        // Initialize Firefox WebDriver
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goToHomePage(){
        driver.get("https://automationexercise.com/");

    }

   @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
