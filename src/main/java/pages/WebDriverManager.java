package pages;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverManager {

    private static WebDriver driver;

    @Before
    public static WebDriver getDriver() {
        if (driver == null) {



            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--incognito");
           driver =new ChromeDriver(opt);
           driver.manage().window().maximize();


        }
        return driver;
    }
    @After
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}
