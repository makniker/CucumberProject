package steps;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    public void start() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts();
        driver.manage().window().maximize();
        driver.get("https://ok.ru");
    }

    public void finish() {
        driver.quit();
    }

}
