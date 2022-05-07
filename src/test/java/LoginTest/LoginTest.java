package LoginTest;

import Pages.DefaultPage;
import Pages.LoginPage;
import Utiles.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest {

    public static WebDriver driver;
    private static User user;

    @BeforeAll
    static void init(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://ok.ru");
        user = new User("Надя Николаева", "login", "password");
    }

    @Test
    public void LogInTest(){
        DefaultPage page = new LoginPage().doLogin(user);
        assertEquals(page.getName(), user.getFullName(), "Access denied");
    }
}