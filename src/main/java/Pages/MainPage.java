package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class MainPage extends BasePage{
    public MainPage(WebDriver driver)
    {
        super(driver);
    }
    private TextWindow textWindow_;
    private MenuWindow menuWindow_;

    private final String xPathToUserTopic = "//*[@class = 'pf-head_itx_a']";
    private final String xPathToUserName = "//*[@class='tico ellip']";

    public MainPage addTextWindow(TextWindow textWindow)
    {
        textWindow_ = textWindow;
        return this;
    }

    public MainPage addMenuWindow(MenuWindow menuWindow)
    {
        menuWindow_ = menuWindow;
        return this;
    }

    public boolean checkMenu(List<String> arg)
    {
        return menuWindow_.isAppear(arg);
    }

    public MainPage postSomething(String text)
    {
        clickOnElement(xPathToUserTopic);
        textWindow_.insertText(text).post();
        return this;
    }

    public String getName()
    {
        Assertions.assertTrue(isElementHere(xPathToUserName));
        return webDriver_.findElement(By.xpath(xPathToUserName)).getText();
    }
}
