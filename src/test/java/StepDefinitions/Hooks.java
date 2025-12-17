package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://automationexercise.com/";

        int attempts = 0;
        boolean loaded = false;

        while (attempts < 3) {
            try {
                driver.get(url);
                loaded = true;
                break;
            } catch (Exception e) {
                attempts++;
                System.out.println("⚠ Website load failed, retrying... (" + attempts + "/3)");
            }
        }

        if (!loaded) {
            throw new RuntimeException("❌ Could NOT load AutomationExercise after 3 retries.");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
