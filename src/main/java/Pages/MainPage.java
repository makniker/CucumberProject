package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends BasePage{
    public MainPage(WebDriver driver)
    {
        super(driver);
    }
    public TextWindow textWindow_;
    private String xPathToUserTopic = "//*[@class = 'pf-head_itx_a']";
    private String xPathToUserName = "//*[@class='tico ellip']";
    public MainPage addTextWindow(TextWindow textWindow)
    {
        textWindow_ = textWindow;
        return this;
    }

    public MainPage postSomething(String text)
    {
        if (isElementHere(xPathToUserTopic))
        {
            clickOnElement(xPathToUserTopic);
            textWindow_.insertText(text).post();
        }
        return this;
    }

    public String getName()
    {
        if (isElementHere(xPathToUserName)) {
            return webDriver_.findElement(By.xpath(xPathToUserName)).getText();
        }
        return " ";
    }
}
