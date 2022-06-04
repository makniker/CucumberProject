package Pages;
import Utils.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public MainPage logIn(User user)
    {
        String xPathToPassword = "//*[@id = 'field_password']";
        String xPathToButton = "//*[@class = 'button-pro __wide']";
        String xPathToLogin = "//*[@id = 'field_email']";
        WebElement loginField = webDriver_.findElement(By.xpath(xPathToLogin));
        loginField.sendKeys(user.getLogin());
        WebElement passwordField = webDriver_.findElement(By.xpath(xPathToPassword));
        passwordField.sendKeys(user.getPassword());
        webDriver_.findElement(By.xpath(xPathToButton)).click();
        return new MainPage(webDriver_);
    }
}