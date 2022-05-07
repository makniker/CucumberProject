package Pages;

import Utiles.User;
import org.openqa.selenium.WebDriver;


public class LoginPage extends DefaultPage {

    WebDriver driver;
    private final String LOGIN_LOCATOR = ".//input[@id='field_email']";
    private final String PASSWORD_LOCATOR = ".//input[@id='field_password']";
    private final String SIGN_IN_LOCATOR = ".//input[@class = 'button-pro __wide']";

    public LoginPage() { this.driver = driver; }

    public DefaultPage doLogin(User user) {

        changeField(driver, LOGIN_LOCATOR, user.getLogIn());
        changeField(driver, PASSWORD_LOCATOR, user.getPassword());
        clickOnElement(driver, SIGN_IN_LOCATOR);

        return new DefaultPage();
    }
}
