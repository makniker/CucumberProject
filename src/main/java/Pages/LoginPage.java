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

    String xPathToPassword = "//*[@id = 'field_password']";
    String xPathToButton = "//*[@class = 'button-pro __wide']";
    String xPathToLogin = "//*[@id = 'field_email']";

    public MainPage logIn(User user)
    {
        WebElement loginField = webDriver_.findElement(By.xpath(xPathToLogin));
        loginField.sendKeys(user.getLogin());
        WebElement passwordField = webDriver_.findElement(By.xpath(xPathToPassword));
        passwordField.sendKeys(user.getPassword());
        if (isElementHere(xPathToButton))
        {
            clickOnElement(xPathToButton);
        }
        return new MainPage(webDriver_);
    }
}