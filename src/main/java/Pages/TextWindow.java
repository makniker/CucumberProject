package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextWindow extends BasePage
{
    String xPathToWindow = "//*[@data-module = 'postingForm/mediaText']";
    String xPathToText = "//*[@class = 'media-text_a']";
    String xPathToButton = "//*[@class = 'posting_submit button-pro']";

    public TextWindow(WebDriver driver)
    {
        super(driver);
    }

    public TextWindow insertText(String text)
    {
        if (isElementHere(xPathToWindow))
        {
            webDriver_.findElement(By.xpath(xPathToWindow)).sendKeys(text);
        }
        return this;
    }

    public String getText()
    {
        return webDriver_.findElement(By.xpath(xPathToText)).getText();
    }

    public TextWindow post()
    {
        if (isElementHere(xPathToButton))
        {
            clickOnElement(xPathToButton);
        }
        return this;
    }
}
