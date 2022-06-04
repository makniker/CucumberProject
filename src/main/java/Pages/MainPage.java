package Pages;

import Utils.TextWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends BasePage{
    public MainPage(WebDriver driver)
    {
        super(driver);
    }
    boolean isThereTextWindow_ = false;
    public Utils.TextWindow textWindow_;

    public MainPage addTextWindow(Utils.TextWindow textWindow)
    {
        isThereTextWindow_ = true;
        textWindow_ = textWindow;
        return this;
    }

    public MainPage postSomething(String text)
    {
        if (isThereTextWindow_)
        {
            String xPathToUserTopic = "//*[@class = 'pf-head_itx_a']";
            WebElement topic = webDriver_.findElement(By.xpath(xPathToUserTopic));
            topic.click();
            textWindow_.insertText(text).post();
        }
        return this;
    }

    public String getName()
    {
        String xPathToName = "//*[@class='tico ellip']";
        return webDriver_.findElement(By.xpath(xPathToName)).getText();
    }
}
