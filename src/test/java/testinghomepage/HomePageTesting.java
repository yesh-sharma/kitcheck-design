package testinghomepage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.percy.selenium.Percy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTesting {

    private WebDriver driver;
    private Percy percy;

    @BeforeMethod
	@BeforeClass
    public void setUp() {
        // Set up ChromeDriver (ensure chromedriver is in your PATH)
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        // Initialize Percy with the WebDriver instance
        percy = new Percy(driver);
    }

    @Test
    public void testHomepageWithPercy() {
        // Navigate to your web application
        driver.get("https://staging.kitcheck.com.au/");

        // Capture a snapshot using Percy (replace "Homepage" with your test name)
        percy.snapshot("Homepage - Figma Comparison");

        // Percy will automatically compare this with the baseline image
    }

    @AfterMethod
	@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

